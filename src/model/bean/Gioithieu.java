package model.bean;

public class Gioithieu {
	private int idGioithieu;
	private String ngayGioithieu;
	private String tieudeGioithieu;
	private String noidungGioithieu;
	private String hinhanhGioithieu;
	public int getIdGioithieu() {
		return idGioithieu;
	}
	public void setIdGioithieu(int idGioithieu) {
		this.idGioithieu = idGioithieu;
	}
	public String getNgayGioithieu() {
		return ngayGioithieu;
	}
	public void setNgayGioithieu(String ngayGioithieu) {
		this.ngayGioithieu = ngayGioithieu;
	}
	public String getTieudeGioithieu() {
		return tieudeGioithieu;
	}
	public void setTieudeGioithieu(String tieudeGioithieu) {
		this.tieudeGioithieu = tieudeGioithieu;
	}
	public String getNoidungGioithieu() {
		return noidungGioithieu;
	}
	public void setNoidungGioithieu(String noidungGioithieu) {
		this.noidungGioithieu = noidungGioithieu;
	}
	public String getHinhanhGioithieu() {
		return hinhanhGioithieu;
	}
	public void setHinhanhGioithieu(String hinhanhGioithieu) {
		this.hinhanhGioithieu = hinhanhGioithieu;
	}
	public Gioithieu(int idGioithieu, String ngayGioithieu, String tieudeGioithieu, String noidungGioithieu,
			String hinhanhGioithieu) {
		super();
		this.idGioithieu = idGioithieu;
		this.ngayGioithieu = ngayGioithieu;
		this.tieudeGioithieu = tieudeGioithieu;
		this.noidungGioithieu = noidungGioithieu;
		this.hinhanhGioithieu = hinhanhGioithieu;
	}
	public Gioithieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
