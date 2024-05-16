package org.cts.lms.service;

import java.util.Optional;

import org.cts.lms.entities.Admin;
import org.cts.lms.entities.Student;
import org.cts.lms.entities.User;
import org.cts.lms.exceptions.InvalidLoginDetailsException;
import org.cts.lms.exceptions.UserAlreadyExistsException;
import org.cts.lms.exceptions.UserNotFoundException;
import org.cts.lms.repository.AdminRepository;
import org.cts.lms.repository.LoginRepository;
import org.cts.lms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public String SignUp(User user) throws UserAlreadyExistsException {
		try{
			if(UserNameExists(user.userName)==true) {
				return "Username Already exists";
			}
			else {
				loginRepository.save(user);
				if(user.getRole().toLowerCase().equals("student")) {
					Student student = new Student(user.getUserId(),user.getName(),user.getEmailId(),user);
					studentRepository.save(student);
				}
				else if(user.getRole().equalsIgnoreCase("admin")) {
					Admin admin = new Admin(user.getUserId(),user.getName(),user.getEmailId(),user);
					adminRepository.save(admin);
				}
					
			}
		return "Successfully Registered";	
		}catch(Exception e) {
			throw new UserAlreadyExistsException(e.getMessage());
		}
	}

	@Override
	public String Login(String userName, String password) throws InvalidLoginDetailsException, UserNotFoundException {
		try {
			Optional<User> optional = loginRepository.findByUsername(userName);
			if(optional.isPresent()) {
				User temp = optional.get();
				String role=temp.getRole();
				String res="Login Successful";
				if(temp.getPassword().equals(password)) {
					return role+" "+res;
				}else {
					return "Wrong password";
				}
			}else {
				return "User doesn't exist"; 
			}
		}catch(Exception e) {
			throw new InvalidLoginDetailsException(e.getMessage());
		}
	}

	@Override
	public String ForgotPassword(String userName, String password) throws UserNotFoundException {
		try {
			Optional<User> optional = loginRepository.findByUsername(userName);
			if(optional.isPresent()) {
				User user = optional.get();
			    user.setPassword(password);
				return "Password changed!";
				
				}
			else {
				return "Invalid UserName";
			}
		}catch(Exception e) {
			throw new UserNotFoundException(e.getMessage());
		}	
	}

	@Override
	public boolean UserNameExists(String userName) {
			User check = loginRepository.findByName(userName);
			if(check!=null)
			{
				return true;
				
			} 
			return false;
	}

}
