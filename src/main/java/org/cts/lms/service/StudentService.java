package org.cts.lms.service;

import java.util.List;

import org.cts.lms.entities.Book;
import org.cts.lms.entities.BookTransactions;
import org.cts.lms.entities.RequestNewBook;
import org.cts.lms.entities.Student;
import org.cts.lms.exceptions.BookAlreadyExistsException;
import org.cts.lms.exceptions.BookNotFoundException;
import org.cts.lms.exceptions.StudentNotFoundException;

public interface StudentService {
	Book getBookById(int bookId) throws BookNotFoundException;
	Book getBookByName(String bookName) throws BookNotFoundException;
	
	Student updateStudent(Student student) throws StudentNotFoundException;
	List<BookTransactions> getStudentHistory(int studentId) throws StudentNotFoundException;
	String requestUnavailableBook(RequestNewBook RequestNewbook);
}
