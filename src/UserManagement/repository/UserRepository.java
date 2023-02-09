package UserManagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import UserManagement.config.DBConnectionMgr;
import UserManagement.entity.RoleDtl;
import UserManagement.entity.RoleMst;
import UserManagement.entity.User;

/*
 * UserDao -> 데이터에 접근하는 용도(Data Acces Object)
 *  */

public class UserRepository {

	
	private static UserRepository instance;

	private DBConnectionMgr pool;

	
	public static UserRepository getInstance() {
		if(instance == null) {
			instance = new UserRepository();
		}
		
		return instance;
	}
	
	
	private UserRepository() {
		pool = DBConnectionMgr.getInstance();
	}
	
	

	public int saveUser(User user) {
		int successCount  = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "insert into user_mst\n"
					+ "values(0,?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			
			successCount = pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			
			if(rs.next()) {
				System.out.println("현재 Id 값: " + rs.getInt(1));
				user.setUserId(rs.getInt(1));
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt,rs);
		}
		

		
		return successCount;
	}
		
	public int saveRoleDtl(RoleDtl roleDtl) {
		int successCount = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "insert into role_dtl values"
					+ "(0,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, roleDtl.getRoleId());
			pstmt.setInt(2, roleDtl.getUserId());
			
			successCount = pstmt.executeUpdate();

			
//			ResultSet rs = null; key값을 쓸일이 없으면 필요없음
//			rs = pstmt.getGeneratedKeys();
//			 Statement.RETURN_GENERATED_KEYS
//			if(rs.next()) {
//				roleDtl.setRoleDtlId(rs.getInt(1));
//			}

		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt);
		}
		
		return successCount;
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
					+ "	um.username, \r\n"
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

					+ "	um.username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			
			
			
			List<RoleDtl> roleDtls = new ArrayList<>();
			int i = 0;
			rs = pstmt.executeQuery();//select은 이 메소드를 이용
			while(rs.next()) {
				
				if(i == 0) {
					user = User.builder()
							.userId(rs.getInt(1))
							.username(rs.getString(2))
							.password(rs.getString(3))
							.name(rs.getString(4))
							.email(rs.getString(5))
							.build();		
				}
				//
				RoleMst roleMst = RoleMst.builder()
						.roleId(rs.getInt(9))
						.roleName(rs.getString(10))
						.build();
				
				RoleDtl roleDtl = RoleDtl.builder()
						.roleDtlId(rs.getInt(6))
						.roleId(7)
						.userId(8)
						.roleMst(roleMst)
						.build();
				roleDtls.add(roleDtl);
				
				i++;
			}
			if(user != null) {
				user.setRoleDtls(roleDtls);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt,rs);
		}
		
		return user;
	}
	
	public User findUserByemail(String email) {
		User user = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			con = pool.getConnection();

			sql = "select\r\n"
					+ "	um.user_id,\r\n"
					+ "	um.username, \r\n"
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
					+ "	um.email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);

			
			List<RoleDtl> roleDtls = new ArrayList<>();
			int i = 0;
			rs = pstmt.executeQuery();//select은 이 메소드를 이용
			while(rs.next()) {
				
				if(i == 0) {
					user = User.builder()
							.userId(rs.getInt(1))
							.username(rs.getString(2))
							.password(rs.getString(3))
							.name(rs.getString(4))
							.email(rs.getString(5))
							.build();		
				}
				
				RoleMst roleMst = RoleMst.builder()
						.roleId(rs.getInt(9))
						.roleName(rs.getString(10))
						.build();
				
				RoleDtl roleDtl = RoleDtl.builder()
						.roleDtlId(rs.getInt(6))
						.roleId(7)
						.userId(8)
						.roleMst(roleMst)
						.build();
				roleDtls.add(roleDtl);
				
				i++;
			}
			if(user != null) {
				user.setRoleDtls(roleDtls);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt,rs);
		}
		
		return user;
	}
	
	
}
