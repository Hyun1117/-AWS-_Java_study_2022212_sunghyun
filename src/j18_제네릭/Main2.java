package j18_제네릭;

public class Main2 {
	
	//static은 객체를 생성하지 않아도 쓸 수 있지만
	//멤버 메소드를 쓸려면 객체를 생성해야한다.
	//그래서 Main2 객체를 생성해서 CMRespDto를 쓸 수 있다.
	//생성을 하지 않으면 쓸 수 가 없다. static을 붙이지 않으면
	// ? extends Person -> 무조건 Person을 상속받은 객체들만 받을수 있고 리턴할 수 있다. 
	// ? super Student -> Student를 포함 Student의 상위 class들만 받을 수 있고 리턴 할 수 있다.
	//(Person을 상속 받은 student와 teacher 있으면 teacher는 안된다. 다른 객체이기 때문에)
	/*
	 * ? 와일드카드 제약
	 * extends 대상 객체 하위
	 * super 대상 객체 상위
	 */
	
	public CMRespDto<?> reponse(CMRespDto<?> cmRespDto) {
		System.out.println("[응답 데이터]");
		System.out.println(cmRespDto);
		return cmRespDto;
	}

	public static void main(String[] args) {
		
		Main2 main = new Main2();
		
		CMRespDto<String> hello  
				= new CMRespDto<String>(200, "성공", "안녕하세요");
		CMRespDto<Integer> score 
				= new CMRespDto<Integer>(200, "성공", 85);
		
	
		System.out.println("hello");
		System.out.println(main.reponse(hello));//object로 형변환이 되었다라고 생각하자 
		System.out.println("score");
		System.out.println(main.reponse(score));
		
		
	}
}
