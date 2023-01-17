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
	
}
