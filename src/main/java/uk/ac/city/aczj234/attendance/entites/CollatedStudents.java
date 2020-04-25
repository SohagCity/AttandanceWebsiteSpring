package uk.ac.city.aczj234.attendance.entites;

import java.util.List;
/**
 * An Entity class containing a list of all the students.
 *
 * */
public class CollatedStudents {

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
