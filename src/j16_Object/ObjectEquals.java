package j16_Object;

public class ObjectEquals {
	
	public static void main(String[] args) {
		String name1 = "김준일";//리터럴 -> 주소 값을 가짐
		String name2 = "김준일";//똑같은 주소 값을 가짐
		String name3 = new String("김준일");
		
		System.out.println(name1);
		System.out.println(name2);
		System.out.println();
		
		System.out.println(name1 == name2); //지금 주소를 비교 하고 있다. 문자열을 비교하는게 아닌 주소값을 비교
		System.out.println();
		System.out.println(name1.equals(name3));//equals를 쓰는 이유는 실질적인 안에 있는 값과 비교하기 때문에
		
		
		//객체를 비교할 때는 어떻게 할 것인가.
		
		Student s1 = new Student("박은빈", 24);
		Student s2 = new Student("박은빈", 24);
		SubStudent s3 = new SubStudent("박은빈", 24);
		System.out.println();
		
		System.out.println(s1.equals(s3));
	}
}
