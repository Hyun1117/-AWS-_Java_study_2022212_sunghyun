package LottoManagement.entity;

import lombok.Data;

@Data
//관리자,매니저,유저
//
public class User {
	
	private String username;
	private String password;
	private int authority;//관리자,매니저, 유저
	
	public User(int authority) {
		this.authority = authority;
	}

}
