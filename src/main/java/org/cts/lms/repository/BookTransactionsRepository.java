package org.cts.lms.repository;

import java.util.List;

import org.cts.lms.entities.BookTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookTransactionsRepository extends JpaRepository<BookTransactions , Integer>{
	@Query(value = "select * from book_history where student_id=?1 ", nativeQuery = true)
	List<BookTransactions> getById(int studentId);
}
