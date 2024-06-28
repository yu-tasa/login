package model;

public class Account {
	private String userId;
	private String pass;
	private String mail;
	private String name;
	private int age;
	private String position;
	
	public Account(String userId, String pass, String mail, String name, int age) {
		this.userId = userId;
		this.pass = pass;
		this.mail = mail;
		this.name = name;
		this.age = age;
	}

	public Account(String userId, String pass, String name) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.userId = userId;
		this.pass = pass;
		this.name = name;
	}
	public Account(String userId, String pass, String name, String position) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.userId = userId;
		this.pass = pass;
		this.name = name;
		this.position = position;
	}
	public String getUserId() {
		return userId;
	}

	public String getPass() {
		return pass;
	}

	public String getMail() {
		return mail;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public String getPosition() {
		return position;
	}
	
}
