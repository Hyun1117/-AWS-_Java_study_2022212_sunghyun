package J12_배열;

public class J12_UserMain {
	
		//웹 구조 MVC -> Service -> repository -> DB
	
		public static void main(String[] args) {
			
			J12_User[] users = new J12_User[0];
			J12_User[] users2 = new J12_User[100];
			
			J12_UserRepositoty UserRepositoty = new J12_UserRepositoty(users);
			J12_UserRepositoty UserRepositoty2 = new J12_UserRepositoty(users2);
			J12_UserService service = new J12_UserService(UserRepositoty);
			
			service.run();
			service.stop();
		}
		
}
