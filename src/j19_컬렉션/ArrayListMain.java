package j19_컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListMain {

	public static void main(String[] args) {
		
		/*
		 * 
		 * CRUD
		 * 
		 * Create
		 * Read
		 * Update
		 * Delete
		 * 
		 */

		// 항상업 캐스팅 해서 쓰겠다.
		List<String> strList = new ArrayList<>();

		// * 값 추가
		strList.add("java");
		strList.add("python");

		System.out.println(strList);

		// 값을 원하는 위치에 추가
		strList.add(1, "android");
		System.out.println(strList);

		// * 해당 index의 값을 추출

		System.out.println(strList.get(0));
		String lang = strList.get(1);
		System.out.println(lang);

		// 리스트에 해당 값이 있는지 확인(T,F)
		System.out.println(strList.contains("c++"));
		System.out.println(strList.contains("android"));

		// 값 수정
		strList.set(2, "javascript");
		System.out.println(strList);

		// * 값 삭제
		strList.remove("android");
		System.out.println(strList);
		strList.remove(1);
		System.out.println(strList);

		// * 리스트의 크기 확인
		System.out.println(strList.size());

		// * 리스트가 비었는지 확인
		System.out.println(strList.isEmpty());

		// 리스트 초기화
		strList.clear();
		System.out.println(strList.isEmpty());
		
		/* 
		 * * 배열을 리스트로 변환
		 * Arrays.asList(배열);
		 */
		
		//배열을 만들고 빈 List에다가 배열을 List로 바꾸고 나서 한번에 List를 집어넣음
		String[] langs = {"java","C++","python","javascript"};
		List<String> tempList = Arrays.asList(langs);
		strList.addAll(tempList);
		strList.addAll(2, tempList);
		System.out.println(strList);
		
		// * 해당 값의 위치(index)찾기 왼쪽부터 찾음
		int findIndexLeft = strList.indexOf("python");
		System.out.println(findIndexLeft);
		
		// * 해당 값의 위치(index)찾기 오른쪽부터 찾음
		int findIndexRight = strList.lastIndexOf("java");
		System.out.println(findIndexRight);
		
		
		///////////////////////////////////////
		
		strList.set(1, "java");
		System.out.println(strList);
		strList.subList(strList.indexOf("java") + 1,strList.size()).indexOf("java");
		
		//////////////////////////////////////
		
		
		//해당 fromindex의 값부터 해당 toindex값의 전까지 부분만 추출
		List<String> subList = strList.subList(1, 4);
		System.out.println(subList);
		
		
		System.out.println();
		System.out.println("for");
		
//		=============== << 반복 >> ===============
		
		//일반 반복문(for)
		for(int i = 0; i<strList.size(); i++) {
			System.out.println("[" + i + "]: " + strList.get(i));
		}
		
		System.out.println();
		System.out.println("forEach");
		
		//forEach
		for(String str : strList) {
			System.out.println("[값]: " + str);
		}
		
		System.out.println();
		System.out.println("람다식 forEach");
		
		//람다식 forEach
		strList.forEach(str -> System.out.println("[값2]: " + str));
		
		System.out.println();
		System.out.println("iterator");
		
		// 반복자(Iterator) 1회성 -> 값을 꺼냈기 때문에
		Iterator<String> iterator = strList.iterator();
		while(iterator.hasNext()) {//hasnext() 다음이 있는지 없는지 확인
			String lang2 = iterator.next();
			System.out.println("[값3]:" + lang2);//next() 값을 꺼낸다 
		}
	
		
		//정처기 1 ~ 9장까지 배열 , static
		
	}
	
	
}
