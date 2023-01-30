package j19_컬렉션.복습;

import java.util.HashMap;
import java.util.Map;

public class SearchData {
	
	public static void main(String[] args) {
		
		Map<String, String> searchData = new HashMap<>();
		
		searchData.put("category", "소설");
		searchData.put("searchValue", "불편한 편의점");
		
		System.out.println(searchData);
		System.out.println(searchData.get("category"));
		System.out.println(searchData.get("searchValue"));
		
		
		//반복가능
		System.out.println(searchData.keySet());
		System.out.println(searchData.values());
		System.out.println(searchData.entrySet());
		
		
//		//인덱스 값의 순서가 없기 때문에 인덱스 값으로 key값을 가져올수없다.
//		for(int i = 0; i<searchData.size(); i++) {
//			System.out.println(searchData.get(null));
//		}
		
		for(String Key : searchData.keySet()) {
			System.out.println(searchData.get(Key));
		}
		
	}

}
