package j20_JSON.builder;

public class UserBuilder {

	
	private String username;
	private String password;
	private String name;
	private String email;

	public UserBuilder username(String username) {
		this.username = username;
		return this;
	}

	public UserBuilder password(String password) {
		this.password = password;
		return this;
	}

	public UserBuilder name(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder email(String email) {
		this.email = email;
		return this;
	}

	public User build() {// 생성된 UserBuider객체 안에 User를 생성하는 build를 쓸 수있다.
		// User를 생성하면 User안에 있는 멤버변수에 접근할 수 있다.
		return new User(username, password, name, email);
	}
}
