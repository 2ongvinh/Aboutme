package model.bean;

public class CapBac {
	private int idCapbac;
	private String tenCapbac;
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
	public CapBac(int idCapbac, String tenCapbac) {
		super();
		this.idCapbac = idCapbac;
		this.tenCapbac = tenCapbac;
	}
	public CapBac() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
