package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.ThongTin;

public class ThongTinDAO {
	private ConnectDBLibrary connectDBLibrary;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ThongTinDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}

	public ThongTin getItem() {
		ThongTin objThongTin = null;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM thongtin";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idThongtin = rs.getInt("id_thongtin");
				String diachi = rs.getString("diachi");
				int phone = rs.getInt("phone");
				String email = rs.getString("email");
				String skype = rs.getString("skype");
				String wordpress = rs.getString("wordpress");
				String facebook = rs.getString("facebook");
				String twitter = rs.getString("twitter");
				String googleplus = rs.getString("googleplus");
				String linkfacebook = rs.getString("link_facebook");
				String linktwitter = rs.getString("link_twitter");
				String linkgoogleplus = rs.getString("link_googleplus");
				
				
				objThongTin = new ThongTin(idThongtin, diachi, phone, email, skype, wordpress, facebook, twitter, googleplus,linkfacebook,linktwitter,linkgoogleplus);
				
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

		return objThongTin;
	}

	public int editItem(ThongTin objThongTin) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "UPDATE thongtin SET diachi = ?, phone = ?, email = ?, skype = ?,"
				+ " wordpress = ?, facebook = ?, link_facebook = ?, twitter = ?, link_twitter = ?, googleplus = ?, link_googleplus = ?"
				+ " WHERE id_thongtin = 1 ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objThongTin.getDiachi());
			pst.setInt(2, objThongTin.getPhone());
			pst.setString(3, objThongTin.getEmail());
			pst.setString(4, objThongTin.getSkype());
			pst.setString(5, objThongTin.getWordpress());
			pst.setString(6, objThongTin.getFacebook());
			pst.setString(7, objThongTin.getLinkfacebook());
			pst.setString(8, objThongTin.getTwitter());
			pst.setString(9, objThongTin.getLinktwitter());
			pst.setString(10, objThongTin.getGoogleplus());
			pst.setString(11, objThongTin.getLinkgoogleplus());
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
			return result;
		}
	}

}
