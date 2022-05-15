package finki.projects.schoolmanagementsystem181074.repository;

import finki.projects.schoolmanagementsystem181074.model.Class1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClassRepository extends JpaRepository<Class1, Integer> {

    Iterable<Class1> findBySchoolYearId(Integer id);

    Iterable<Class1> findByNameContaining(String name);

    //Optional<Class1> findByCId(Integer id);

    void delete(Class1 s);
}

