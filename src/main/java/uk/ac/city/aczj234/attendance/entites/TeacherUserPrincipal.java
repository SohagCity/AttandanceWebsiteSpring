package uk.ac.city.aczj234.attendance.entites;

import java.nio.file.attribute.UserPrincipal;

/**
 * An OperaUserPricipal represents the current user in the user details service.
 */
public class TeacherUserPrincipal implements UserPrincipal {

    private TeacherUser teacherUser;

    public TeacherUserPrincipal(TeacherUser teacherUser){
        this.teacherUser = teacherUser;
    }

    @Override
    public String getName() {
        return teacherUser.getTeacherID();
    }


}
