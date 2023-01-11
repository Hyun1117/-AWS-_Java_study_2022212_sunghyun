package j16_Object;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectGetClass {
	public static void main(String[] args) {
		Student student = new Student("김재영", 29);

		System.out.println(student.getClass());// .getclass()는 생성된 객체에 class의 정보를 가져온다.
		System.out.println(Student.class);// .class는 해당 class의 정보를 가져온다.

		System.out.println(student.getClass().getName());

		Class StudentClass = student.getClass();

		String className = StudentClass.getName();
		System.out.println("클래스 이름 : " + className);

		String simpleName = StudentClass.getSimpleName();
		System.out.println("클래스 이름만 : " + simpleName);
		
		//StudentClass.getDeclaredAnnotation() ->
		//StudentClass.getDeclaredAnnotations() ->
		//StudentClass.getDeclaredClasses() ->
		Field[] fields = StudentClass.getDeclaredFields(); //-> 멤버변수를 꺼내옴
		
		for(Field field : fields) {
			System.out.println(field);
		}
		
		System.out.println();
		
		Method[] methods = StudentClass.getDeclaredMethods();
		
		for(Method method : methods) {
			System.out.println(method);
		}
	}
}
