package org.cts.lms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "user_id")
	public int userId;
	
	@Column(name = "user_name")
	public String userName;
	
	@Column(name = "password")
	public String password;
	
	@Column(name = "full_name")
	public String name;
	
	@Column(name = "email_id")
	public String emailId;
	
	@Column(name = "contact_number")
	public long number;
	
	@Column(name = "role")
	public String role;
	
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private Student student;
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private Admin admin;
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", name=" + name
				+ ", emailId=" + emailId + ", number=" + number + ", role=" + role + ", student=" + student + ", admin="
				+ admin + "]";
	}
	public User(int userId, String userName, String password, String name, String emailId, long number, String role,
			Student student, Admin admin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.emailId = emailId;
		this.number = number;
		this.role = role;
		this.student = student;
		this.admin = admin;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
