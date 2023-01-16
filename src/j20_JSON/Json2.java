package j20_JSON;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//Map과 Gson을 이용해 JSON 형식으로 출력을 하는 방법

public class Json2 {

	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		
		map.put("a", "test1");
		map.put("b", 10.5);
		map.put("c", new int[] {10,20,30,40,50});
		System.out.println(map);
		
		//Gson 객체를 생성하는 방법
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//toJson -> JSON형식으로 바꿔줌 JSON은 문자열이기 때문에 String으로 대입해줘야함
		String mapJson = gson.toJson(map);
		
		System.out.println(mapJson);
	}
	                                                                                                                                                                                                                                                                                                                                                                                                         
}
