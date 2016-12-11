package model.bean;

public class Users {
	private int idUsers;
	private String username;
	private String password;
	private String fullname;
	private String picture;
	private int idCapbac;
	private String tenCapbac;
	public int getIdUsers() {
		return idUsers;
	}
	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getIdCapbac() {
		return idCapbac;
	}
	public void setIdCapbac(int idCapbac) {
		this.idCapbac = idCapbac;
	}
	public String getTenCapbac() {
		return tenCapbac;
	}
	public void setTenCapbac(String tenCapbac) {
		this.tenCapbac = tenCapbac;
	}
	public Users(int idUsers, String username, String password, String fullname, String picture, int idCapbac,
			String tenCapbac) {
		super();
		this.idUsers = idUsers;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.picture = picture;
		this.idCapbac = idCapbac;
		this.tenCapbac = tenCapbac;
	}
	
	
	public Users(int idUsers, String username, String password, String fullname, String picture, int idCapbac) {
		super();
		this.idUsers = idUsers;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.picture = picture;
		this.idCapbac = idCapbac;
	}
	
	public Users(int idUsers, String username, String password, String fullname, String picture) {
		super();
		this.idUsers = idUsers;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.picture = picture;
		
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
