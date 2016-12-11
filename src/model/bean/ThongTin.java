package model.bean;

public class ThongTin {
	private int idThongtin;
	private String diachi;
	private int phone;
	private String email;
	private String skype;
	private String wordpress;
	private String facebook;
	private String twitter;
	private String googleplus;
	private String linkfacebook;
	private String linktwitter;
	private String linkgoogleplus;
	
	
	public String getLinkfacebook() {
		return linkfacebook;
	}
	public void setLinkfacebook(String linkfacebook) {
		this.linkfacebook = linkfacebook;
	}
	public String getLinktwitter() {
		return linktwitter;
	}
	public void setLinktwitter(String linktwitter) {
		this.linktwitter = linktwitter;
	}
	public String getLinkgoogleplus() {
		return linkgoogleplus;
	}
	public void setLinkgoogleplus(String linkgoogleplus) {
		this.linkgoogleplus = linkgoogleplus;
	}
	public int getIdThongtin() {
		return idThongtin;
	}
	public void setIdThongtin(int idThongtin) {
		this.idThongtin = idThongtin;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSkype() {
		return skype;
	}
	public void setSkype(String skype) {
		this.skype = skype;
	}
	public String getWordpress() {
		return wordpress;
	}
	public void setWordpress(String wordpress) {
		this.wordpress = wordpress;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getGoogleplus() {
		return googleplus;
	}
	public void setGoogleplus(String googleplus) {
		this.googleplus = googleplus;
	}
	public ThongTin(int idThongtin, String diachi, int phone, String email, String skype, String wordpress,
			String facebook, String twitter, String googleplus) {
		super();
		this.idThongtin = idThongtin;
		this.diachi = diachi;
		this.phone = phone;
		this.email = email;
		this.skype = skype;
		this.wordpress = wordpress;
		this.facebook = facebook;
		this.twitter = twitter;
		this.googleplus = googleplus;
	}
	
	
	public ThongTin(int idThongtin, String diachi, int phone, String email, String skype, String wordpress,
			String facebook, String twitter, String googleplus, String linkfacebook, String linktwitter,
			String linkgoogleplus) {
		super();
		this.idThongtin = idThongtin;
		this.diachi = diachi;
		this.phone = phone;
		this.email = email;
		this.skype = skype;
		this.wordpress = wordpress;
		this.facebook = facebook;
		this.twitter = twitter;
		this.googleplus = googleplus;
		this.linkfacebook = linkfacebook;
		this.linktwitter = linktwitter;
		this.linkgoogleplus = linkgoogleplus;
	}
	public ThongTin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
