package com.user.validation.app.model;

import org.hibernate.validator.constraints.EAN;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer userId;
	
	@NotBlank(message = "Username is required")
	@Pattern(regexp = "^[a-zA-Z0-9]{6,12}$",message = "username must be of 6 to 12 length with no special characters")
	private String username;
	
	@NotBlank(message = "Password is required")
	@Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$",message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
	private String password;
	
	@NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age must be no more than 60")
    private Integer age;
	
	
	

}
