package vip.wulinzeng.model;

/**
 * 用户实体
 * ident 辨认官员和普通用户
 * @author 22304
 *
 */
public class User {

	private int id;
	private String usernameString;
	private String passwordString;
	private String identString;//辨认0普通用户 1管理员
	private String telephoneString;
	private String addressString;
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
	public String getIdentString() {
		return identString;
	}
	public void setIdentString(String identString) {
		this.identString = identString;
	}
	public String getTelephoneString() {
		return telephoneString;
	}
	public void setTelephoneString(String telephoneString) {
		this.telephoneString = telephoneString;
	}
	public String getAddressString() {
		return addressString;
	}
	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}
	
	
}
