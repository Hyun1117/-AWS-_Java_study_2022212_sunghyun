package j18_제네릭;

public class Main {

	//?는 생성시 자동으로 자료형을 가져옴
	//가능한 자료형을 명시하는 것이 좋음
	//TestData<?,?> td = new TestData<> ("정성현",30);
	
	public static void main(String[] args) {
		TestData<String, Integer> td = new TestData<String, Integer>("jsh", 100);
		TestData<String, Double> td2 = new TestData<String, Double>("jsh", 100.05);// 제네릭은 생성될 때 타입을 결정한다.

		
		
		System.out.println(td);
		System.out.println(td2);
		
		
	//generic 안에 generic 타입의 자료형을 가져올 수 있음
	//data안에 td의 자료형인 TestData<String,Integer>를 넣음
		
		CMRespDto<TestData<String, Integer>> cm = 
				new CMRespDto<TestData<String, Integer>>(200, "김준일", td);
	
		//td의 자료형을 ?을 이용해 자동으로 가져옴
//		CMRespDto<TestData<?,?>> cm =
//				new CMRespDto<TestData<?,?>>(20, "성공", td);
//		CMRespDto<?> cm =
//				new CMRespDto<>(200, "성공", td);

		System.out.println(cm);
		
		
	}

}
