package J12_배열.복습;



public class Array1 {
	
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		
		
		int[] nums = new int[5];
		
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		nums[3] = 40;
		nums[4] = 50;
		
		
		//new int [] {10,20,30,40,50}; 초기화때만 쓸 수 있음
		
		System.out.println((new int [] {10,20,40,40,50})[0]);//배열안에 데이터를 바꾸면 다른 배열로 바뀐다. 그래서 배열을 변수안에 넣어서 쓴다.
		System.out.println((new int [] {10,20,30,40,50})[1]);
		
		
		
	}
	
}
