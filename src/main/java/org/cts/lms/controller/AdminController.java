package org.cts.lms.controller;

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
import org.cts.lms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/lms/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/addbook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) throws BookAlreadyExistsException{
		try {
			Book book1 = adminService.addBook(book);
			return new ResponseEntity<>(book1 , HttpStatus.OK);
		}catch(BookAlreadyExistsException e) {
			throw new BookAlreadyExistsException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@PutMapping("/updatebook")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) throws BookNotFoundException{
		try {
			Book book1 = adminService.updateBook(book);
			return new ResponseEntity<>(book1 , HttpStatus.OK);
		}catch(BookNotFoundException e) {
			throw new BookNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@DeleteMapping("/deletebook/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable int bookId) throws BookNotFoundException{
		try {
			String str = adminService.deleteBook(bookId);
			return new ResponseEntity<>(str , HttpStatus.NO_CONTENT);
		}catch(BookNotFoundException e) {
			throw new BookNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@GetMapping("/getbookbyid/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable int bookId) throws BookNotFoundException{
		try {
			Book book1 = adminService.getBookById(bookId);
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
			Book book = adminService.getBookByName(bookName);
			return new ResponseEntity<>(book , HttpStatus.OK);
		}catch(BookNotFoundException e) {
			throw new BookNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@DeleteMapping("/deletestudent/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable int studentId) throws StudentNotFoundException{
		try {
			String str = adminService.deleteStudent(studentId);
			return new ResponseEntity<>(str , HttpStatus.NO_CONTENT);
		}catch(StudentNotFoundException e) {
			throw new StudentNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@GetMapping("/getstudenthistory/{studentId}")
	public ResponseEntity<List<BookTransactions>> getStudentHistory(@PathVariable int studentId) throws StudentNotFoundException{
		try {
			List<BookTransactions> books = adminService.getStudentHistory(studentId);
			return new ResponseEntity<>(books , HttpStatus.OK);
		}catch(StudentNotFoundException e) {
			throw new StudentNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@PostMapping("/addbooktransaction")
	public ResponseEntity<String> addBookTransaction(@RequestBody BookTransactions bookTransactions) throws StudentNotFoundException{
		try {
			String status = adminService.addBookTransaction(bookTransactions);
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@GetMapping("/getrequestedbooks")
	public ResponseEntity<List<RequestNewBook>> getRequestedBooks() throws BookAlreadyExistsException{
		try {
			List<RequestNewBook> books = adminService.getRequestedBooks();
			return new ResponseEntity<>(books , HttpStatus.OK);
		}catch(BookAlreadyExistsException e) {
			throw new BookAlreadyExistsException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@PutMapping("/updateadmin")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) throws AdminNotFoundException{
		try {
			Admin admin1 = adminService.updateAdmin(admin);
			return new ResponseEntity<>(admin1 , HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new AdminNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@PostMapping("/addadmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws AdminAlreadyExistsException{
		try {
			Admin admin1 = adminService.addAdmin(admin);
			return new ResponseEntity<>(admin1 , HttpStatus.OK);
		}catch(AdminAlreadyExistsException e) {
			throw new AdminAlreadyExistsException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@DeleteMapping("/deleteadmin/{adminId}")
	public ResponseEntity<String> deleteAdmin(@PathVariable int adminId) throws AdminNotFoundException{
		try {
			String str = adminService.deleteAdmin(adminId);
			return new ResponseEntity<>(str , HttpStatus.NO_CONTENT);
		}catch(AdminNotFoundException e) {
			throw new AdminNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}	
	@GetMapping("/getadminbyid/{bookId}")
	public ResponseEntity<Admin> getAdminById(@PathVariable int adminId) throws AdminNotFoundException{
		try {
			Admin admin1 = adminService.getAdminById(adminId);
			return new ResponseEntity<>(admin1 , HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new AdminNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
}
