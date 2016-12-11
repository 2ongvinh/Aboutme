package model.bean;

public class DanhNgon {
	private int idDN;
	private String tacgiaDN;
	private String noidungDN;
	private String hinhanhDN;
	public int getIdDN() {
		return idDN;
	}
	public void setIdDN(int idDN) {
		this.idDN = idDN;
	}
	public String getTacgiaDN() {
		return tacgiaDN;
	}
	public void setTacgiaDN(String tacgiaDN) {
		this.tacgiaDN = tacgiaDN;
	}
	public String getNoidungDN() {
		return noidungDN;
	}
	public void setNoidungDN(String noidungDN) {
		this.noidungDN = noidungDN;
	}
	public String getHinhanhDN() {
		return hinhanhDN;
	}
	public void setHinhanhDN(String hinhanhDN) {
		this.hinhanhDN = hinhanhDN;
	}
	public DanhNgon(int idDN, String tacgiaDN, String noidungDN, String hinhanhDN) {
		super();
		this.idDN = idDN;
		this.tacgiaDN = tacgiaDN;
		this.noidungDN = noidungDN;
		this.hinhanhDN = hinhanhDN;
	}
	public DanhNgon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
