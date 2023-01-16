package j19_컬렉션;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapStringMain {

	public static void main(String[] args) {

		// Map은 Key는 Set, Value는 List 형식이다.
		Map<String, String> strMap = new HashMap<>();

		// Map add가 아닌 put이 있다.
		strMap.put("이종현", "a");
		strMap.put("진채희", "b");
		strMap.put("김재영", "c");
		strMap.put("이상현", "d");

		System.out.println(strMap);

		// map은 키값이 있기 때문에 get이 존재함
		System.out.println(strMap.get("a"));
		System.out.println(strMap.get("e"));

		// Map은 Key값이 지정해서 넣어주기 때문에 for문을 쓸 수 없다.
		// forEach도 Map은 Key와 Value를 한쌍으로 가지기 때문에 쓸 수 없다.

		// 그래서 keySet을 이용해 키값만 꺼내와서 forEach를 쓸 수 있다.
		for (String k : strMap.keySet()) {
			System.out.println("Key: " + k);
			System.out.println(strMap.get(k));// 꺼낸 Key값을 이용해 Value를 꺼낼 수 있음.
		}

		
		//key값에 hash값으로 정렬이 되서 나오기 때문에 순서대로 안나온다.
		for(String v : strMap.values()) {
			System.out.println("Value: " + v);
		}
		
		//key와 value를 한번에 들고오고 싶을 때 Entry를 쓴다.
		//Entry는 key와 value의 값을 다 가지고 있는 하나의 객체이다.
		System.out.println(strMap.entrySet());
		
		//Set<Entry<String, String>> s = null;
		
		for(Entry<String,String> entry : strMap.entrySet()) {
			System.out.println(entry);
			System.out.println("key: " + entry.getKey()); 
			System.out.println("value: " + entry.getValue()); 
		}
		
		System.out.println("==================================");
		
		//람다식
		strMap.forEach((k,v) -> {
			System.out.println("key: " + k);
			System.out.println("value: " + v);
		});
		
	}

}
