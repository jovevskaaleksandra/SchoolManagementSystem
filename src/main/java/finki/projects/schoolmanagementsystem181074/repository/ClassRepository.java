package finki.projects.schoolmanagementsystem181074.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClassRepository extends JpaRepository<Class, Integer> {

    Iterable<Class> findBySchoolYearId(Integer id);

    Iterable<Class> findByNameContaining(String name);

}

