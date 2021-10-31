package com.smh.electroos;

import com.smh.electroos.entity.Role;
import com.smh.electroos.entity.User;
import com.smh.electroos.entity.UserRole;
import com.smh.electroos.service.UserService;
import com.smh.electroos.utility.SecurityUtility;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class ElectroOsApplication implements CommandLineRunner {

	private final UserService userService;

	public ElectroOsApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ElectroOsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		User user= new User(
				"smh",
				SecurityUtility.bCryptPasswordEncoder().encode("smh"),
				"Sit Min",
				"Htet",
				"sitminhtet@gmail.com",
				"0912345678"
		);

		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role((long) 1,"ROLE_USER");

		userRoles.add(new UserRole(user, role1));

		userService.createUser(user,userRoles);

	}
}
