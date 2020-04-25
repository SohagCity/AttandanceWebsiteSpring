package uk.ac.city.aczj234.attendance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.aczj234.attendance.entites.CollatedUser;
import uk.ac.city.aczj234.attendance.entites.Student;
import uk.ac.city.aczj234.attendance.services.StudentService;

@Controller
public class StudentController {

    /**
     * The student service which is used to save students to the
     * database.
     */
    private StudentService studentService;
    private String s;
    /**
     * Constructor based dependency injection of the student service
     *
     * @param studentService
     */
    @Autowired
    public StudentController (StudentService studentService){
        this.studentService = studentService;
    }

    /**
     * Controller method to handle a get request to the /studentRegister endpoint
     *
     * @return ModelAndView an object that combines the book.html page with a Student
     * object that can be filled out with student data to be saved to the database.
     */
    @RequestMapping(value = "/studentRegister", method = RequestMethod.GET)
    public ModelAndView showRegistration(){
        Student student = new Student();
        return new ModelAndView("studentRegister", "student", student);
    }

    /**
     * Controller method to handle a post request to the /studentRegister endpoint
     *
     * @param student the student object that contains the the information to
     *                be saved to the database.
     * @return String a redirect to the profile page.
     */
    @RequestMapping(value = "/studentRegister", method = RequestMethod.POST)
    public String processRegistration(Student student){
        student.setAbsentNo(0);
        student.setPresentNo(0);
        studentService.addStudent(student);
        return "redirect:/profile";
    }

    /**
     * Controller method to respond to GET requests to the /studentProfile endpoint.
     * @param studentID Student ID which gets requested from teh html page.
     * @return ModelAndView an object that returns the studentProfile.html view combined with the data
     * of the student searched.
     */
    @RequestMapping(value="/studentProfile", method = RequestMethod.GET)
    public ModelAndView showProfile(@RequestParam(defaultValue = "0") String studentID){
        //Retrieves the email address of the currently logged in user.
        Student student = studentService.getStudent(studentID);
        s=studentID;
        return new ModelAndView("studentProfile","student", student);
    }

    /**
     * Controller method to handle a post request to the /addAttendance endpoint.
     * Increases by 1 the present number of the latest searched student.
     * @return String a redirect to the studentProfile page of the last searched student.
     */
    @RequestMapping(value="/addAttendance", method = RequestMethod.POST)
    public String addAttendance(){
        //Retrieves the email address of the currently logged in user.
        Student student = studentService.getStudent(s);
        student.setPresentNo(student.getPresentNo()+1);
        studentService.deleteStudent(studentService.getStudent(s));
        studentService.addStudent(student);
        return "redirect:/studentProfile?studentID=" +s;
    }

    /**
     * Controller method to handle a post request to the /addAbsence endpoint.
     * Increases by 1 the absent number of the latest searched student.
     * @return String a redirect to the studentProfile page of the last searched student.
     */
    @RequestMapping(value="/addAbsence", method = RequestMethod.POST)
    public String addAbsence(){
        //Retrieves the email address of the currently logged in user.
        Student student = studentService.getStudent(s);
        student.setAbsentNo(student.getAbsentNo()+1);
        studentService.deleteStudent(studentService.getStudent(s));
        studentService.addStudent(student);
        return "redirect:/studentProfile?studentID=" +s;
    }

}