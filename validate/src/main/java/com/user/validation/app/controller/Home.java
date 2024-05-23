package com.user.validation.app.controller;

import java.util.List;

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

import com.user.validation.app.model.User;
import com.user.validation.app.servicesi.UserI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class Home {
	@Autowired
	UserI ui;

	@PostMapping("/save")
	public ResponseEntity<User> save(@Valid @RequestBody User u) {
		User user = ui.saveUser(u);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	@GetMapping("/show")
	public ResponseEntity<List<User>> show() {
		List<User> user = ui.showUser();
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<User> update(@Valid @RequestBody User u, @PathVariable Integer id) {
		User user = ui.updateUser(u,id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> delete(@PathVariable Integer id) {
		User user = ui.deleteUser(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<User> findbyid(@PathVariable Integer id) {
		User user = ui.findbyid(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

}
