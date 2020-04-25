package uk.ac.city.aczj234.attendance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.city.aczj234.attendance.dao.ScheduleRepository;
import uk.ac.city.aczj234.attendance.dao.TeacherRepository;
import uk.ac.city.aczj234.attendance.entites.Schedule;
import uk.ac.city.aczj234.attendance.entites.TeacherUser;

@Service
public class ScheduleServiceImpl implements ScheduleService{
    /**
     * The repository for schedule data.
     */
    private ScheduleRepository scheduleRepository;

    /**
     * Constructor based dependency injection
     *
     * @param scheduleRepository the schedule user repo.
     */
    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    /**
     * Saves a schedule to the database.
     *
     * @param schedule the schedule to be saved.
     */
    @Override
    public void addSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }
}
