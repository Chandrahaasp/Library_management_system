package org.cts.lms.service;

import java.util.List;

import org.cts.lms.entities.Admin;
import org.cts.lms.entities.Book;
import org.cts.lms.entities.BookTransactions;
import org.cts.lms.entities.RequestNewBook;
import org.cts.lms.exceptions.AdminAlreadyExistsException;
import org.cts.lms.exceptions.AdminNotFoundException;
import org.cts.lms.exceptions.BookAlreadyExistsException;
import org.cts.lms.exceptions.BookNotFoundException;
import org.cts.lms.exceptions.StudentNotFoundException;

public interface AdminService {
	Book addBook(Book book) throws BookAlreadyExistsException;
	Book updateBook(Book book) throws BookNotFoundException;
	String deleteBook(int bookId) throws BookNotFoundException;
	Book getBookById(int bookId) throws BookNotFoundException;
	Book getBookByName(String bookName) throws BookNotFoundException;
	List<RequestNewBook> getRequestedBooks() throws BookAlreadyExistsException;
	
	String deleteStudent(int studentId) throws StudentNotFoundException;
	List<BookTransactions> getStudentHistory(int studentId) throws StudentNotFoundException;
	String addBookTransaction(BookTransactions bookTransactions) throws StudentNotFoundException;
	
	Admin updateAdmin(Admin admin) throws AdminNotFoundException;
	Admin addAdmin(Admin admin) throws AdminAlreadyExistsException;
	String deleteAdmin(int adminId) throws AdminNotFoundException;
	Admin getAdminById(int adminId) throws AdminNotFoundException;
}
