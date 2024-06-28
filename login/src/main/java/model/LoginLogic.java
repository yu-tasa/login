package model;

import dao.AccountsDAO;

public class LoginLogic {
	boolean isLogin;
	
	public boolean execute(Login login) {
		AccountsDAO dao = new AccountsDAO();
		Account account = dao.findByLogin(login);
		isLogin  = (account != null);
		return isLogin;
	}

	public boolean getIsLogin() {
		return isLogin;
	}
}
