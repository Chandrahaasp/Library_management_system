package org.cts.lms.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@Column(name = "admin_id")
	private int adminId;
	
	@Column(name = "admin_name")
	private String adminName;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "branch")
	private String branch;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "admin")
	@JsonIgnore
	private List<Book> book;
	
	@OneToMany(mappedBy = "admin")
	@JsonIgnore
	private List<Student> student;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", emailId=" + emailId + ", branch=" + branch
				+ ", password=" + password + "]";
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int userId, String name, String emailId, User user) {
		this.adminId=userId;
		this.adminName=name;
		this.emailId=emailId;
		this.user=user;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
