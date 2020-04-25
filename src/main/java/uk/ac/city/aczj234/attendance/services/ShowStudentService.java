package uk.ac.city.aczj234.attendance.services;

import uk.ac.city.aczj234.attendance.entites.CollatedStudents;
/**
 * show student service interface that specifies a method to return a CollatedStudent.
 */
public interface ShowStudentService {
    CollatedStudents getStudents(String classID);
}
