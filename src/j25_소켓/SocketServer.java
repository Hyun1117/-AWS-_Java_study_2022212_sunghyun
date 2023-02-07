package j25_소켓;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
//단일 양방향
public class SocketServer {
	
	public static final int PORT = 9090;
	
	public static void main(String[] args) {
		List<Socket> clients = new ArrayList<>();//client에서 보낸 socket을 담는 list
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);//port가 정해져 있음 port가 담겨져 있는체로 serversocket을 생성
			while(true) {
				
				System.out.println("클라이언트의 접속을 기다리고 있습니다.");
				Socket socket = serverSocket.accept();//client의 접속을 기다리는 method client의 요청이 오면 socket에 담음
				clients.add(socket);//client의 socket을 list의 추가 이것으로 client를 구별하거나 데이터를 구분함.
				System.out.println("클라이언트가 연결되었습니다.");
				System.out.println(clients);
				
				OutputStream outputStream = socket.getOutputStream();//
				PrintWriter out = new PrintWriter(outputStream,true);//printwriter -> 문자열을 보내주는 객체, 버퍼기능 탑재
				out.println("___server에 접속한 것을 환영합니다.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
