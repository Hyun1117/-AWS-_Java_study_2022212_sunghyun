package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import UserManagement.entity.User;

public class UserInsert {
	private DBConnectionMgr pool;

	public UserInsert() {
		pool = DBConnectionMgr.getInstance();
	}

	public int saveUser(User user) {

		int successCount = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			con = pool.getConnection();
			sql = "insert into user_mst\r\n" + "values (0, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());

			successCount = pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				System.out.println("현재 id값: " + rs.getInt(1));
				user.setUserId(rs.getInt(1));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		System.out.println("쿼리성공 건수: " + successCount);
		return successCount;

	}

	public int saveRoleDtl(Map<String, Object> map) {
		int successCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert int role_dtl values";
		String value = "(0,?,?)";
		User user = (User) map.get("user");
		List<Integer> roles = (List<Integer>) map.get("roles");

		try {
			con = pool.getConnection();
			for (int i = 0; i < roles.size(); i++) {
				sql += value;
				if(i < roles.size() - 1) {
					sql += ", ";
				}
			}
			pstmt = con.prepareStatement(sql);
			
			for(int i = 0; i < roles.size(); i++) {
				pstmt.setInt((i * 2) + 1, roles.get(i));
				pstmt.setInt((i * 2) + 2, user.getUserId());
			}
			successCount = pstmt.executeUpdate();
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt);
		}

		return successCount;
	}

	public static void main(String[] args) {
		UserInsert userInsert = new UserInsert();

		User user = User.builder().username("xxx").password("1234").name("정성현").email("xxx@naver.com").build();
		userInsert.saveUser(user);
	}
}
