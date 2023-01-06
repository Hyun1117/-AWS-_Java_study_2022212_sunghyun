package j11_접근지정자.default1;

 public class J11_StudentDefault {
	
	 
	//클래스내의 멤버변수는 private로 지정 -> 데이터의 은닉
	//메서드를 활용해 멤버변수를 값을 전달해줘야한다.
	private String name;
	private int age;
	
	public J11_StudentDefault() {
		
	}
	
	public J11_StudentDefault(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void printInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
	
	
	//클래스내에서 작동하는 메소드들은 private로 지정 -> 캡슐화
	
	//Getter -> 값을 가지고 오는 메서드
	public String getName() {
		return name;
	}
	
	//Setter -> 값을 대입 해주는 메서드
	public void setName(String name) {
		this.name = name;
	}
	
	//알트 쉬프트 s -> Getter , Setter, 생성자를 자동으로 만들어주는 단축키
	//컨트롤 쉬프트 f -> 자동 줄정리 단축키
	
	
	// ${name} -> 하나의 표현식이고 Getter를 호출함
	
}
