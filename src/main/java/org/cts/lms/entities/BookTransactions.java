package org.cts.lms.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_history")
public class BookTransactions {
	@Id
	@Column(name = "book_id")
	private int bookId;
	
	@Column(name = "title")
	private String bookName;
	
	@Column(name = "student_id")
	private int studentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	@Column(name = "issued_date")
	private Date issuedDate;
	
	@Column(name = "return_date")
	private Date returnDate;
	
	
	@Override
	public String toString() {
		return "BookTransactions [bookId=" + bookId + ", bookName=" + bookName + ", studentId=" + studentId
				+ ", studentName=" + studentName + ", issuedDate=" + issuedDate + ", returnDate=" + returnDate + "]";
	}
	public BookTransactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookTransactions(int bookId, String bookName, int studentId, String studentName, Date issuedDate,
			Date returnDate) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.studentId = studentId;
		this.studentName = studentName;
		this.issuedDate = issuedDate;
		this.returnDate = returnDate;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getBookId() {
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
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
}
