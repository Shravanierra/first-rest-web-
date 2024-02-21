package com.restful.webservice.restweb.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users=new ArrayList<>();
	private static int usersCount=3;
	
	static {
		users.add(new User(1,"ram",LocalDate.now().minusYears(30)));
		users.add(new User(2,"sita",LocalDate.now().minusYears(20)));
		users.add(new User(3,"gita",LocalDate.now().minusYears(25)));
		
	}
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
		
	}
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
		
	}
	

}
