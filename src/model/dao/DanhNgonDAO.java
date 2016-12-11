package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import library.ConnectDBLibrary;
import model.bean.DanhNgon;
import model.bean.TinTuc;
import model.bean.Users;


public class DanhNgonDAO {
	private ConnectDBLibrary connectDBLibrary;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public DanhNgonDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}
	public ArrayList<DanhNgon> getItems() {
		ArrayList<DanhNgon> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM danhngon";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				
				int idDN = rs.getInt("id_danhngon");
				
				String noidungDN = rs.getString("noidung_danhngon");
				String tacgiaDN = rs.getString("tacgia_danhngon");
				String hinhanhDN = rs.getString("hinhanh_danhngon");
				DanhNgon objDN = new DanhNgon(idDN, tacgiaDN, noidungDN, hinhanhDN);
				listItem.add(objDN);
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
	public int countItem() {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT COUNT(*) AS countDN FROM danhngon";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("countDN");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

		return result;
	}
	public ArrayList<DanhNgon> getItemsPagination(int offset, int row_count) {
		ArrayList<DanhNgon> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM danhngon LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, row_count);
			rs = pst.executeQuery();
			while (rs.next()) {
				int idDN = rs.getInt("id_danhngon");
				String noidungDN = rs.getString("noidung_danhngon");
				String tacgiaDN = rs.getString("tacgia_danhngon");
				String hinhanhDN = rs.getString("hinhanh_danhngon");
				DanhNgon objDN = new DanhNgon(idDN, tacgiaDN, noidungDN, hinhanhDN);
				listItem.add(objDN);
			}
		} catch (SQLException e) {

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

		return listItem;
	}
	public int addItem(DanhNgon objDN) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "INSERT INTO danhngon(noidung_danhngon, tacgia_danhngon, hinhanh_danhngon) VALUES(?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objDN.getNoidungDN());
			pst.setString(2, objDN.getTacgiaDN());
			pst.setString(3, objDN.getHinhanhDN());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public DanhNgon getItemByID(int idDN1) {
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " SELECT * FROM danhngon WHERE id_danhngon = ? ";
		DanhNgon objDN = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idDN1);
			pst.executeQuery();
			rs = pst.executeQuery();
			if (rs.next()) {
				int idDN = rs.getInt("id_danhngon");
				String noidungDN = rs.getString("noidung_danhngon");
				String tacgiaDN = rs.getString("tacgia_danhngon");
				String hinhanhDN = rs.getString("hinhanh_danhngon");
				objDN = new DanhNgon(idDN, tacgiaDN, noidungDN, hinhanhDN);
			}
		} catch (SQLException e) {

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
		return objDN;
	}
	public int delItem(int idDN1) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "DELETE FROM danhngon WHERE id_danhngon = ? LIMIT 1 ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idDN1);
			result = pst.executeUpdate();
			// result = 1;
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
	public int editItem(DanhNgon objDN) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " UPDATE danhngon SET noidung_danhngon = ? , tacgia_danhngon = ? , hinhanh_danhngon = ? WHERE id_danhngon = ? ";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, objDN.getNoidungDN());
			pst.setString(2, objDN.getTacgiaDN());
			pst.setString(3, objDN.getHinhanhDN());
			pst.setInt(4, objDN.getIdDN());
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
