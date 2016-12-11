package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library.ConnectDBLibrary;
import model.bean.ViewHome;

public class ViewHomeDAO {
	private ConnectDBLibrary connectDBLibrary;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ViewHomeDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}

	public int luotView1(ViewHome objVH) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "UPDATE viewhome SET luotview_viewhome = luotview_viewhome+1";
		try {
			pst = conn.prepareStatement(sql);
			
			result = pst.executeUpdate();
			//result = 1;
		} catch (SQLException e) {
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
	public int CountLuotView1() {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT SUM(luotview_viewhome) AS countLuotView1 FROM viewhome";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("countLuotView1");
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
