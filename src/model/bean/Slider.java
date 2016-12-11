package model.bean;

public class Slider {
	private int idSlider;
	private String tenSlider;
	private String linkSlider;
	private String hinhanhSlider;
	private String motaSlider;
	public int getIdSlider() {
		return idSlider;
	}
	public void setIdSlider(int idSlider) {
		this.idSlider = idSlider;
	}
	public String getTenSlider() {
		return tenSlider;
	}
	public void setTenSlider(String tenSlider) {
		this.tenSlider = tenSlider;
	}
	public String getLinkSlider() {
		return linkSlider;
	}
	public void setLinkSlider(String linkSlider) {
		this.linkSlider = linkSlider;
	}
	public String getHinhanhSlider() {
		return hinhanhSlider;
	}
	public void setHinhanhSlider(String hinhanhSlider) {
		this.hinhanhSlider = hinhanhSlider;
	}
	
	public Slider(int idSlider, String tenSlider, String linkSlider, String hinhanhSlider, String motaSlider) {
		super();
		this.idSlider = idSlider;
		this.tenSlider = tenSlider;
		this.linkSlider = linkSlider;
		this.hinhanhSlider = hinhanhSlider;
		this.motaSlider = motaSlider;
	}
	public String getMotaSlider() {
		return motaSlider;
	}
	public void setMotaSlider(String motaSlider) {
		this.motaSlider = motaSlider;
	}
	public Slider() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
