package j17_스태틱;

import java.time.LocalDateTime;

public class Car {
	
	
	
	private static final int NOW_YEAR = LocalDateTime.now().getYear();//지금 연도를 반환하는 메소드
	
	private String serialCode; // KIA-2023-0000
	private String modelName;
	private final String CODE = "KIA-" + NOW_YEAR + "-";
	
	private static int Number = 1;
	
	public Car(String modelName) {
		serialCode = CODE +  String.format("%04d", Number);//String 메소드 %04d -> 0001 0002 0003 증가 할 수 있음
		this.modelName = modelName;
		++Number;
	}
	
	
	
	@Override
	public String toString() {
		return "Car [serialCode=" + serialCode + ", modelName=" + modelName + "]";
	}

	
	
	
}
