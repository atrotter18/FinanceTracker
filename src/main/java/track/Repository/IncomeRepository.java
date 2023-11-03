package track.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import track.bean.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
}
