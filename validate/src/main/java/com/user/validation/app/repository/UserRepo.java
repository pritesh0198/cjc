package com.user.validation.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.validation.app.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	public User getByUserId(Integer id);
}
