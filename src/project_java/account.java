package project_java;

public class account {
	private String username;
	private String password;

	public account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean checkUser(account user) {
		if (user != null) {
			if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
