package uk.ac.city.aczj234.attendance.services;

import uk.ac.city.aczj234.attendance.entites.Schedule;
/**
 * A service interface containing methods used by the controllers
 * to record and retrieve schedule information.
 */
public interface ScheduleService {
    void addSchedule(Schedule schedule);
}
