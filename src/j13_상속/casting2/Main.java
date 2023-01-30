package j13_상속.casting2;

public class Main {

	public static void main(String[] args) {
		Taxi taxi = new Taxi();
		Subway subway = new Subway();
		
		
		Transportation transportation = new Transportation();
//		Taxi t1 = (Taxi) transportation; //다운캐스팅이 안된다. 왜?? -> 부모클래스를 생성했을시 메모리 공간이
//		//부모 클래스의 메모리 공간만 생성되고 자식클래스는 부모와 자기자신의 메모리공간이 같이 생성되기 때문에
//		//담을 공간이 없기 때문에 안된다.
//		
//		
//		Transportation transportation1 = taxi;
//		Subway s1 = (Subway) transportation1; //다운 캐스팅이 안된다. 부모클래스는 같지만 택시와 지하철은 관계가 없기
//		//때문에 다운캐스팅이 되지 않는다.
//		
//		Transportation transportation2 = subway;
		
		//instanceof는 포함관계를 보고, getclass(), class는 명확하게 어떤 객체가 생성되었는지 보는 것

		Transportation[] transportations = new Transportation[6];
		
		//업캐스팅
		transportations[0] = taxi;
		transportations[1] = subway;
		transportations[2] = taxi;
		transportations[3] = subway;
		transportations[4] = taxi;
		transportations[5] = subway;
		
		
		//다운캐스팅
		for (int i = 0; i < transportations.length; i++) {
			
			if(transportations[i] instanceof Taxi) {
				Taxi tx = (Taxi)transportations[i];
				tx.checkTaxiNumber();
			}else if(transportations[i] instanceof Subway) {
				Subway sw = (Subway)transportations[i];
				sw.checkRoute();
			}
			
			
			transportations[i].go();
		}

		for(Transportation trans : transportations ) {
			trans.stop();
		}
		
	}

}
