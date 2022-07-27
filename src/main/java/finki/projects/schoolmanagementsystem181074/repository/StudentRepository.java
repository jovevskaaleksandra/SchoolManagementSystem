package finki.projects.schoolmanagementsystem181074.repository;

import finki.projects.schoolmanagementsystem181074.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
