package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
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
		
		String sql = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ResultSet resultset = null;
		
		try {
			connection = pool.getConnection();//여기까지가 DataBase 접속

			sql = "insert into user_mst\r\n"
					+ "values(0, ?, ?, ?, ?)";
			
			//쿼리 작성을 하는 것과 동일한 단계
			//앞에 인자는 ?에 순서이고 뒤에 인자는 넣고싶은 데이터이다.
			preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getEmail());
			
			//insert, update, delete 명령어를 실행할때, 쿼리를 작성하고 명령어를 실행하는 단계
			//몇개가 적용됐는지 int값으로 리턴을 해준다.
			successCount = preparedStatement.executeUpdate(); 
			
			resultset = preparedStatement.getGeneratedKeys();
			if(resultset.next()) {
				System.out.println("이번에 만들어지 user_id key 값: " + resultset.getInt(1));
				user.setUserId(resultset.getInt(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return successCount;
	}
	
	public int saveRoles(Map<String, Object> map) {
		int successCount = 0;
		
		//map으로 업캐스팅된 user를 쓸려면 다시 user로 다운 캐스팅이 필요함
		User user = (User)map.get("user");
		//list를 쓰기 위해 다시 다운캐스팅을 해서 가져옴
		List<Integer> roles = (List<Integer>)map.get("roles");
		String sql = "insert into role_dtl values";
		String values = "(0, ?, ?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	
		try {
			connection = pool.getConnection();
			
			for(int i = 0; i < roles.size(); i++) {
				sql += values;
				if(i < roles.size() - 1) {
					sql += ",";
				}
			}
			
			
			
			preparedStatement = connection.prepareStatement(sql);
			
			for(int i = 0; i < roles.size(); i++) {
			preparedStatement.setInt((i * 2) + 1, roles.get(i));
			preparedStatement.setInt((i * 2) + 2, user.getUserId());
			
			}
			
			successCount = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return successCount;
	}
	
	public static void main(String[] args) {
		
		UserInsert userInsert = new UserInsert();
		
		
		User user = User.builder()
				.username("aaad")
				.password("1234")
				.name("aaad")
				.email("aaad@gmail.com")
				.build();
		
		int successCount = userInsert.saveUser(user);
		
		System.out.println("쿼리 실행 성공: " + successCount + "건");
		
		System.out.println(user);
		
		
		/*========================================================*/
		List<Integer> roleidList = new ArrayList<>();
		roleidList.add(2);
		roleidList.add(3);
		
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("roles", roleidList);
		
		successCount = userInsert.saveRoles(map);
		
		System.out.println("쿼리 실행 성공: " + successCount + "건");

	}
}

//문자열 반복
//int listSize = 3;
//String sql = "insert into test values";
//String values = "(0, ?, ?)";
//
//for(int i = 0; i < listSize; i++) {
//	sql+=values;
//	if(i < listSize - 1) {
//		sql += ",";
//	}
//}
//System.out.println(sql);