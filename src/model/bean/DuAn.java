package model.bean;

public class DuAn {
	private int idDuan;
	private String tenDuan;
	private String motaDuan;
	private String hinhanhDuan;
	private String linkDuan;
	public int getIdDuan() {
		return idDuan;
	}
	public void setIdDuan(int idDuan) {
		this.idDuan = idDuan;
	}
	public String getTenDuan() {
		return tenDuan;
	}
	public void setTenDuan(String tenDuan) {
		this.tenDuan = tenDuan;
	}
	public String getMotaDuan() {
		return motaDuan;
	}
	public void setMotaDuan(String motaDuan) {
		this.motaDuan = motaDuan;
	}
	public String getHinhanhDuan() {
		return hinhanhDuan;
	}
	public void setHinhanhDuan(String hinhanhDuan) {
		this.hinhanhDuan = hinhanhDuan;
	}
	public String getLinkDuan() {
		return linkDuan;
	}
	public void setLinkDuan(String linkDuan) {
		this.linkDuan = linkDuan;
	}
	public DuAn(int idDuan, String tenDuan, String motaDuan, String hinhanhDuan, String linkDuan) {
		super();
		this.idDuan = idDuan;
		this.tenDuan = tenDuan;
		this.motaDuan = motaDuan;
		this.hinhanhDuan = hinhanhDuan;
		this.linkDuan = linkDuan;
	}
	public DuAn() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
