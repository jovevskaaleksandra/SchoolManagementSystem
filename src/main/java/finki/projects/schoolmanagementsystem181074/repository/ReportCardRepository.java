package finki.projects.schoolmanagementsystem181074.repository;

import finki.projects.schoolmanagementsystem181074.model.ReportCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportCardRepository extends JpaRepository<ReportCard,Long> {
}
