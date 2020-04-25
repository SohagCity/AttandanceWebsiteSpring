package uk.ac.city.aczj234.attendance.services;

import uk.ac.city.aczj234.attendance.entites.TeacherUser;

/**
 * Registration service interface that specifies a method to save user information to the database.
 */
public interface RegistrationService {

    void registerUser(TeacherUser teacherUser);
}
