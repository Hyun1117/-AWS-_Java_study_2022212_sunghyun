package j25_소켓.multiSockert;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


//Stream 통로, 관, server와 client간의 데이터를 소통하기위한 것
public class Server {
	
	private static final int PORT = 9090;
	
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);//기본적으로 내장된 라이브러리
			System.out.println("서버를 실행합니다.");
			
			while(true) {//client의 접속을 기다리는 무한루프
				
				Socket socket = serverSocket.accept();//client의 연결을 기다리다가,
				
				SocketServer socketServer = new SocketServer(socket);// client가 연결이 되면 socket객체를 하나 생성
				socketServer.start();//thread
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("서버를 종료합니다.");
		}
	
	}

}

