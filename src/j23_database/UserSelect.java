package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import UserManagement.entity.RoleDtl;
import UserManagement.entity.RoleMst;
import UserManagement.entity.User;

public class UserSelect {

	private DBConnectionMgr pool;
	
	public UserSelect () {
		pool = DBConnectionMgr.getInstance();
	}
	
	public User findUserByUsername(String username) {
		User user = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			
			sql = "select\r\n"
					+ "	um.user_id,\r\n"
					+ "	um.user_name, \r\n"
					+ "	um.password, \r\n"
					+ "	um.name, \r\n"
					+ "	um.email,\r\n"
					+ " rd.role_dtl_id,\r\n"
					+ " rd.role_id,\r\n"
					+ " rd.user_id,\r\n"
					+ " rm.role_id,\r\n"
					+ " rm.role_name\r\n"
					+ "from \r\n"
					+ "	 user_mst  um\r\n"
					+ "	 left outer join role_dtl rd on(rd.user_id = um.user_id)\r\n"
					+ "	 left outer join role_mst rm on(rm.role_id = rd.role_id)\r\n"
					+ "where \r\n"
					+ "	um.user_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			
			rs = pstmt.executeQuery();//select은 이 메소드를 이용
			
				if(rs.next()) {
					user = User.builder()
							.userId(rs.getInt(1))
							.username(rs.getString(2))
							.password(rs.getString(3))
							.name(rs.getString(4))
							.email(rs.getString(5))
							.build();		
				}
				
				
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt,rs);
		}
		
		return user;
	}
	
	
	public static void main(String[] args) {
		
		UserSelect userSelect = new UserSelect();
		
		User user = userSelect.findUserByUsername("aaa");
		
		System.out.println(user);
		
	}
	
}
