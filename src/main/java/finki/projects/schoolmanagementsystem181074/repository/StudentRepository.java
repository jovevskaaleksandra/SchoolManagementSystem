package finki.projects.schoolmanagementsystem181074.repository;

import finki.projects.schoolmanagementsystem181074.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByIndex(String index);

    void deleteByIndex(String index);

    List<Student> findAllById(Long studentId);
}
