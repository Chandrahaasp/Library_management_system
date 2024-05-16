package org.cts.lms.service;

import java.util.List;
import java.util.Optional;

import org.cts.lms.entities.Book;
import org.cts.lms.entities.BookTransactions;
import org.cts.lms.entities.RequestNewBook;
import org.cts.lms.entities.Student;
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
public class StudentServiceImpl implements StudentService{
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private BookTransactionsRepository bookTransactionsRepository;
	@Autowired
	RequestNewBookRepository requestNewBookRepository;
	
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
	public List<BookTransactions> getStudentHistory(int studentId) throws StudentNotFoundException{
		try {
			return bookTransactionsRepository.getById(studentId);
		}catch(DataAccessException e) {
			throw new StudentNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new StudentNotFoundException(e.getMessage());
		}
	}
	public String requestUnavailableBook(RequestNewBook requestNewBook){
			requestNewBookRepository.save(requestNewBook);
			return "The Request is Successful";
	}
	public Student updateStudent(Student student) throws StudentNotFoundException {
		try {
			return studentRepository.save(student);
		}catch(DataAccessException e) {
			throw new StudentNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new StudentNotFoundException(e.getMessage());
		}	
	}
}
