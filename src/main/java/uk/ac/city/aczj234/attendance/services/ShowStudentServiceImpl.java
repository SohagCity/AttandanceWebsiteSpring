package uk.ac.city.aczj234.attendance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.city.aczj234.attendance.dao.StudentRepository;
import uk.ac.city.aczj234.attendance.entites.CollatedStudents;
import uk.ac.city.aczj234.attendance.entites.Student;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowStudentServiceImpl implements ShowStudentService {
    private StudentRepository studentRepository;

    /**
     *
     * Constructor based dependency injection of repositories.
     *
     * @param studentRepository the student repo
     */
    @Autowired
    public ShowStudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    /**
     * The implemented method that collates all the students information
     * into a single object that will back the studentPorfile.html view
     *
     * @param classID the classes the user has scheduled.
     */
    @Override
    public CollatedStudents getStudents(String classID) {
        CollatedStudents user=new CollatedStudents();
        List<Student> students = studentRepository.findAll()
                .stream().filter(schedule -> schedule.getClassID().equals(classID))
                .collect(Collectors.toList());
        user.setStudents(students);
        return user;
    }
}
