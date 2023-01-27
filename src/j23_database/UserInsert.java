package j23_database;

import java.sql.Connection;

import UserManagement.entity.User;

public class UserInsert {
	private DBConnectionMgr pool;
	
	public UserInsert() {
		pool = DBConnectionMgr.getInstance();
	}
	
	public int saveUser(User user) {
		
		int successCount = 0;
		
		Connection con = null;
		
		
		return successCount;
	
		
	}
}
