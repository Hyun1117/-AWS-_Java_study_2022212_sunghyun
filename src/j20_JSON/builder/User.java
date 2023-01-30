package j20_JSON.builder;

import lombok.AllArgsConstructor;
import lombok.Data;

//builder 패턴
//class 안에 class
//AllArgsConstructor가 필수다.
//생성할 때 원하는 변수 값만 넣고 싶을 때 
@Data
//@Builder //AllArgsConstructor도 같이 import된다.
@AllArgsConstructor
public class User {

	private String username;
	private String password;
	private String name;
	private String email;
	
	
//	public static UserBuilder builder() {
//
//		return new UserBuilder();// User class안에있는 UserBuider를 생성
//	}

//
//	// 내부 class
//	// class 안에 있는 class를 쓸려면 user를 생성해야 쓸 수있다. 그래서 static을 활용해 생성
//	// 하지 않고도 쓸 수 있도록 하였다.
//	@Data
//	public static class UserBuilder {
//		private String username;
//		private String password;
//		private String name;
//		private String email;
//
	

	
//		public UserBuilder username(String username) {
//			this.username = username;
//			return this;
//		}
//
//		public UserBuilder password(String password) {
//			this.password = password;
//			return this;
//		}
//
//		public UserBuilder name(String name) {
//			this.name = name;
//			return this;
//		}
//
//		public UserBuilder email(String email) {
//			this.email = email;
//			return this;
//		}
//
//		public User build() {// 생성된 UserBuider객체 안에 User를 생성하는 build를 쓸 수있다.
//			// User를 생성하면 User안에 있는 멤버변수에 접근할 수 있다.
//			return new User(username, password, name, email);
//		}
//	}

}
