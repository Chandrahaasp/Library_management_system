package org.cts.lms.controller;

import org.cts.lms.entities.Book;
import org.cts.lms.entities.User;
import org.cts.lms.exceptions.BookAlreadyExistsException;
import org.cts.lms.exceptions.InvalidLoginDetailsException;
import org.cts.lms.exceptions.UserAlreadyExistsException;
import org.cts.lms.exceptions.UserNotFoundException;
import org.cts.lms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api
@RestController
@RequestMapping("/lms/users")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@ApiOperation(value = "Signup User",
			response = String.class,
			consumes = "user Object",
			tags = "sign-up user",
			httpMethod = "POST")
	@PostMapping("/signup")
	public ResponseEntity<String> SignUp(@RequestBody User user) throws UserAlreadyExistsException{
		try {
			String str = loginService.SignUp(user);
			return new ResponseEntity<>(str , HttpStatus.OK);
		}catch(UserAlreadyExistsException e) {
			throw new UserAlreadyExistsException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@PostMapping("/login/{userName}/{password}")
	public ResponseEntity<String> Login(@PathVariable String userName ,@PathVariable String password) throws InvalidLoginDetailsException,UserNotFoundException{
		try {
			String str = loginService.Login(userName, password);
			return new ResponseEntity<>(str , HttpStatus.OK);
		}catch(InvalidLoginDetailsException e) {
			throw new InvalidLoginDetailsException(e.getMessage());
		}catch(UserNotFoundException e) {
			throw new UserNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@PutMapping("/forgotpassword/{userName}/{password}")
	public ResponseEntity<String> ForgotPassword(@PathVariable String userName,@PathVariable String password) throws UserNotFoundException{
		try {
			String str = loginService.ForgotPassword(userName, password);
			return new ResponseEntity<>(str , HttpStatus.OK);
		}catch(UserNotFoundException e) {
			throw new UserNotFoundException(e.getMessage());
		}catch(ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
}
