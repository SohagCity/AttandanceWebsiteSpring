package uk.ac.city.aczj234.attendance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.city.aczj234.attendance.dao.HistoryRepository;
import uk.ac.city.aczj234.attendance.dao.ScheduleRepository;
import uk.ac.city.aczj234.attendance.dao.TeacherRepository;
import uk.ac.city.aczj234.attendance.entites.CollatedUser;
import uk.ac.city.aczj234.attendance.entites.LoginHistory;
import uk.ac.city.aczj234.attendance.entites.Schedule;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {


    /**
     * The repository for opera user data.
     */
    private TeacherRepository teacherRepository;

    /**
     * The repository for login history.
     */
    private HistoryRepository historyRepository;
    /**
     * The repository for schedule data.
     */
    private ScheduleRepository scheduleRepository;

    /**
     *
     * Constructor based dependency injection of repositories.
     *
     * @param teacherRepository the opera user repo
     * @param historyRepository the login history repo
     */
    @Autowired
    public ProfileServiceImpl(TeacherRepository teacherRepository,
                              HistoryRepository historyRepository,
                              ScheduleRepository scheduleRepository){
        this.teacherRepository = teacherRepository;
        this.historyRepository = historyRepository;
        this.scheduleRepository=scheduleRepository;
    }

    /**
     * The implemented method that collates all the current users information
     * into a single object that will back the profile.html view
     *
     * @param teacherID the current user's email
     * @return CollatedUser a object that aggregates all the user's data.
     */
    @Override
    public CollatedUser getProfile(String teacherID) {
        CollatedUser user = new CollatedUser();
        user.setTeacherUser(teacherRepository.findById(teacherID).orElseThrow(()-> new UsernameNotFoundException("No matching user found.")));

        List<Schedule> schedules = scheduleRepository.findAll()
                .stream().filter(schedule -> schedule.getTeacherID().equals(teacherID))
                .collect(Collectors.toList());
        user.setSchedules(schedules);

        List<LoginHistory> history = historyRepository.findAll()
                .stream().filter(loginHistory -> loginHistory.getTeacherID().equals(teacherID))
                .collect(Collectors.toList());
        user.setLogins(history);
        return user;
    }
}
