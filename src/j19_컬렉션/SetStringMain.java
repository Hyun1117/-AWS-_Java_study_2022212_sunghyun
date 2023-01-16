package j19_컬렉션;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetStringMain {
	
	public static void main(String[] args) {
		
		//Hashset -> hash값으로 정렬된 set이다.
		Set<String> setStr = new HashSet<>();//중복 X
		List<String> listStr = new ArrayList<>();//중복 O
		
		listStr.add("임나영");
		listStr.add("이강용");
		listStr.add("임나영");
		listStr.add("임나영");
		
		System.out.println(listStr);
		
		setStr.add("김상현");
		setStr.add("강대협");
		setStr.add("손지호");
		setStr.add("최해혁");
		setStr.add("최해혁");
		setStr.addAll(listStr);//매개변수가 Collection이라서 list, set과 같은 것들도 넣을 수 있다.
		//set은 값의 중복을 허용하지 않기 때문에 list의 중복된 값은 하나만 들어가게 된다.
		
		
		
		System.out.println(setStr);
		String searchName = "손지호";
		
		
		
		for(String name : setStr) {//값을 직접 꺼내서 비교해야한다.
			if(name.equals(searchName)) {
				System.out.println(name);
			}
		}
		
		Iterator<String> iterator = setStr.iterator();
		
		while(iterator.hasNext()) {
			String n = iterator.next();
			if(n.equals(searchName)) {
				System.out.println(n);
			}
		}
		
		
		
		
		
		
		
		
	}

}
