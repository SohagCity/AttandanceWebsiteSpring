package uk.ac.city.aczj234.attendance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.aczj234.attendance.entites.CollatedUser;
import uk.ac.city.aczj234.attendance.services.ProfileService;

@Controller
public class ProfileController {

    /**
     * The profile service which generates a "CollatedUser" object that contains references
     * to each of the domain objects (TeacherUser, Schedule (as a list), LoginHistory (as a list)
     *
     */
    private ProfileService profileService;

    /**
     * Constructor based dependency injection of the profile service.
     *
     * @param profileService
     */
    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    /**
     * Controller method to respond to GET requests to the /profile endpoint.
     *
     * @return ModelAndView an object that returns the profile.html view combined with the data
     * for the current logged in user (user info, schedule list, login history list)
     */
    @RequestMapping(value="/profile")
    public ModelAndView showProfile(){
        //Retrieves the email address of the currently logged in user.
        String teacherID = SecurityContextHolder.getContext().getAuthentication().getName();
        CollatedUser user = profileService.getProfile(teacherID);
        return new ModelAndView("profile", "collatedUser", user);
    }

}
