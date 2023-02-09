package simplechatting.client;

import java.awt.EventQueue;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ChattingClient extends JFrame {

	private Socket socket;
	private String username;
	
	private JPanel contentPane;
	private JTextField ipinput;
	private JTextField portinput;
	private JTextArea contentView;

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
					socket = new Socket(ip, port);//입력한 ip와 port번호로 접속하겠다.
					
					JOptionPane.showMessageDialog(null,
								socket.getInetAddress() + " server connect",
								"success connect",
								JOptionPane.INFORMATION_MESSAGE);
					
					InputStream inputStream = socket.getInputStream();
					BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
					
					if(in.readLine().equals("join")) {
						username = JOptionPane.showInputDialog(null,"사용자이름을 입력하세요.",JOptionPane.INFORMATION_MESSAGE);
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter out = new PrintWriter(outputStream,true);
						out.println(username + "님이 접속하였습니다.");
						
						String welcomeMessage = in.readLine();
						contentView.append(welcomeMessage);
						
					}
				
				}catch (ConnectException e1) {
					JOptionPane.showMessageDialog(null,
							socket.getInetAddress() + " server connect fail",
							"fail connect",
							JOptionPane.ERROR_MESSAGE);
					
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
		portinput.setBounds(502, 11, 50, 26);
		contentPane.add(portinput);
		portinput.setColumns(10);
		
		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(12, 11, 343, 340);
		contentPane.add(contentScroll);
		
		
		JScrollPane userListScroll = new JScrollPane();
		userListScroll.setBounds(363, 47, 263, 304);
		contentPane.add(userListScroll);
		
		JList userList = new JList();
		userListScroll.setViewportView(userList);
		
		contentView = new JTextArea();
		contentScroll.setViewportView(contentView);
		
		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(12, 377, 549, 44);
		contentPane.add(messageScroll);
		
		JTextArea messageinput = new JTextArea();
		messageScroll.setViewportView(messageinput);
		
		JButton sendbutton = new JButton("전송");
		sendbutton.setBounds(565, 377, 62, 44);
		contentPane.add(sendbutton);
		
		
	}
}
