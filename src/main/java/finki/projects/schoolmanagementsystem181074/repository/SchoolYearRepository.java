package finki.projects.schoolmanagementsystem181074.repository;

import finki.projects.schoolmanagementsystem181074.model.SchoolYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolYearRepository extends JpaRepository<SchoolYear, Integer> {

    Iterable<SchoolYear> findFirst5ByOrderByIdDesc();

    boolean findById(SchoolYear id);
}
