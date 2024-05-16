package org.cts.lms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unavailable_books")
public class RequestNewBook {
	
	@Column(name = "studentId")
	private int studentId;
	
	@Id
	@Column(name = "serialnumber")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sNumber;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "status")
	private String status;
	
	@Override
	public String toString() {
		return "RequestNewBook [studentId=" + studentId + ", bookName=" + title + ", author=" + author
				+ ", publisher=" + publisher + ", status=" + status + "]";
	}

	public RequestNewBook(int studentId, String bookName, String author, String publisher, String status) {
		super();
		this.studentId = studentId;
		this.title = bookName;
		this.author = author;
		this.publisher = publisher;
		this.status = status;
	}

	public RequestNewBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getBookName() {
		return title;
	}

	public void setBookName(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
}
