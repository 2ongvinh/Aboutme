package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.DanhNgon;
import model.bean.DuAn;

public class DuAnDAO {
	private ConnectDBLibrary connectDBLibrary;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public DuAnDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}
	public ArrayList<DuAn> getItems() {
		ArrayList<DuAn> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM duan";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idDuan = rs.getInt("id_duan");
				String tenDuan = rs.getString("ten_duan");
				String motaDuan = rs.getString("mota_duan");
				String hinhanhDuan = rs.getString("hinhanh_duan");
				String linkDuan = rs.getString("link_duan");
				DuAn objDuAn = new DuAn(idDuan, tenDuan, motaDuan, hinhanhDuan, linkDuan);
				listItem.add(objDuAn);
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
		String sql = "SELECT COUNT(*) AS countDA FROM duan";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("countDA");
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
	public ArrayList<DuAn> getItemsPagination(int offset, int row_count) {
		ArrayList<DuAn> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM duan LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, row_count);
			rs = pst.executeQuery();
			while (rs.next()) {
				int idDuan = rs.getInt("id_duan");
				String tenDuan = rs.getString("ten_duan");
				String motaDuan = rs.getString("mota_duan");
				String hinhanhDuan = rs.getString("hinhanh_duan");
				String linkDuan = rs.getString("link_duan");
				DuAn objDuAn = new DuAn(idDuan, tenDuan, motaDuan, hinhanhDuan, linkDuan);
				listItem.add(objDuAn);
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
	public int addItem(DuAn objDA) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "INSERT INTO duan(ten_duan, mota_duan, hinhanh_duan, link_duan) VALUES(?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objDA.getTenDuan());
			pst.setString(2, objDA.getMotaDuan());
			pst.setString(3, objDA.getHinhanhDuan());
			pst.setString(4, objDA.getLinkDuan());
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
	public DuAn getItemByID(int idDA1) {
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " SELECT * FROM duan WHERE id_duan = ? ";
		DuAn objDA = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idDA1);
			pst.executeQuery();
			rs = pst.executeQuery();
			if (rs.next()) {
				int idDuan = rs.getInt("id_duan");
				String tenDuan = rs.getString("ten_duan");
				String motaDuan = rs.getString("mota_duan");
				String hinhanhDuan = rs.getString("hinhanh_duan");
				String linkDuan = rs.getString("link_duan");
				objDA = new DuAn(idDuan, tenDuan, motaDuan, hinhanhDuan, linkDuan);
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
		return objDA;
	}
	public int delItem(int idDA1) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "DELETE FROM duan WHERE id_duan = ? LIMIT 1 ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idDA1);
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
	public int editItem(DuAn objDA) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " UPDATE duan SET ten_duan = ? , mota_duan = ? , hinhanh_duan = ? , link_duan = ? WHERE id_duan = ? ";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, objDA.getTenDuan());
			pst.setString(2, objDA.getMotaDuan());
			pst.setString(3, objDA.getHinhanhDuan());
			pst.setString(4, objDA.getLinkDuan());
			pst.setInt(5, objDA.getIdDuan());
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
	public int countDuAn() {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT COUNT(*) AS countDuAn FROM duan";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("countDuAn");
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
	

}
