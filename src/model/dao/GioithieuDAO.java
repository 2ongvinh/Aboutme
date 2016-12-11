package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.DanhMucTin;
import model.bean.Gioithieu;


public class GioithieuDAO {
	private ConnectDBLibrary connectDBLibrary;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public GioithieuDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}

	public ArrayList<Gioithieu> getItems() {
		ArrayList<Gioithieu> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM gioithieu";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idGioithieu = rs.getInt("id_gt");
				String ngayGioithieu = rs.getString("ngay_gt");
				String tieudeGioithieu = rs.getString("tieude_gt");
				String noidungGioithieu = rs.getString("noidung_gt");
				String hinhanhGioithieu = rs.getString("hinhanh_gt");
				Gioithieu objGioithieu = new Gioithieu(idGioithieu, ngayGioithieu, tieudeGioithieu, noidungGioithieu, hinhanhGioithieu);
				listItem.add(objGioithieu);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listItem;
	}

	public Gioithieu getItemByID(int idGT) {
		Gioithieu objGT = null;
		String sql ="SELECT * FROM gioithieu WHERE id_gt = ?";
		conn = connectDBLibrary.getConnectMySQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idGT);
			rs = pst.executeQuery();
			if(rs.next()){
				int idGioithieu = rs.getInt("id_gt");
				String ngayGioithieu = rs.getString("ngay_gt");
				String tieudeGioithieu = rs.getString("tieude_gt");
				String noidungGioithieu = rs.getString("noidung_gt");
				String hinhanhGioithieu = rs.getString("hinhanh_gt");
				
				objGT = new Gioithieu(idGioithieu, ngayGioithieu, tieudeGioithieu, noidungGioithieu, hinhanhGioithieu);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return objGT;
	}

	public int editItem(Gioithieu objGT) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " UPDATE gioithieu SET ngay_gt = ? , tieude_gt = ? , noidung_gt = ? , hinhanh_gt = ? WHERE id_gt = ? ";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, objGT.getNgayGioithieu());
			pst.setString(2, objGT.getTieudeGioithieu());
			pst.setString(3, objGT.getNoidungGioithieu());
			pst.setString(4, objGT.getHinhanhGioithieu());
			pst.setInt(5, objGT.getIdGioithieu());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
