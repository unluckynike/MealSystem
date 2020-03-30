package model;

public class User {
	private int id;
    private String usernameString;
    private String passwordString;
    private String emailString;
    
    public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsernameString() {
		return usernameString;
	}

	public void setUsernameString(String usernameString) {
		this.usernameString = usernameString;
	}

	public String getPasswordString() {
		return passwordString;
	}

	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
    
}
