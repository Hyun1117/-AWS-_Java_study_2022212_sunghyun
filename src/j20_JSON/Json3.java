package j20_JSON;

import com.google.gson.Gson;

//class의 있는 기능들을 쓰고 싶을때 객체로 생성을 한다.

public class Json3 {

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		
		//Integer의 static 메소드들중 하나. -> 문자열을 int형으로 바꿔주는 메소드들이다.
		System.out.println(Integer.valueOf("100") + 100);
		System.out.println(Integer.parseInt("100") + 100);
		
		//Object -> JSON으로 바꿔주는 것
		gson.toJson(null);
		
		//JSON -> Object로 바꿔주는 것
		gson.fromJson("", Object.class);
	}
	                                                                                                                                                                                                                                                                                                                                                                                                         
}
