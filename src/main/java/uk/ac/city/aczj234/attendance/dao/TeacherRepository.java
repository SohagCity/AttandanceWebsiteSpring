package uk.ac.city.aczj234.attendance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.city.aczj234.attendance.entites.TeacherUser;

/**
 * Class to access the database table backing the TeacherUser entity.
 */
@Repository
public interface TeacherRepository extends JpaRepository<TeacherUser, String> {

}
