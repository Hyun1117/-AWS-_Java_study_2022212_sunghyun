package WindowBuilder;

import java.awt.EventQueue;

import WindowBuilder.view.frame.MainFrame;

//absolute -> panel의 layout, button 등등 자유롭게 이동가능하고, 조절가능
//cardlayout -> panelkey값이 존재 이것을 이용해 cardlayout에 어떤panel을 위에 올릴지 결정 할 수 있음
//border -> 테두리
//setBounds(x,y,높이,너비) -> 상속을 받아서 쓸 수 있다.
//frame
//panel
//테스팅은 하나부터 끝까지 전부 해야한다.
public class UserManagementApplication {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {// 익명클래스
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);// 보여주는걸 결정하는 메소드
				} catch (Exception e) {
					e.printStackTrace();
				}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
			}

		};
		// 이벤트를 큐형식으로 객체를 관리함.
		EventQueue.invokeLater(runnable);
	}
}
