package UserManagement.repository;

import java.util.ArrayList;
import java.util.List;

import UserManagement.entity.User;

public class UserRepository {
	
	private static UserRepository instance;
	private List<User> userDataList;
	
	public static UserRepository getInstance () {
		if(instance == null) {
			instance = new UserRepository();
		}
		return instance;
	}
	
	private UserRepository() {
		userDataList = new ArrayList<>();
		userDataList.add(User.builder()
				.username("aaa")
				.password("1234")
				.name("김준일")
				.email("aaa@gmail.com")
				.build());
		userDataList.add(User.builder()
				.username("bbb")
				.password("123456")
				.name("김준일")
				.email("bbb@gmail.com")
				.build());
		userDataList.add(User.builder()
				.username("ccc")
				.password("12345")
				.name("김준일")
				.email("ccc@gmail.com")
				.build());
	}

	public void saveUser(User user) {
		userDataList.add(user);
	}
	
	public User findUserByUsername(String username) {
		User user = null;
		for(User u : userDataList) {
			if(u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		return user;
	}
	
	public User findUserByUserEmail(String email) {
		User user = null;
		for(User u : userDataList) {
			if(u.getEmail().equals(email)) {
				user = u;
				break;
			}
		}
		return user;
	}
	
	public User findUser(String text) {
		User user = null;
		for(User u : userDataList) {
			if(u.getUsername().equals(text) || u.getEmail().equals(text)) {
				user = u;
				break;
			}
		}
		return user;
	}
}
