package org.cts.lms.controller;

import java.util.List;
import org.cts.lms.entities.Book;
import org.cts.lms.entities.BookTransactions;
import org.cts.lms.entities.RequestNewBook;
import org.cts.lms.entities.Student;
import org.cts.lms.exceptions.BookAlreadyExistsException;
import org.cts.lms.exceptions.BookNotFoundException;
import org.cts.lms.exceptions.StudentNotFoundException;
import org.cts.lms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/lms/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PutMapping("/updatestudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws StudentNotFoundException{
		try {
			Student student1 = studentService.updateStudent(student);
			return new ResponseEntity<>(student1 , HttpStatus.OK);
		}catch(StudentNotFoundException e) {
			throw new StudentNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@GetMapping("/getbookbyid/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable int bookId) throws BookNotFoundException{
		try {
			Book book1 = studentService.getBookById(bookId);
			return new ResponseEntity<>(book1 , HttpStatus.OK);
		}catch(BookNotFoundException e) {
			throw new BookNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@GetMapping("/getbookbyname/{bookName}")
	public ResponseEntity<Book> getBookByName(@PathVariable String bookName) throws BookNotFoundException{
		try {
			Book book = studentService.getBookByName(bookName);
			return new ResponseEntity<>(book , HttpStatus.OK);
		}catch(BookNotFoundException e) {
			throw new BookNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@GetMapping("/getstudenthistory/{studentId}")
	public ResponseEntity<List<BookTransactions>> getStudentHistory(@PathVariable int studentId) throws StudentNotFoundException{
		try {
			List<BookTransactions> books = studentService.getStudentHistory(studentId);
			return new ResponseEntity<>(books , HttpStatus.OK);
		}catch(StudentNotFoundException e) {
			throw new StudentNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@PostMapping("/requestnewbook")
	public ResponseEntity<String> getRequestedBooks(@RequestBody RequestNewBook requestNewBook){
			String str = studentService.requestUnavailableBook(requestNewBook);
			//String str="added successfully ";
			return new ResponseEntity<>(str , HttpStatus.OK);
	}
}
