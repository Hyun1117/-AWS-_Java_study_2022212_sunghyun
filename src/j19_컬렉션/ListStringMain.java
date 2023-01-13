package j19_컬렉션;

import java.util.ArrayList;

public class ListStringMain {
	
	public static void main(String[] args) {
		String[] strArray = new String[] {"java","python","C++"};
		
		String[] strArray2 = new String[strArray.length + 1];
		
		
		
		for(int i = 0; i < strArray.length; i++) {
			strArray2[i] = strArray[i];
		}
		
		strArray2[strArray.length] = "html";
		
		System.out.println("strArray");
		for(String str : strArray) {
			System.out.println(str);
		}
		
		System.out.println();
		
		System.out.println("strArray2");
		for(String str : strArray2) {
			System.out.println(str);
		}
		
		System.out.println();
		///////////컬렉션//////////////////
		
		//배열과 다른점 -> 객체이다. (Class)임
		
		
		//아래와 동일 와일드카드를 쓸 때는 이렇게 써야함 -> 이렇게 쓰는 걸 추천하지않는다.
//		ArrayList<?> strList = new ArrayList<>();
//		((ArrayList<String>)strList).add("java");
//		strList.add("python");
//		strList.add("C++");
		
		//넣는 만큼 늘어난다.
		//제거하는 동시에 자동으로 index를 정리해준다.
		//자료구조와 알고리즘 ->
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("java");
		strList.add("python");
		strList.add("C");
		strList.add("C++");
		strList.add("C");
		strList.add("C++");
		strList.add("C");
		strList.remove("java");
		strList.add(3, "java");//집어넣을 index번호와 집어넣을 데이터를 집어넣음 add 메소드의 오버로딩
		strList.remove(4);//특정 index안의 값을 제거해줌
		System.out.println(strList);
		
		System.out.println();
		
		for(int i = 0; i <strList.size(); i++) {
			
			System.out.print("["+ i + "]: ");
			System.out.println(strList.get(i));
		}
		
		
		
	}

}
