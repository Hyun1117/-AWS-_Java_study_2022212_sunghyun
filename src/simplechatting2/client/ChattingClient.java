package simplechatting2.client;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
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

import com.google.gson.Gson;
import com.google.protobuf.ByteString.Output;

import lombok.Getter;
import simplechatting2.dto.JoinReqDto;
import simplechatting2.dto.MessageReqDto;
import simplechatting2.dto.RequestDto;


@Getter
public class ChattingClient extends JFrame {

	private static ChattingClient instance;
	public static ChattingClient getInstance() {
		if(instance == null) {
			instance = new ChattingClient();
		}
		return instance;
	}
	
	private Socket socket;
	private String username;

	private JPanel contentPane;
	private JTextField ipinput;
	private JTextField portinput;
	private JTextArea contentView;
	private JTextField messageinput;
	private JList userList;
	private DefaultListModel<String> userListModel;
	private Gson gson;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = ChattingClient.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChattingClient() {
		gson = new Gson();
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

					JOptionPane.showMessageDialog(null,
							socket.getInetAddress() 
							+ " server connect"
							, "success connect",
							JOptionPane.INFORMATION_MESSAGE);
					
					ClientRecive clientRecive = new ClientRecive(socket);
					clientRecive.start();
					
					username = JOptionPane.showInputDialog(null,"사용자 이름을 입력해 주세요","이름입력",JOptionPane.INFORMATION_MESSAGE);
					JoinReqDto joinReqDto = new JoinReqDto(username);
					String joinReqDtoJson = gson.toJson(joinReqDto);
					RequestDto requestDto = new RequestDto("join", joinReqDtoJson);
					String requestDtoJson = gson.toJson(requestDto);
					
					OutputStream outputStream = socket.getOutputStream();
					PrintWriter out = new PrintWriter(outputStream, true);
					out.println(requestDtoJson);
					
					
				} catch (ConnectException e1) {
					JOptionPane.showMessageDialog(null,
							socket.getInetAddress()
							+ " server connect fail",
							"fail connect",
							JOptionPane.ERROR_MESSAGE);

				} catch (UnknownHostException e1) {
					e1.printStackTrace();

				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					if(socket != null) {
					}
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

							MessageReqDto messageReqDto = 
									new MessageReqDto("all", username, messageinput.getText());
							
							sendRequest("sendMessage", gson.toJson(messageReqDto));
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

						MessageReqDto messageReqDto = 
								new MessageReqDto("all", username, messageinput.getText());
						
						sendRequest("sendMessage", gson.toJson(messageReqDto));
						messageinput.setText("");
						
						

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		sendbutton.setBounds(565, 377, 62, 44);
		contentPane.add(sendbutton);

	}
	
	private void sendRequest(String resource, String body) {
		OutputStream outputStream;
		try {
			outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream,true);
			
			RequestDto requestDto = new RequestDto(resource, body);
			
			out.println(gson.toJson(requestDto));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
