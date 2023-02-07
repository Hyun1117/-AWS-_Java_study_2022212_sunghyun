package j25_소켓;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
//단일 양방향
public class SockerClient {
	
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("127.0.0.1",9090);//client의 socket은 ip와 server랑 연결시키는 port를 담아서 생성을한다.
			System.out.println("서버에 접속 성공!");
			
			InputStream inputStream = socket.getInputStream();
			InputStreamReader streamReader = new InputStreamReader(inputStream);
			//buffer -> 데이터를 한 덩어리씩 주고받고 할 때 필요하다. 안그러면 문자열을 하나씩 다 잘라서 받아야함
			BufferedReader reader = new BufferedReader(streamReader);
			
			System.out.println(reader.readLine());
			
		} catch (UnknownHostException e) {
			//ip를 잡지 못했을때
			e.printStackTrace();
		} catch (IOException e) {
			//socket의 input output이 전달 못했을때 인터넷이 끊기거나 등등
			e.printStackTrace();
		}
	}
	
}
