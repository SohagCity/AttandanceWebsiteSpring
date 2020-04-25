package uk.ac.city.aczj234.attendance.services;

import uk.ac.city.aczj234.attendance.entites.Student;
/**
 * A service interface containing methods used by the controllers
 * to record and retrieve student information.
 */
public interface StudentService {
    void addStudent(Student student);
    void deleteStudent(Student student);
    Student getStudent(String studentID);
}
