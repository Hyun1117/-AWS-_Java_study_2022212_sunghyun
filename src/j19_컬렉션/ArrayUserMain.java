package j19_컬렉션;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class User {
	private String username;
	private String name;
}



public class ArrayUserMain {
	
	public static User searchUser(List<User> userList, String searchUsername) {
		User user = null;
		
		for(User u : userList) {
			if(u.getUsername().equals(searchUsername)) {
				user = u;
				break;
			}
		}
		return user;
	}
	
	
	
	public static void main(String[] args) {
		
		User[] userArray = {
						new User("aaa","김종환"),
						new User("bbb","고병수"),
						new User("ccc","손민재"),
						new User("ddd","황창욱")
		};
		List<User> userList = Arrays.asList(userArray);
		
		String searchUsername = "eeee";
		
		boolean flag = false;
		
		for(int i = 0; i < userList.size(); i++) {
			
			if(userList.get(i).getUsername() == searchUsername) {//equals를 써도 됨
				flag = true;
				System.out.println("검색성공!!");
				System.out.println(searchUsername +"계정의 회원 이름은 " + userList.get(i).getName() +"입니다.");
			}
		}
		
		if(!flag) {
			System.out.println("검색실패!");
		}
		
		
		
		User user = searchUser(userList, searchUsername);
		
		if(user == null) {
			System.out.println("검색실패");
			System.out.println("존재하지 않는 계정입니다");
		}else {
			System.out.println("검색성공");
			System.out.println(user.getUsername()+"계정의 회원 이름은" + user.getName() + "입니다. ");
		}
	}
	
	
}



