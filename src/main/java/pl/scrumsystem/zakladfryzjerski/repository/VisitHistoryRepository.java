package pl.scrumsystem.zakladfryzjerski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scrumsystem.zakladfryzjerski.entity.VisitHistory;

@Repository
public interface VisitHistoryRepository extends JpaRepository<VisitHistory, Long>
{

}
