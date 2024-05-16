package org.cts.lms.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@Column(name = "book_id")
	private int bookId;
	
	@Column(name = "title")
	private String bookName;
	
	@Column(name = "Author")
	private String Author;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "no_of_copies")
	private int noOfCopies;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "issued_date")
	private LocalDate issuedDate; 
	
	@Column(name = "return_date")
	private LocalDate returnDate;
	
	@Column(name = "available_date")
	private LocalDate availableDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Admin admin;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Student student;

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", Author=" + Author + ", publisher=" + publisher
				+ ", noOfCopies=" + noOfCopies + ", status=" + status + ", issuedDate=" + issuedDate + ", returnDate="
				+ returnDate + ", availableDate=" + availableDate + ", admin=" + admin + ", student=" + student + "]";
	}

	public Book(int bookId, String bookName, String author, String publisher, int noOfCopies, String status,
			LocalDate issuedDate, LocalDate returnDate, LocalDate availableDate, Admin admin, Student student) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		Author = author;
		this.publisher = publisher;
		this.noOfCopies = noOfCopies;
		this.status = status;
		this.issuedDate = issuedDate;
		this.returnDate = returnDate;
		this.availableDate = availableDate;
		this.admin = admin;
		this.student = student;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDate getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(LocalDate availableDate) {
		this.availableDate = availableDate;
	}
	
}