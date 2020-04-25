package uk.ac.city.aczj234.attendance.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * A controller to handle GET requests to the home page
 *
 */
@Controller
public class IndexController {
    /**
     * Controller method to handle a GET request to the / endpoint (homepage)
     *
     * @return ModelAndView returns a view constructed from index.html (no model required)
     */
    @RequestMapping (value = "/")
    public ModelAndView showHome(){
        return new ModelAndView("index");
    }
    @RequestMapping (value = "/studentsList")
    public ModelAndView showStudentList(){
        return new ModelAndView("studentsList");
    }
}
