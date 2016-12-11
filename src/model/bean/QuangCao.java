package model.bean;

public class QuangCao {
	private int idQuangcao;
	private String tenQuangcao;
	private String linkQuangcao;
	private String hinhanhQuangcao;
	public int getIdQuangcao() {
		return idQuangcao;
	}
	public void setIdQuangcao(int idQuangcao) {
		this.idQuangcao = idQuangcao;
	}
	public String getTenQuangcao() {
		return tenQuangcao;
	}
	public void setTenQuangcao(String tenQuangcao) {
		this.tenQuangcao = tenQuangcao;
	}
	public String getLinkQuangcao() {
		return linkQuangcao;
	}
	public void setLinkQuangcao(String linkQuangcao) {
		this.linkQuangcao = linkQuangcao;
	}
	public String getHinhanhQuangcao() {
		return hinhanhQuangcao;
	}
	public void setHinhanhQuangcao(String hinhanhQuangcao) {
		this.hinhanhQuangcao = hinhanhQuangcao;
	}
	public QuangCao(int idQuangcao, String tenQuangcao, String linkQuangcao, String hinhanhQuangcao) {
		super();
		this.idQuangcao = idQuangcao;
		this.tenQuangcao = tenQuangcao;
		this.linkQuangcao = linkQuangcao;
		this.hinhanhQuangcao = hinhanhQuangcao;
	}
	public QuangCao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
