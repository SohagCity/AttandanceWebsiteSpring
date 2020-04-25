package uk.ac.city.aczj234.attendance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.city.aczj234.attendance.entites.Student;
/**
 * Class to access the database table backing the Student entity.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}

