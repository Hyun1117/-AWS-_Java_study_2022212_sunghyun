package J12_배열.복습;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class User{
	private String username;
	private String password;
}


public class Array2 {
	
	public static void main(String[] args) {
		
		User[] users = new User[] {
				new User("aaa", "1234"),
				new User("bbb", "1234"),
				new User("ccc", "1234")
		};
		
		for(int i = 0; i<users.length; i++) {
			 users[i].setPassword("2222");
			 System.out.println(users[i].getPassword());
		}
		
		for(User u : users) {
			System.out.println(u);
		}
		List<User>userList = Arrays.asList(users);//배열을 List형식으로 바꾸는 asList 메소드
		System.out.println(userList);
		
	}
	
}
