package com.user.validation.app.exception;

import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.user.validation.app.model.User;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<APIError> userNotFound(UserException u,HttpServletRequest req){
		
		APIError api=new APIError();
		api.setDate(new Date());
		api.setStatusCode(HttpStatus.NOT_FOUND.value());
		api.setMessage(u.getMessage());
		api.setPath(req.getRequestURI());
		api.setHttpMessage(HttpStatus.NOT_FOUND);
		return new ResponseEntity<APIError>(api,  HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<Map<String,String>> handlermethodArg (MethodArgumentNotValidException ex){
			Map<String, String> resp=new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach(error->{
				String fieldname=((FieldError)error).getField();
				String message= error.getDefaultMessage();
				resp.put(fieldname, message);
			});
			return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
		}
	}
	
	


