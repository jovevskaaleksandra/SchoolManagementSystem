package finki.projects.schoolmanagementsystem181074.repository;

import finki.projects.schoolmanagementsystem181074.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByName(String name);

    void deleteByName(String name);

    List<Course> findAllById(Long courseId);
}
