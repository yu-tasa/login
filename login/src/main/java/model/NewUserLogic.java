package model;

import dao.AccountsDAO;

public class NewUserLogic {
	public boolean execute(UserRegister ur) {
		AccountsDAO dao = new AccountsDAO();
		Account account = dao.findByNewUser(ur);
		return account == null;
	}
}
