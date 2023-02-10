package simplechatting.client;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChattingClient extends JFrame {

	private Socket socket;
	private String username;

	private JPanel contentPane;
	private JTextField ipinput;
	private JTextField portinput;
	private JTextArea contentView;
	private JTextField messageinput;
	private JList userList;
	private DefaultListModel<String> userListModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = new ChattingClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChattingClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ipinput = new JTextField();
		ipinput.setText("127.0.0.1");
		ipinput.setBounds(363, 11, 127, 26);
		contentPane.add(ipinput);
		ipinput.setColumns(10);

		JButton connectButton = new JButton("연결");
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;
				int port = 0;

				ip = ipinput.getText();
				port = Integer.parseInt(portinput.getText());

				try {
					socket = new Socket(ip, port);// 입력한 ip와 port번호로 접속하겠다.

					JOptionPane.showMessageDialog(null, socket.getInetAddress() + " server connect", "success connect",
							JOptionPane.INFORMATION_MESSAGE);

					InputStream inputStream = socket.getInputStream();
					BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

					if (in.readLine().equals("join")) {
						username = JOptionPane.showInputDialog(null, "사용자이름을 입력하세요.", JOptionPane.INFORMATION_MESSAGE);
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);

						out.println(username);

					}

					Thread thread = new Thread(() -> {
						try {
							InputStream input = socket.getInputStream();
							BufferedReader reader = new BufferedReader(new InputStreamReader(input));

							while (true) {
								String message = reader.readLine();
								// String method중에 어떤 문자열로 시작하는것을 알 수 있는 method
								if (message.startsWith("@welcome")) {
									int tokenIndex = message.indexOf("/");

									// substring -> tokenIndex + 1부터 문자열을 자르는 method
									message = message.substring(tokenIndex + 1);
								} else if (message.startsWith("@userList")) {
									
									int tokenIndex = message.indexOf("/");
									message = message.substring(tokenIndex + 1);
									String[] usernames = message.split(",");
									userListModel.clear();
									for(String username : usernames) {
										userListModel.addElement(username);
									}
									continue;
								}
								contentView.append(message + "\n");

							}

						} catch (IOException e1) {
							e1.printStackTrace();
						}
					});
					thread.start();

				} catch (ConnectException e1) {
					JOptionPane.showMessageDialog(null, socket.getInetAddress() + " server connect fail",
							"fail connect", JOptionPane.ERROR_MESSAGE);

				} catch (UnknownHostException e1) {
					e1.printStackTrace();

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		connectButton.setBounds(565, 10, 62, 27);
		contentPane.add(connectButton);

		portinput = new JTextField();
		portinput.setText("9090");
		portinput.setBounds(502, 11, 50, 26);
		contentPane.add(portinput);
		portinput.setColumns(10);

		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(12, 11, 343, 340);
		contentPane.add(contentScroll);

		JScrollPane userListScroll = new JScrollPane();
		userListScroll.setBounds(363, 47, 263, 304);
		contentPane.add(userListScroll);

		userListModel = new DefaultListModel<>();
		userList = new JList(userListModel);
		userListScroll.setViewportView(userList);

		contentView = new JTextArea();
		contentScroll.setViewportView(contentView);

		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(12, 377, 549, 44);
		contentPane.add(messageScroll);

		messageinput = new JTextField();
		messageinput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) { // 모든 키보드 입력에 동작됨
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!messageinput.getText().isBlank()) {
						try {
							OutputStream outputStream = socket.getOutputStream();
							PrintWriter out = new PrintWriter(outputStream, true);

							out.println(username + ": " + messageinput.getText());
							messageinput.setText("");

						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		messageScroll.setViewportView(messageinput);

		JButton sendbutton = new JButton("전송");
		sendbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!messageinput.getText().isBlank()) {
					try {
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream, true);
						messageinput.setText("");
						out.println(username + ": " + messageinput.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		sendbutton.setBounds(565, 377, 62, 44);
		contentPane.add(sendbutton);

	}
}
