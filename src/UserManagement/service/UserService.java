package UserManagement.service;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import UserManagement.entity.User;
import UserManagement.repository.UserRepository;


public class UserService {
	
	private Gson gson;
	
	private UserRepository userRepository;
	
	private static UserService instance;
	
	public static UserService getInstance() {
		if(instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	private UserService() {
		userRepository = UserRepository.getInstance();
		gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
//	public Map<String,String> register(String userJson) {
//		User user = gson.fromJson(userJson, User.class);
//		if(dublicatedUsername(user.getUsername())){
//			
//		}
//	}
	private boolean dublicatedUsername(String username) {
		return userRepository.findUserByUsername(username) != null;
	}

}
