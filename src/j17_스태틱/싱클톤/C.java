package j17_스태틱.싱클톤;

public class C {

	public void showAll() {
		System.out.println();
		System.out.println("=========<<학생전체출력>>=========");
		A.getInstance().showStudents();
	}

}
