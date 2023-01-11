package j16_Object;

public class ObjectHashCode {
	public static void main(String[] args) {
		Student s1 = new Student("김수현" , 31);
		Student s2 = new Student("김수현" , 31);
		SubStudent s3 = new SubStudent("김수현", 31);
		
		System.out.println(s1.hashCode()); //원형 hashCode 해시 알고리즘에 의해 생성된 정수 값입니다.
		System.out.println(s2.hashCode());
		
		System.out.println(s1.hashCode() == s2.hashCode());
		System.out.println(s1.hashCode() == s3.hashCode());
	}

}
