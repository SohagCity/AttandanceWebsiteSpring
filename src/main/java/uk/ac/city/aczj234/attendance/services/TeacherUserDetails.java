package uk.ac.city.aczj234.attendance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.city.aczj234.attendance.dao.HistoryRepository;
import uk.ac.city.aczj234.attendance.dao.TeacherRepository;
import uk.ac.city.aczj234.attendance.entites.LoginHistory;
import uk.ac.city.aczj234.attendance.entites.TeacherUser;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Custom authentication service which includes recording login history
 * each time a user is authenticated.
 */
@Service
public class TeacherUserDetails implements UserDetailsService {


    /**
     * The repository for user data.
     */
    private TeacherRepository teacherRepository;
    /**
     * The repository for login history
     */
    private HistoryRepository historyRepository;

    /**
     * Constructor based dependency injection of repositories.
     *
     * @param teacherRepository the user repo
     * @param historyRepository the login history repo
     */
    @Autowired
    public TeacherUserDetails(TeacherRepository teacherRepository, HistoryRepository historyRepository){
        this.teacherRepository = teacherRepository;
        this.historyRepository = historyRepository;
    }

    /**
     * The override fo the UserDetailsService method that validates a user. The methods finds the
     * user in the database based on the String s provided by the users login credentials (their teacherID)
     *
     * @param s user's teacherID address provided when logging in.
     * @return UserDetails an object representing the user including their password, account status and roles
     * @throws UsernameNotFoundException if the user cannot be found in the database
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TeacherUser teacherUser = teacherRepository.findById(s).orElseThrow(()-> new UsernameNotFoundException("No matching user."));
        //if the first line does not throw the exception the login history
        //object will be constructed and saved to the database.
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setTeacherID(teacherUser.getTeacherID());
        loginHistory.setTime(LocalDateTime.now());
        historyRepository.save(loginHistory);
        //and a UserDetails object will be constructed and returned.
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(teacherUser.getAuthoritiy()));
        return new User
                (teacherUser.getTeacherID(), teacherUser.getPassword(), teacherUser.getEnabled(),
                        true, true, true, authorities);

    }
}
