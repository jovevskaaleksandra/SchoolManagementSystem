package finki.projects.schoolmanagementsystem181074.repository;

import finki.projects.schoolmanagementsystem181074.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
