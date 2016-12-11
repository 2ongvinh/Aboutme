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
import model.bean.QuangCao;
import model.bean.TinTuc;

public class QuangCaoDAO {
	private ConnectDBLibrary connectDBLibrary;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public QuangCaoDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}
	public ArrayList<QuangCao> getItems() {
		ArrayList<QuangCao> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM quangcao";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idQuangcao = rs.getInt("id_quangcao");
				String tenQuangcao = rs.getString("ten_quangcao");
				String linkQuangcao = rs.getString("link_quangcao");
				String hinhanhQuangcao = rs.getString("hinhanh_quangcao");
				
				QuangCao objQC = new QuangCao(idQuangcao, tenQuangcao, linkQuangcao, hinhanhQuangcao);
				listItem.add(objQC);
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
		String sql = "SELECT COUNT(*) AS countQC FROM quangcao";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("countQC");
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
	public ArrayList<QuangCao> getItemsPagination(int offset, int row_count) {
		ArrayList<QuangCao> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM quangcao LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, row_count);
			rs = pst.executeQuery();
			while (rs.next()) {
				int idQuangcao = rs.getInt("id_quangcao");
				String tenQuangcao = rs.getString("ten_quangcao");
				String linkQuangcao = rs.getString("link_quangcao");
				String hinhanhQuangcao = rs.getString("hinhanh_quangcao");
				
				QuangCao objQC = new QuangCao(idQuangcao, tenQuangcao, linkQuangcao, hinhanhQuangcao);
				listItem.add(objQC);
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
	public int addItem(QuangCao objQC) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "INSERT INTO quangcao(ten_quangcao, link_quangcao, hinhanh_quangcao) VALUES(?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objQC.getTenQuangcao());
			pst.setString(2, objQC.getLinkQuangcao());
			pst.setString(3, objQC.getHinhanhQuangcao());
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
	public QuangCao getItemByID(int idQC1) {
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " SELECT * FROM quangcao WHERE id_quangcao = ? ";
		QuangCao objQC = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idQC1);
			pst.executeQuery();
			rs = pst.executeQuery();
			if (rs.next()) {
				int idQuangcao = rs.getInt("id_quangcao");
				String tenQuangcao = rs.getString("ten_quangcao");
				String linkQuangcao = rs.getString("link_quangcao");
				String hinhanhQuangcao = rs.getString("hinhanh_quangcao");
				
			 objQC = new QuangCao(idQuangcao, tenQuangcao, linkQuangcao, hinhanhQuangcao);
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
		return objQC;
	}
	public int delItem(int idQC1) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "DELETE FROM quangcao WHERE id_quangcao = ? LIMIT 1 ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idQC1);
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
	public int editItem(QuangCao objQC) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " UPDATE quangcao SET ten_quangcao = ? , hinhanh_quangcao = ? , link_quangcao = ? WHERE id_quangcao = ? ";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, objQC.getTenQuangcao());
			pst.setString(2, objQC.getHinhanhQuangcao());
			pst.setString(3, objQC.getLinkQuangcao());
			pst.setInt(4, objQC.getIdQuangcao());
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
