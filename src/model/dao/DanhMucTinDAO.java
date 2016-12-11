package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.DanhMucTin;
import model.bean.TinTuc;


public class DanhMucTinDAO {
	private ConnectDBLibrary connectDBLibrary;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public DanhMucTinDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}

	public ArrayList<DanhMucTin> getItems() {
		ArrayList<DanhMucTin> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM danhmuctin";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idDMT = rs.getInt("id_dmt");
				String tenDMT = rs.getString("ten_dmt");
				
				DanhMucTin objDMT = new DanhMucTin(idDMT, tenDMT);
				listItem.add(objDMT);
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
		String sql = "SELECT COUNT(*) AS countCat" + " FROM danhmuctin";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("countCat");
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

	public ArrayList<DanhMucTin> getItemsPagination(int offset, int row_count) {
		ArrayList<DanhMucTin> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM danhmuctin LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, row_count);
			rs = pst.executeQuery();
			while (rs.next()) {
				int idDMT = rs.getInt("id_dmt");
				String tenDMT = rs.getString("ten_dmt");
				
				DanhMucTin objDMT = new DanhMucTin(idDMT, tenDMT);
				listItem.add(objDMT);
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

	public int addItem(DanhMucTin objDMT) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "INSERT INTO danhmuctin(ten_dmt) VALUES(?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objDMT.getTenDMT());
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

	public DanhMucTin getItem(int idCat) {
		DanhMucTin objDMT = null;
		String sql ="SELECT * FROM danhmuctin WHERE id_dmt = ?";
		conn = connectDBLibrary.getConnectMySQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCat);
			rs = pst.executeQuery();
			if(rs.next()){
				int idDMT = rs.getInt("id_dmt");
				String tenDMT = rs.getString("ten_dmt");
				
				objDMT = new DanhMucTin(idDMT, tenDMT);
				
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
		
		return objDMT;
	}

	public int delItem(int idCat) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "DELETE FROM danhmuctin WHERE id_dmt = ? LIMIT 1 ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCat);
			result = pst.executeUpdate();
			//result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
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

	public int editItem(DanhMucTin objDMT) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "UPDATE danhmuctin SET ten_dmt = ? WHERE id_dmt = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objDMT.getTenDMT());
			pst.setInt(2, objDMT.getIdDMT());
			result = pst.executeUpdate();
			//result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
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

	public Object checkCat(String tendanhmuc) {
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " SELECT * FROM danhmuctin WHERE ten_dmt = ? ";
		DanhMucTin objDMT = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, tendanhmuc);
			rs = pst.executeQuery();
			if (rs.next()) {
				int idDMT = rs.getInt("id_dmt");
				String tenDMT = rs.getString("ten_dmt");
				objDMT = new DanhMucTin(idDMT, tenDMT);
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
		return objDMT;
	}

}
