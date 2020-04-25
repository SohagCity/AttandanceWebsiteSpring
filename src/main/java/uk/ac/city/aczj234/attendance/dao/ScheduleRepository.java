package uk.ac.city.aczj234.attendance.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.city.aczj234.attendance.entites.Schedule;
/**
 * Class to access the database table backing the Schedule entity.
 */
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {

}
