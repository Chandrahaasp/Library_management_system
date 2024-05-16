package org.cts.lms.repository;

import org.cts.lms.entities.Book;
import org.cts.lms.entities.RequestNewBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@Repository
@EnableJpaRepositories
public interface RequestNewBookRepository extends JpaRepository<RequestNewBook,Integer>{
	//@Query(value = "select * from unavailable_books where title = ?1" , nativeQuery = true)
		//String requestNewBook(RequestNewBook requestNewbook);//
}
