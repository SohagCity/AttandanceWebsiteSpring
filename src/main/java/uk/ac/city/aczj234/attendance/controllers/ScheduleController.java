package uk.ac.city.aczj234.attendance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uk.ac.city.aczj234.attendance.entites.Schedule;

import uk.ac.city.aczj234.attendance.services.ScheduleService;

@Controller
public class ScheduleController {


    /**
     * The schedule service which is used to save schedules to the
     * database.
     */
    private ScheduleService scheduleService;

    /**
     * Constructor based dependency injection of the registration service
     *
     * @param scheduleService
     */
    @Autowired
    public ScheduleController (ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

    /**
     * Controller method to handle a get request to the /scheduleRegister endpoint
     *
     * @return ModelAndView an object that combines the scheduleRegister.html page with a Schedule
     * object that can be filled out with schedule data to be saved to the database.
     */
    @RequestMapping(value = "/scheduleRegister", method = RequestMethod.GET)
    public ModelAndView showRegistation(){
        Schedule schedule = new Schedule();
        return new ModelAndView("scheduleRegister", "schedule", schedule);
    }

    /**
     * Controller method to handle a post request to the /scheduleRegister endpoint
     *
     * @param schedule the schedule object that contains the the information to
     *                be saved to the database.
     * @return String a redirect to the profile page.
     */
    @RequestMapping(value = "/scheduleRegister", method = RequestMethod.POST)
    public String processRegistration(Schedule schedule){
        String teacherID = SecurityContextHolder.getContext().getAuthentication().getName();
        schedule.setTeacherID(teacherID);
        scheduleService.addSchedule(schedule);
        return "redirect:/profile";
    }

}
