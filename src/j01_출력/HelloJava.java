package j01_출력;

import j17_스태틱.싱클톤.KIA;

public class HelloJava { 
	// class는 모두 대문자로 시작한다.
	// 주석: 함수 설명이나 코드 내부에 메모를 할 때 쓴다.
	// 주석처리 된 것은 컴파일시 무시
	// 한 줄 주석
	// 들여쓰기 (tab)
	/*
	 * 여러줄 주석
	 */
	/**
	 * 
	 * 클래스, 메소드 등의 정보를 설명하기 위한 주석
	 */
	
	
	// 프로그램의 시작점
	public static void main(String[] args) {
		
		System.out.println("Hello,Java!!"); //println : 한줄의 문자열을 출력후 끝에 줄바꿈을 해라.
		System.out.println("주소 : 부산 동래구 온천동");
		System.out.println("이름 : 정성현");
		System.out.print("연락처 : 010-4758-8028"); //print : 줄바꿈 없이 출력
		System.out.println("수업 : AWS기반 공공빅데이터 활용 웹개발자 양성");
		
		
		
		//static을 이용해서 어디서든 접근이 가능하게 만들어주었다.
		System.out.println();
		
		KIA.getInstance().printCompanyName();
	}

}
