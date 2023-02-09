package simplechatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9090);
			System.out.println("=======<<server start>>=======");
			
			
			Socket socket =	serverSocket.accept(); // client의 접속을 기다리는 method
			System.out.println(socket.getInetAddress() + "success connect client");
			
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream,true);
			out.println("join");
			
			InputStream inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			
			String welcomeMessage = in.readLine();
			System.out.println(welcomeMessage);
			out.println(welcomeMessage);
			
			while(true) {
				in.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(serverSocket != null) {
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
