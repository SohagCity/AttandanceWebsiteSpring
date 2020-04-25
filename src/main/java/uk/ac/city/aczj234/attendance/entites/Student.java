package uk.ac.city.aczj234.attendance.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * An Entity class representing the information required for a given user to register
 * a new student.
 */
@Entity
public class Student {

    @Id
    private String studentID;
    private String firstName;
    private String lastName;
    private int presentNo;
    private int absentNo;
    private String classID;

    public Student(){}

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPresentNo() {
        return presentNo;
    }

    public void setPresentNo(int presentNo) {
        this.presentNo = presentNo;
    }

    public int getAbsentNo() {
        return absentNo;
    }

    public void setAbsentNo(int absentNo) {
        this.absentNo = absentNo;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }
}
