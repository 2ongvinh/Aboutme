package model.bean;

public class LienHe {
	private int idLienhe;
	private String tenLienhe;
	private String emailLienhe;
	private int sdtLienhe;
	private String noidungLienhe;
	public int getIdLienhe() {
		return idLienhe;
	}
	public void setIdLienhe(int idLienhe) {
		this.idLienhe = idLienhe;
	}
	public String getTenLienhe() {
		return tenLienhe;
	}
	public void setTenLienhe(String tenLienhe) {
		this.tenLienhe = tenLienhe;
	}
	public String getEmailLienhe() {
		return emailLienhe;
	}
	public void setEmailLienhe(String emailLienhe) {
		this.emailLienhe = emailLienhe;
	}
	public int getSdtLienhe() {
		return sdtLienhe;
	}
	public void setSdtLienhe(int sdtLienhe) {
		this.sdtLienhe = sdtLienhe;
	}
	public String getNoidungLienhe() {
		return noidungLienhe;
	}
	public void setNoidungLienhe(String noidungLienhe) {
		this.noidungLienhe = noidungLienhe;
	}
	public LienHe(int idLienhe, String tenLienhe, String emailLienhe, int sdtLienhe, String noidungLienhe) {
		super();
		this.idLienhe = idLienhe;
		this.tenLienhe = tenLienhe;
		this.emailLienhe = emailLienhe;
		this.sdtLienhe = sdtLienhe;
		this.noidungLienhe = noidungLienhe;
	}
	public LienHe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
