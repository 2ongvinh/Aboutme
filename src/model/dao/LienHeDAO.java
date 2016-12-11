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
import model.bean.DuAn;
import model.bean.LienHe;
import model.bean.TinTuc;

public class LienHeDAO {
	
	private ConnectDBLibrary connectDBLibrary;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public LienHeDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}

	public int addItems(LienHe objLienhe) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "INSERT INTO lienhe(ten_lienhe, email_lienhe, sdt_lienhe, noidung_lienhe) VALUES(?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objLienhe.getTenLienhe());
			pst.setString(2, objLienhe.getEmailLienhe());
			pst.setInt(3, objLienhe.getSdtLienhe());
			pst.setString(4, objLienhe.getNoidungLienhe());
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
	public ArrayList<LienHe> getItems() {
		ArrayList<LienHe> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM lienhe";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				
				int idLienhe = rs.getInt("id_lienhe");
				
				String tenLienhe = rs.getString("ten_lienhe");
				String emailLienhe = rs.getString("email_lienhe");
				int sdtLienhe = rs.getInt("sdt_lienhe");
				String noidungLienhe = rs.getString("noidung_lienhe");
				LienHe objLH = new LienHe(idLienhe, tenLienhe, emailLienhe, sdtLienhe, noidungLienhe);
				listItem.add(objLH);
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
		String sql = "SELECT COUNT(*) AS countLH FROM lienhe";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("countLH");
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
	public ArrayList<LienHe> getItemsPagination(int offset, int row_count) {
		ArrayList<LienHe> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM lienhe LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, row_count);
			rs = pst.executeQuery();
			while (rs.next()) {
int idLienhe = rs.getInt("id_lienhe");
				
				String tenLienhe = rs.getString("ten_lienhe");
				String emailLienhe = rs.getString("email_lienhe");
				int sdtLienhe = rs.getInt("sdt_lienhe");
				String noidungLienhe = rs.getString("noidung_lienhe");
				LienHe objLH = new LienHe(idLienhe, tenLienhe, emailLienhe, sdtLienhe, noidungLienhe);
				listItem.add(objLH);
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

	public int delItem(int idLH) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "DELETE FROM lienhe WHERE id_lienhe = ? LIMIT 1 ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idLH);
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

	public LienHe getItemById(int idLH1) {
		LienHe objLH = null;
		String sql ="SELECT * FROM lienhe WHERE id_lienhe = ?";
		conn = connectDBLibrary.getConnectMySQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idLH1);
			rs = pst.executeQuery();
			if(rs.next()){
				int idLienhe = rs.getInt("id_lienhe");
				String tenLienhe = rs.getString("ten_lienhe");
				String emailLienhe = rs.getString("email_lienhe");
				int sdtLienhe = rs.getInt("sdt_lienhe");
				String noidungLienhe = rs.getString("noidung_lienhe");
				
				objLH = new LienHe(idLienhe, tenLienhe, emailLienhe, sdtLienhe, noidungLienhe);
				
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
		
		return objLH;
	}

}
