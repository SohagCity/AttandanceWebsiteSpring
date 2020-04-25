package uk.ac.city.aczj234.attendance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.city.aczj234.attendance.dao.StudentRepository;
import uk.ac.city.aczj234.attendance.entites.Student;

@Service
public class StudentServiceImpl implements StudentService {
    /**
     * The StudentRepository for interacting with the database table backing the
     * Booking entity.
     */
    private StudentRepository studentRepository;
    /**
     * Constructor based dependency injection of the student repository.
     * @param
     */
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    /**
     * Implemented method using the studentRepository to save the student data.
     *
     * @param student that contains the student data.
     */
    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }
    /**
     * Implemented method using the studentRepository to delete student data.
     *
     * @param student that contains the student data.
     */
    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
    /**
     * Implemented method using the studentRepository to get student data.
     *
     * @param studentID that contains the student data.
     */
    @Override
    public Student getStudent(String studentID) {
        Student student= studentRepository.findById(studentID).orElse(studentRepository.getOne("0"));
        return student;
    }
}
