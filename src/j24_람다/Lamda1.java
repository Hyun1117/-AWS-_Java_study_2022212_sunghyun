package j24_람다;

public  class Lamda1{
	
	public static void main(String[] args) {
		Instrument instrument = new Instrument() {
			
			@Override
			public String play(String instrument) {
				
				return instrument + "를 연주합니다.";
			}
		};
		
		Instrument instrument2 = (String item)->{
			return item +"를 연주합니다";
		};
		
		Instrument instrument1 = (x) -> x +"를 부순다.";
		
		
		System.out.println(instrument.play("기타"));
		System.out.println(instrument1.play("기타"));
		System.out.println(instrument2.play("트럼펫"));
		
		
	}
	
}
