package org.cts.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.cts.lms.entities.Admin;
import org.cts.lms.entities.Book;
import org.cts.lms.entities.BookTransactions;
import org.cts.lms.entities.RequestNewBook;
import org.cts.lms.exceptions.AdminAlreadyExistsException;
import org.cts.lms.exceptions.AdminNotFoundException;
import org.cts.lms.exceptions.BookAlreadyExistsException;
import org.cts.lms.exceptions.BookNotFoundException;
import org.cts.lms.exceptions.StudentNotFoundException;
import org.cts.lms.repository.AdminRepository;
import org.cts.lms.repository.BookRepository;
import org.cts.lms.repository.BookTransactionsRepository;
import org.cts.lms.repository.RequestNewBookRepository;
import org.cts.lms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private BookTransactionsRepository bookTransactionsRepository;
	@Autowired
	private RequestNewBookRepository requestNewBookRepository;
	
	@Override
	public Book addBook(Book book) throws BookAlreadyExistsException {
		try {
			return bookRepository.save(book);
		}catch(DataAccessException e) {
			throw new BookAlreadyExistsException(e.getMessage());
		}catch(Exception e) {
			throw new BookAlreadyExistsException(e.getMessage());
		}
	}

	@Override
	public Book updateBook(Book book) throws BookNotFoundException {
		try {
			return bookRepository.save(book);
		}catch(DataAccessException e) {
			throw new BookNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new BookNotFoundException(e.getMessage());
		}
		
	}

	@Override
	public String deleteBook(int bookId) throws BookNotFoundException {
		try {
			bookRepository.deleteById(bookId);
			return "Book deleted successfully";
		}catch(DataAccessException e) {
			throw new BookNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new BookNotFoundException(e.getMessage());
		}
	}

	@Override
	public Book getBookById(int bookId) throws BookNotFoundException {
		try {
			Optional<Book> optional=bookRepository.findById(bookId);
			if(optional.isPresent()) {
				return optional.get();
			}
			else {
				throw new Exception("Invalid Book Id");
			}
		}catch(DataAccessException e) {
			throw new BookNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new BookNotFoundException(e.getMessage());
		}
	}
	public Book getBookByName(String bookName) throws BookNotFoundException{
		try {
			return bookRepository.getByName(bookName);
		}catch(DataAccessException e) {
			throw new BookNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new BookNotFoundException(e.getMessage());
		}
	}
	@Override
	public String deleteStudent(int studentId) throws StudentNotFoundException {
		try {
			studentRepository.deleteById(studentId);
			return "Student deleted successfully";
		}catch(DataAccessException e) {
			throw new StudentNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new StudentNotFoundException(e.getMessage());
		}
	}
	public List<BookTransactions> getStudentHistory(int studentId) throws StudentNotFoundException{
		try {
			return bookTransactionsRepository.getById(studentId);
		}catch(DataAccessException e) {
			throw new StudentNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new StudentNotFoundException(e.getMessage());
		}
	}
	public List<RequestNewBook> getRequestedBooks() throws BookAlreadyExistsException{
		try {
			return requestNewBookRepository.findAll();
		}catch(DataAccessException e) {
			throw new BookAlreadyExistsException(e.getMessage());
		}catch(Exception e) {
			throw new BookAlreadyExistsException(e.getMessage());
		}
	}
	public String addBookTransaction(BookTransactions bookTransactions) throws StudentNotFoundException{
		try {
			bookTransactionsRepository.save(bookTransactions);
			return "Book Dispatched";
		}catch(DataAccessException e) {
			throw new StudentNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new StudentNotFoundException(e.getMessage());
		}
	}
	@Override
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException {
		try {
			return adminRepository.save(admin);
		}catch(DataAccessException e) {
			throw new AdminNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new AdminNotFoundException(e.getMessage());
		}
	}

	@Override
	public Admin addAdmin(Admin admin) throws AdminAlreadyExistsException {
		try {
			return adminRepository.save(admin);
		}catch(DataAccessException e) {
			throw new AdminAlreadyExistsException(e.getMessage());
		}catch(Exception e) {
			throw new AdminAlreadyExistsException(e.getMessage());
		}
	}

	@Override
	public String deleteAdmin(int adminId) throws AdminNotFoundException {
		try {
			adminRepository.deleteById(adminId);
			return "Admin deleted successfully";
		}catch(DataAccessException e) {
			throw new AdminNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new AdminNotFoundException(e.getMessage());
		}
	}

	@Override
	public Admin getAdminById(int adminId) throws AdminNotFoundException {
		try {
			Optional<Admin> optional=adminRepository.findById(adminId);
			if(optional.isPresent()) {
				return optional.get();
			}
			else {
				throw new Exception("Invalid Admin Id");
			}
		}catch(DataAccessException e) {
			throw new AdminNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new AdminNotFoundException(e.getMessage());
		}
	}

}
