package vip.wulinzeng.model;

/**
 * �û�ʵ��
 * ident ���Ϲ�Ա����ͨ�û�
 * @author 22304
 *
 */
public class User {

	private int id;
	private String usernameString;
	private String passwordString;
	private String identString;//����0��ͨ�û� 1����Ա
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
