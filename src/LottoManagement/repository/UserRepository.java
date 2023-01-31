package LottoManagement.repository;

import java.util.List;

import LottoManagement.entity.User;


public class UserRepository {
	
	private static UserRepository instance = null;
	private List<User> userDataList;
	
	private UserRepository() {
		
	}
	
	public static UserRepository getInstance() {
		if(instance == null) {
			instance = new UserRepository();
		}
		return instance;
	}
	
	public void saveUser(User user) {
		userDataList.add(user);
	}
	
	public User findUserByusername(String username) {
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
