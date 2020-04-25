package uk.ac.city.aczj234.attendance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.city.aczj234.attendance.dao.TeacherRepository;
import uk.ac.city.aczj234.attendance.entites.TeacherUser;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    /**
     * The repository for user data.
     */
    private TeacherRepository teacherRepository;

    /**
     * Constructor based dependency injection
     *
     * @param teacherRepository the teacher user repo.
     */
    @Autowired
    public RegistrationServiceImpl(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    /**
     * Saves a teacher user to the database.
     *
     * @param teacherUser the teacher user to be saved.
     */
    @Override
    public void registerUser(TeacherUser teacherUser) {
        teacherRepository.save(teacherUser);
    }
}
