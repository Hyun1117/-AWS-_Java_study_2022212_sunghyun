package j25_소켓.multiSockert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer extends Thread {

	public static List<SocketServer> clientList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private static int autoIncrement = 1;
	private String name;

	public SocketServer(Socket socket) {
		this.socket = socket;
		name = "user" + autoIncrement++;
		clientList.add(this);
	}

	@Override
	public void run() {
		System.out.println("[연결된 클라이언트 정보]");
		System.out.println("ip: " + socket.getInetAddress());// ip주소를 가져다줌

		try {
			inputStream = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			sendToAll(name + "님이 접속하였습니다.");//브로드 캐스팅 -> 모든 client한테 데이터를 전송하는 것.
			while(true) {
				String message = reader.readLine();
				if(message == null) {//null 들어왔다는건 통신이 끊겼다는 것.
					break;
				}
				sendToAll(message);
			}


		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		
	}
	
	private void sendToAll(String message) throws IOException{
		for(SocketServer socketServer : clientList) {
			outputStream = socketServer.socket.getOutputStream();
			PrintWriter writer = new PrintWriter(outputStream,true);
			writer.println(name + ": " + message);
		}
	}
	
	
}
