package test;

import dao.AccountsDAO;
import model.Account;
import model.Login;
import model.UserRegister;

public class AccountsDAOTest {
	public static void main(String[] args) {
			testFindByLoginOK();	//ユーザーが見つかる場合のテスト
			testFindByLoginNG();	//ユーザーが見つからない場合のテスト
			testFindByNewUserOK(); //新規登録の可否
	}
	
	public static void testFindByLoginOK() {
		Login login = new Login("minato", "1234");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByLogin(login);
		if(		result != null &&
				result.getUserId().equals("minato") &&
				result.getPass().equals("1234") &&
				result.getMail().equals("yusuke.minato@miyabilink.jp") &&
				result.getName().equals("湊　雄輔") &&
				result.getAge() == 23) {
			System.out.println("testFindByLoginOK：成功しました");
		}else {
			System.out.println("testFindByLoginOK：失敗しました");
		}
	}
	public static void testFindByLoginNG() {
		Login login = new Login("minato", "12345");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByLogin(login);
		if(result == null) {
			System.out.println("testFindByLoginNG：成功しました");
		}else {
			System.out.println("testFindByLoginNG：失敗しました");
		}
	}
	
	public static void testFindByNewUserOK() {
		UserRegister ur = new UserRegister("111", "111", "tasaki");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByNewUser(ur);
		if(result != null) {
			System.out.println("testFindByNewUserOK：成功しました");
		}else {
			System.out.println("testFindByNewUserNG：失敗しました");
		}
	}
}
