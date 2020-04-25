package uk.ac.city.aczj234.attendance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.aczj234.attendance.entites.CollatedStudents;
import uk.ac.city.aczj234.attendance.services.ShowStudentService;

@Controller
public class ShowStudentController {
    /**
     * The showStudent service which generates a "CollatedStudents" object that contains a list of
     * all students.
     *
     */
    private ShowStudentService showStudentService;

    /**
     * Constructor based dependency injection of the showStudent service.
     *
     * @param showStudentService
     */
    @Autowired
    public ShowStudentController(ShowStudentService showStudentService){
        this.showStudentService = showStudentService;
    }

    /**
     * Controller method to handle a post request to the /studentsList endpoint
     *
     * @param classID Class ID which gets requested from teh html page.
     * @return String a redirect to the studentList page.
     */
    @RequestMapping(value="/studentsList", method = RequestMethod.GET)
    public ModelAndView showProfile(@RequestParam(defaultValue = "0") String classID){
        //Retrieves the email address of the currently logged in user.
        CollatedStudents students = showStudentService.getStudents(classID);
        return new ModelAndView("studentsList","students", students);
    }
}
