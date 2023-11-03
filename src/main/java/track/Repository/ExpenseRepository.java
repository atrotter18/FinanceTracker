package track.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import track.bean.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}


