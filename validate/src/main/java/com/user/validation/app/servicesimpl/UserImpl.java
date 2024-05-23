package com.user.validation.app.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.user.validation.app.exception.UserException;
import com.user.validation.app.model.User;
import com.user.validation.app.repository.UserRepo;
import com.user.validation.app.servicesi.UserI;

@Service
public class UserImpl implements UserI {
	@Autowired
	UserRepo ur;

	@Override
	public User saveUser(User u) {
		return ur.save(u);
	}

	@Override
	public List<User> showUser() {
		List<User> op = ur.findAll();
		if (op != null) {
			return op;
		} else {
			return null;
		}
	}

	@Override
	public User updateUser(User u, Integer id) {
		Optional<User> op = ur.findById(id);
		if (op != null) {
			User user = op.get();
			if (user != null) {
				if (u.getUsername() != null) {
					user.setUsername(u.getUsername());
				}
				if (u.getPassword() != null) {
					user.setPassword(u.getPassword());
				}
				if (u.getEmail() != null) {
					user.setEmail(u.getEmail());
				}
				if (u.getAge() != null) {
					user.setAge(u.getAge());
				}

			} else {

				user.setUsername(u.getUsername());
				user.setPassword(u.getPassword());
				user.setEmail(u.getEmail());
				user.setAge(u.getAge());

			}
			return ur.save(user);
		} else {
			return null;
		}
	}

	@Override
	public User deleteUser(Integer id) {
		Optional<User> op = ur.findById(id);
		if (op != null) {
			User customer = op.get();
			ur.delete(customer);
			return customer;
		} else {
			return null;
		}
	}

	@Override
	public User findbyid(Integer id) throws UserException {
		User us  = ur.getByUserId(id);
		if(us!=null) {
			return us;
		}
		else {
		throw new UserException("Customer id details not found");
		}
		
	}

}
