package org.cts.lms.service;

import org.cts.lms.entities.User;
import org.cts.lms.exceptions.InvalidLoginDetailsException;
import org.cts.lms.exceptions.UserAlreadyExistsException;
import org.cts.lms.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface LoginService {
	public String SignUp(User user) throws UserAlreadyExistsException;
	public String Login(String userName , String password) throws InvalidLoginDetailsException,UserNotFoundException;
	public String ForgotPassword(String userName, String password ) throws UserNotFoundException;
	public boolean UserNameExists(String userName);
}
