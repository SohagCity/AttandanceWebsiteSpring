package uk.ac.city.aczj234.attendance.entites;

import java.util.List;
/**
 * An Entity class representing all of the information relevant to a specific operauser including
 * their bookings and login history.
 *
 * */
public class CollatedUser{

    private TeacherUser teacherUser;
    private List<LoginHistory> logins;
    private List<Schedule> schedules;

    public TeacherUser getTeacherUser() {
        return teacherUser;
    }

    public void setTeacherUser(TeacherUser teacherUser) {
        this.teacherUser = teacherUser;
    }


    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public List<LoginHistory> getLogins() {
        return logins;
    }

    public void setLogins(List<LoginHistory> logins) {
        this.logins = logins;
    }
}
