package model.bean;

import java.sql.Timestamp;


public class TinTuc {
	private int idTT;
	private String tenTT;
	private String motaTT;
	private String chitietTT;
	private String hinhanhTT;
	private Timestamp ngaydang;
	private int idDMT;
	private String tenDMT;
	private int luotview;
	private int status;
	private int idUsers;
	private String tenUsers;
	
	
	public String getTenUsers() {
		return tenUsers;
	}
	public void setTenUsers(String tenUsers) {
		this.tenUsers = tenUsers;
	}
	public int getIdUsers() {
		return idUsers;
	}
	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}
	public int getIdTT() {
		return idTT;
	}
	public void setIdTT(int idTT) {
		this.idTT = idTT;
	}
	public String getTenTT() {
		return tenTT;
	}
	public void setTenTT(String tenTT) {
		this.tenTT = tenTT;
	}
	public String getMotaTT() {
		return motaTT;
	}
	public void setMotaTT(String motaTT) {
		this.motaTT = motaTT;
	}
	public String getChitietTT() {
		return chitietTT;
	}
	public void setChitietTT(String chitietTT) {
		this.chitietTT = chitietTT;
	}
	public String getHinhanhTT() {
		return hinhanhTT;
	}
	public void setHinhanhTT(String hinhanhTT) {
		this.hinhanhTT = hinhanhTT;
	}
	public Timestamp getNgaydang() {
		return ngaydang;
	}
	public void setNgaydang(Timestamp ngaydang) {
		this.ngaydang = ngaydang;
	}
	public int getIdDMT() {
		return idDMT;
	}
	public void setIdDMT(int idDMT) {
		this.idDMT = idDMT;
	}
	public String getTenDMT() {
		return tenDMT;
	}
	public void setTenDMT(String tenDMT) {
		this.tenDMT = tenDMT;
	}
	
	public int getLuotview() {
		return luotview;
	}
	public void setLuotview(int luotview) {
		this.luotview = luotview;
	}
	public TinTuc(int idTT, String tenTT, String motaTT, String chitietTT, String hinhanhTT, Timestamp ngaydang,
			int idDMT, String tenDMT) {
		super();
		this.idTT = idTT;
		this.tenTT = tenTT;
		this.motaTT = motaTT;
		this.chitietTT = chitietTT;
		this.hinhanhTT = hinhanhTT;
		this.ngaydang = ngaydang;
		this.idDMT = idDMT;
		this.tenDMT = tenDMT;
	}
	
	
	public TinTuc(int idTT, String tenTT, String motaTT, String chitietTT, String hinhanhTT, Timestamp ngaydang,
			int idDMT, String tenDMT, int luotview) {
		super();
		this.idTT = idTT;
		this.tenTT = tenTT;
		this.motaTT = motaTT;
		this.chitietTT = chitietTT;
		this.hinhanhTT = hinhanhTT;
		this.ngaydang = ngaydang;
		this.idDMT = idDMT;
		this.tenDMT = tenDMT;
		this.luotview = luotview;
	
	}
	public TinTuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public TinTuc(int idTT, String tenTT, String motaTT, String chitietTT, String hinhanhTT, Timestamp ngaydang,
			int idDMT, String tenDMT, int luotview, int status, int idUsers) {
		super();
		this.idTT = idTT;
		this.tenTT = tenTT;
		this.motaTT = motaTT;
		this.chitietTT = chitietTT;
		this.hinhanhTT = hinhanhTT;
		this.ngaydang = ngaydang;
		this.idDMT = idDMT;
		this.tenDMT = tenDMT;
		this.luotview = luotview;
		this.status = status;
		this.idUsers = idUsers;
	}
	public TinTuc(int idTT, String tenTT, String motaTT, String chitietTT, String hinhanhTT, Timestamp ngaydang,
			int idDMT) {
		super();
		this.idTT = idTT;
		this.tenTT = tenTT;
		this.motaTT = motaTT;
		this.chitietTT = chitietTT;
		this.hinhanhTT = hinhanhTT;
		this.ngaydang = ngaydang;
		this.idDMT = idDMT;
	}
	public TinTuc(int idTT, String tenTT, String motaTT, String chitietTT, String hinhanhTT, Timestamp ngaydang,
			int idDMT, String tenDMT, int luotview, int status, int idUsers, String tenUsers) {
		super();
		this.idTT = idTT;
		this.tenTT = tenTT;
		this.motaTT = motaTT;
		this.chitietTT = chitietTT;
		this.hinhanhTT = hinhanhTT;
		this.ngaydang = ngaydang;
		this.idDMT = idDMT;
		this.tenDMT = tenDMT;
		this.luotview = luotview;
		this.status = status;
		this.idUsers = idUsers;
		this.tenUsers = tenUsers;
	}
	public TinTuc(int idTT, String tenTT, String motaTT, String chitietTT, String hinhanhTT, Timestamp ngaydang,
			int idDMT, int idUsers) {
		super();
		this.idTT = idTT;
		this.tenTT = tenTT;
		this.motaTT = motaTT;
		this.chitietTT = chitietTT;
		this.hinhanhTT = hinhanhTT;
		this.ngaydang = ngaydang;
		this.idDMT = idDMT;
		this.idUsers = idUsers;
	}
	
	
	
	

}
