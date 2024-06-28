package model;

public class UserRegister {
	private String userId;
	private String pass;
	private String name;
	private String position;
	
	public UserRegister(String userId, String pass, String name) {
		this.userId = userId;
		this.pass = pass;
		this.name = name;
	}
	public UserRegister(String userId, String pass, String name, String position) {
		this.userId = userId;
		this.pass = pass;
		this.name = name;
		this.position = position;
	}
	public String getUserId() {return userId;}
	public String getPass() {return pass;}
	public String getName() {return name;}
	public String getPosition() {return position;}
}
