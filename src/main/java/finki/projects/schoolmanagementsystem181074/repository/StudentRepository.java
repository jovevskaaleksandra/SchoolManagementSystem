package finki.projects.schoolmanagementsystem181074.repository;

import finki.projects.schoolmanagementsystem181074.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Iterable<Student> findByNameOrForenameContaining(String name, String forename);

    Iterable<Student> findByNameContaining(String q);
}
