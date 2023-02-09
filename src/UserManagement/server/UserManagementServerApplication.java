package UserManagement.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class UserManagementServerApplication implements Runnable {
	
	private final static int PORT = 9090;
	private ServerSocket serverSocket;
	
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("==============<<server start!!>>==============");
			
			socketConnection();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket != null) {
					serverSocket.close();
				}
				System.out.println("==============<<server end!!>>==============");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	private void socketConnection() throws IOException {
		while(true) {
			Socket socket = serverSocket.accept();
			SocketServer socketServer = new SocketServer(socket);
			socketServer.start();
		}
	}
	
	public static void main(String[] args) {
		UserManagementServerApplication application = new UserManagementServerApplication();
		application.run();
	}
}
