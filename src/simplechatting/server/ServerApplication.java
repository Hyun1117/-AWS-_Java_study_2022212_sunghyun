package simplechatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
class ConnectedSocket extends Thread{
	
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private String username;
	
	public ConnectedSocket(Socket socket) {
		this.socket = socket;
		socketList.add(this);
	}
	
	@Override
	public void run() {
		try {
			outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);
			out.println("join");

			inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

			username = in.readLine();

			System.out.println(username + "님이 접속하였습니다.");
	
			String userListStr = "";
			
			for (int i = 0; i<socketList.size(); i++) {
				userListStr += socketList.get(i).getUsername();
				if(i < socketList.size() - 1) {
					userListStr +=",";
				}
			}
			
			for (ConnectedSocket connectedSocket : socketList) {
				outputStream = connectedSocket.getSocket().getOutputStream();
				out = new PrintWriter(outputStream, true);
				out.println("@welcome/" + username + "님이 접속하였습니다.");
				out.println("@userList/" + userListStr);
			}
			
			for(ConnectedSocket connectedSocket: socketList) {
				outputStream = connectedSocket.getSocket().getOutputStream();
				out = new PrintWriter(outputStream, true);
				out.println("@close/" + username + "님이 나가셨습니다.");
			}

			while (true) {
				String message = in.readLine();
				for (ConnectedSocket connectedSocket : socketList) {
					outputStream = connectedSocket.getSocket().getOutputStream();
					out = new PrintWriter(outputStream, true);
					out.println(message);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}

public class ServerApplication {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9090);
			System.out.println("=======<<server start>>=======");
			
			
			
			while (true) {
				Socket socket = serverSocket.accept(); // client의 접속을 기다리는 method
				ConnectedSocket connectedSocket = new ConnectedSocket(socket);
				connectedSocket.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println("=======<<server end!!>>========");
		}
	}

}
