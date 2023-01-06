package j07_반복;

public class Continue {

	public static void main(String[] args) {
		
		
		int i = 0;
		while(i < 10) {
			
			if(i % 2 != 0) {
				i++;
				continue;
			}
			System.out.println("while i :" + i);
			i++;
		}
		
		
		for(int a = 0; a< 10; a++) {
			if(a % 2 != 0) {
				continue;// 다음 반복을 계속
			}
			System.out.println("i: " + a);
		}
		
		
	}

}
