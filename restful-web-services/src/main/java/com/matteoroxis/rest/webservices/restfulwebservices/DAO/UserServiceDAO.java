package com.matteoroxis.rest.webservices.restfulwebservices.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.matteoroxis.rest.webservices.restfulwebservices.model.User;

@Component
public class UserServiceDAO {

	private static List<User> users = new ArrayList<User>();
	private static int userCount = 3;

	static {
		users.add(new User(new Long(1), "Matteo", LocalDate.now()));
		users.add(new User(new Long(2), "Antonio", LocalDate.now()));
		users.add(new User(new Long(3), "Mario", LocalDate.now()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(new Long(++userCount));
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId().equals(new Long(id))) {
				return user;
			}
		}
		return null;
	}

}
