package UserManagement.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class UserManagementFrame extends JFrame {

	private CardLayout mainCard;
	private JPanel MainPanel;
	private JPasswordField passwordField;
	private JTextField UsernameTextField;
	private JTextField registerUsername;
	private JPasswordField registerPasswordField;
	private JTextField registerNameField;
	private JTextField registerEmailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagementFrame frame = new UserManagementFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserManagementFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		MainPanel = new JPanel();
		MainPanel.setBackground(new Color(255, 255, 255));
		MainPanel.setBorder(null);

		setContentPane(MainPanel);
		mainCard = new CardLayout();
		MainPanel.setLayout(mainCard);

		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(new Color(255, 255, 255));
		MainPanel.add(loginPanel, "loginPanel");
		loginPanel.setLayout(null);
		
		JLabel logoText = new JLabel("UserManagement");
		logoText.setFont(new Font("CookieRun Regular", Font.BOLD, 23));
		logoText.setHorizontalAlignment(SwingConstants.CENTER);
		logoText.setBounds(74, 38, 232, 60);
		loginPanel.add(logoText);
		
		JLabel loginText = new JLabel("Login");
		loginText.setFont(new Font("Dialog", Font.BOLD, 25));
		loginText.setHorizontalAlignment(SwingConstants.CENTER);
		loginText.setBounds(150, 87, 86, 60);
		loginPanel.add(loginText);
		
		
		UsernameTextField = new JTextField();
		UsernameTextField.setBounds(74, 211, 232, 30);
		loginPanel.add(UsernameTextField);
		UsernameTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(74, 258, 232, 30);
		loginPanel.add(passwordField);
		
		JLabel userNameLabel = new JLabel("Username or email");
		userNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userNameLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		userNameLabel.setBounds(74, 195, 129, 15);
		loginPanel.add(userNameLabel);
		
		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		passwordLabel.setBounds(74, 245, 101, 15);
		loginPanel.add(passwordLabel);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.setForeground(new Color(192, 192, 192));
		LoginButton.setBackground(new Color(255, 255, 255));
		LoginButton.setFont(new Font("Dialog", Font.BOLD, 15));
		LoginButton.setBounds(74, 310, 232, 30);
		loginPanel.add(LoginButton);
		
		JLabel signupDesc = new JLabel("Don`t have an account?");
		signupDesc.setFont(new Font("Cambria", Font.PLAIN, 12));
		signupDesc.setBounds(101, 352, 122, 24);
		loginPanel.add(signupDesc);
		
		JLabel signupLink = new JLabel("sign up");
		signupLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("회원가입 클릭함!!!");
				mainCard.show(MainPanel, "registerPanel");
			}
		});
		signupLink.setForeground(new Color(141, 162, 241));
		signupLink.setBounds(229, 353, 49, 24);
		loginPanel.add(signupLink);
		
		JLabel forgotPasswordLink = new JLabel("Forgot yout password?");
		forgotPasswordLink.setForeground(new Color(141, 162, 241));
		forgotPasswordLink.setBounds(123, 373, 138, 24);
		loginPanel.add(forgotPasswordLink);
		
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(255, 255, 255));
		MainPanel.add(registerPanel, "registerPanel");
		registerPanel.setLayout(null);
		
		JLabel signInLink = new JLabel("sign in");
		signInLink.setFont(new Font("굴림", Font.BOLD, 15));
		signInLink.setForeground(new Color(141, 162, 241));
		signInLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(MainPanel, "loginPanel");
			}
		});
		signInLink.setHorizontalAlignment(SwingConstants.CENTER);
		signInLink.setBounds(245, 411, 127, 25);
		registerPanel.add(signInLink);
		
		JLabel registerLogoText2 = new JLabel("UserManagement");
		registerLogoText2.setHorizontalAlignment(SwingConstants.CENTER);
		registerLogoText2.setFont(new Font("CookieRun Regular", Font.BOLD, 23));
		registerLogoText2.setBounds(74, 38, 232, 60);
		registerPanel.add(registerLogoText2);
		
		JLabel registerText = new JLabel("Register");
		registerText.setHorizontalAlignment(SwingConstants.CENTER);
		registerText.setFont(new Font("Dialog", Font.BOLD, 25));
		registerText.setBounds(150, 87, 104, 60);
		registerPanel.add(registerText);
		
		JLabel registerUserNameLabel = new JLabel("Username");
		registerUserNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerUserNameLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		registerUserNameLabel.setBounds(74, 139, 129, 15);
		registerPanel.add(registerUserNameLabel);
		
		registerUsername = new JTextField();
		registerUsername.setColumns(10);
		registerUsername.setBounds(74, 155, 232, 30);
		registerPanel.add(registerUsername);
		
		JLabel registerPasswordLabel = new JLabel("password");
		registerPasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerPasswordLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		registerPasswordLabel.setBounds(74, 189, 101, 15);
		registerPanel.add(registerPasswordLabel);
		
		registerPasswordField = new JPasswordField();
		registerPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		registerPasswordField.setBounds(74, 202, 232, 30);
		registerPanel.add(registerPasswordField);
		
		JLabel registerNameLabel = new JLabel("name");
		registerNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerNameLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		registerNameLabel.setBounds(74, 238, 129, 15);
		registerPanel.add(registerNameLabel);
		
		registerNameField = new JTextField();
		registerNameField.setColumns(10);
		registerNameField.setBounds(74, 248, 232, 30);
		registerPanel.add(registerNameField);
		
		JLabel registerEmailLabel = new JLabel("email");
		registerEmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerEmailLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		registerEmailLabel.setBounds(74, 288, 101, 15);
		registerPanel.add(registerEmailLabel);
		
		registerEmailField = new JTextField();
		registerEmailField.setColumns(10);
		registerEmailField.setBounds(74, 301, 232, 30);
		registerPanel.add(registerEmailField);
		
		JButton RegisterButton = new JButton("Register");
		RegisterButton.setForeground(new Color(255, 255, 255));
		RegisterButton.setBackground(new Color(72, 191, 242));
		RegisterButton.setFont(new Font("Gadugi", Font.BOLD, 15));
		RegisterButton.setBounds(74, 341, 232, 30);
		registerPanel.add(RegisterButton);
		
	
	}
}
