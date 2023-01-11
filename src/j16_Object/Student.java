package j16_Object;

import java.util.Objects;

public class Student {

	private String name;
	private int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {

		return Objects.hash(name, age); // java.util -> 데이터를 관리할 수 있는 도구들이 있음.
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj.getClass() == Student.class)) {// instance는 상속관계를 가질 때 문제가 생기기 때문에 사라졌다.
			return false;
		}

		Student s = (Student) obj;//다운캐스팅을 할 떄에는 정확하게 타입을 지정해라.
		boolean result = name.equals(s.name) && age == s.age;

		return result;
	}

	@Override
	public String toString() {

		return "이름" + name + "\n나이 : " + age;
	}

}
