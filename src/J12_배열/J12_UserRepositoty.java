package J12_배열;


//저장소
public class J12_UserRepositoty {
	
	private J12_User[] userTable;

	public J12_UserRepositoty(J12_User[] userTable) {
		this.userTable = userTable;
	}
	
	public J12_User[] getUserTable() {
		return userTable;
	}
	
	public void saveUser(J12_User user) {
		extendArrayOne();
		userTable[userTable.length - 1] = user;
	}
	
	private void extendArray(int length) {
		J12_User[] newArray = new J12_User[userTable.length + length];
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}
	
	private void extendArrayOne() {
		J12_User[] newArray = new J12_User[userTable.length + 1];
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}
	
	private void transferDataToNewArray(J12_User[] oldArray, J12_User[] newArray) {
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
	
	public J12_User findUserByUsername(String username) {
		J12_User user = null;
		
		for(J12_User u : userTable) {
			if(u == null) {
				continue;
			}
			if(u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		
		return user;
	}
	
}




/*
 * 1. 사용자이름으로 회원 조회
 * 
 * 2. 회원 정보 수정
 * 	  수정할 사용자 이름을 입력하세요 : aaa
 *    해당 사용자 이름은 존재하지 않는 사용자 이름입니다.
 * 	
 * =====수정메뉴=====
 * << 사용자 이름: aaa>>
 * 1. 비밀번호 변경
 * 2. 이름 변경
 * 3. 이메일 변경
 * ==================
 * 
 * b. 뒤로가기
 * 
 * 수정 메뉴 선택 : 1
 * 
 * 
 * =======<<비밀번호 변경>>=======
 * 기존의 비밀번호를 입력하세요: 1234
 * [비밀번호가 틀리면] 비밀번호가 일치하지 않습니다.(수정메뉴로 이동)
 * [비밀번호가 일치하면]
 *  새로운 비밀번호를 입력하세요: 1111
 *  새로운 비밀번호를 확인해주세요: 1234
 *
 *  * [비밀번호가 틀리면] 비밀번호가 일치하지 않습니다.(수정메뉴로 이동)
 * [비밀번호가 일치하면]
 *  비밀번호 변경 완료
 * 
*/