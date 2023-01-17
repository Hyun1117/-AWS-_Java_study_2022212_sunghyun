package WindowBuilder.view.panel;

import java.awt.CardLayout;

import javax.swing.JPanel;

import lombok.Data;


//모든 객체들이 쓰고 모든 객체들을 담아야하기 때문에
//싱글톤으로 만들었다.
@Data
public class MainPanel extends InitPanel{


	private static final long serialVersionUID = 1L;

	private CardLayout mainCard;
	
	private static MainPanel instance;
	
	public static MainPanel getInstance() {
		if(instance == null) {
			instance = new MainPanel();
		}
		return instance;
	}
	
	
	private MainPanel() {
		mainCard = new CardLayout();
		setLayout(mainCard);
	}
	
	public void init() {
		LoginPanel loginpanel = new LoginPanel();
		add(loginpanel, "loginPanel");
		
		RegisterPanel registerpanel = new RegisterPanel();
		add(registerpanel, "registerpanel");
	}
}
