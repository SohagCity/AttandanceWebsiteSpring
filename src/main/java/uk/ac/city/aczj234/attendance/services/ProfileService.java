package uk.ac.city.aczj234.attendance.services;

import uk.ac.city.aczj234.attendance.entites.CollatedUser;

/**
 * Profile service interface that specifies a method to return a CollatedUser.
 */
public interface ProfileService {

    CollatedUser getProfile(String teacherID);
}
