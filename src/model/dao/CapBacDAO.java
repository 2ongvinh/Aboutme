package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.CapBac;

public class CapBacDAO {
	private ConnectDBLibrary connectDBLibrary;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public CapBacDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}

	public ArrayList<CapBac> getItems() {
		ArrayList<CapBac> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM capbac";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idCapbac = rs.getInt("id_capbac");
				String tenCapbac = rs.getString("ten_capbac");
				
				CapBac objCapBac = new CapBac(idCapbac, tenCapbac);
				listItem.add(objCapBac);
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
}
