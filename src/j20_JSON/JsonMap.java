package j20_JSON;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import j20_JSON.builder.User;

public class JsonMap {
	
	public static void main(String[] args) {
		
		//Gson을 기본 생성자로 생성했을때는 JSON에 맞게 출력을 안해줌
		Gson gson = new Gson();
		
		//JSON 형식으로 출력을 해줌
		//serializeNulls은 null을 출력해주는 메소드
		gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		
		//Object(Map) -> JSON
		Map<String,Object> user = new HashMap<>();
		user.put("username", "aaa");
		user.put("password", "1234");
		user.put("name", null);
		
		String userJson = gson.toJson(user);
		System.out.println(user);
		System.out.println(userJson);
		
		//JSON -> Object(Map)
		Map<String,Object> userMap = gson.fromJson(userJson, Map.class);
		//JSON -> Object(class)
		User userObj = gson.fromJson(userJson, User.class);
		
		System.out.println(userMap);
		System.out.println(userObj);
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("test1", "aaa");
		jsonObject.addProperty("test2", "bbb");
		jsonObject.addProperty("test3", "ccc");
		
		String jsonObjectStr = jsonObject.toString();
		System.out.println(jsonObjectStr);
		
		
	}

}
