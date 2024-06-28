package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.HashPassword;
import model.Login;
import model.UserRegister;

public class AccountsDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/sukkiriShop";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public Account findByLogin(Login login) {
		Account account = null;
		//JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバが読み込めませんでした");
		}
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			HashPassword hashPass = new HashPassword();
			String hP = hashPass.hashPassword(login.getPass());
			
			//SELECT文を準備
			String sql = "SELECT USER_ID, PASS, NAME, POSITION FROM ACCOUNTS WHERE USER_ID = ? AND PASS =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// 入力されたユーザーIDとパスワードを上記の?に入れることでログインできたユーザー情報を取得
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, hP);
			
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				//ユーザーが存在したらデータ取得
				//そのユーザーを表すAccountインスタンスを生成
				String userId = rs.getString("USER_ID");
				String pass =rs.getString("PASS");
				String name = rs.getString("NAME");
				String position = rs.getString("POSITION");
				//ユーザー情報を取得accountとして
				account = new Account(userId, pass, name, position);
			}
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		return account;
	}
	public Account findByNewUser(UserRegister ur) {
		Account account = null;
		//JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバが読み込めませんでした");
		}
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			HashPassword hashPass = new HashPassword();
			String hP = hashPass.hashPassword(ur.getPass());
			
			String sql = "INSERT INTO ACCOUNTS(USER_ID, PASS, NAME) VALUES (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// 入力されたユーザーIDとパスワードを上記の?に入れることでログインできたユーザー情報を取得
			pStmt.setString(1, ur.getUserId());
			pStmt.setString(2, hP);
			pStmt.setString(3, ur.getName());
			//SELECT文を実行し、結果表を取得
			int rs = pStmt.executeUpdate();
			System.out.println("ユーザーが登録されました");
			account = new Account(ur.getUserId(), hP, ur.getName());
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		return account;
	}
}
