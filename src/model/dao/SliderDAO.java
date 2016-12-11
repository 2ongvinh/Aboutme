package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.DuAn;
import model.bean.QuangCao;
import model.bean.Slider;

public class SliderDAO {
	private ConnectDBLibrary connectDBLibrary;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public SliderDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}

	public ArrayList<Slider> getItems() {
		ArrayList<Slider> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM slider";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idSlider = rs.getInt("id_slider");
				String tenSlider = rs.getString("ten_slider");
				String linkSlider = rs.getString("link_slider");
				String hinhanhSlider = rs.getString("hinhanh_slider");
				String motaSlider = rs.getString("mota_slider");
				Slider objSlider = new Slider(idSlider, tenSlider, linkSlider, hinhanhSlider,motaSlider);
				listItem.add(objSlider);
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
		String sql = "SELECT COUNT(*) AS countS FROM slider";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("countS");
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
	public ArrayList<Slider> getItemsPagination(int offset, int row_count) {
		ArrayList<Slider> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM slider LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, row_count);
			rs = pst.executeQuery();
			while (rs.next()) {
				int idSlider = rs.getInt("id_slider");
				String tenSlider = rs.getString("ten_slider");
				String linkSlider = rs.getString("link_slider");
				String hinhanhSlider = rs.getString("hinhanh_slider");
				String motaSlider = rs.getString("mota_slider");
				Slider objSlider = new Slider(idSlider, tenSlider, linkSlider, hinhanhSlider,motaSlider);
				listItem.add(objSlider);
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

	public int addItem(Slider objSlider) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "INSERT INTO slider(ten_slider, mota_slider, hinhanh_slider, link_slider) VALUES(?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objSlider.getTenSlider());
			pst.setString(2, objSlider.getMotaSlider());
			pst.setString(3, objSlider.getHinhanhSlider());
			pst.setString(4, objSlider.getLinkSlider());
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

	public Slider getItemByID(int idS1) {
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " SELECT * FROM slider WHERE id_slider = ? ";
		Slider objSlider = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idS1);
			pst.executeQuery();
			rs = pst.executeQuery();
			if (rs.next()) {
				int idSlider = rs.getInt("id_slider");
				String tenSlider = rs.getString("ten_slider");
				String linkSlider = rs.getString("link_slider");
				String hinhanhSlider = rs.getString("hinhanh_slider");
				String motaSlider = rs.getString("mota_slider");
				 objSlider = new Slider(idSlider, tenSlider, linkSlider, hinhanhSlider,motaSlider);
				
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
		return objSlider;
	}

	public int editItem(Slider objSlider) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "UPDATE slider SET ten_slider=?,link_slider=?,hinhanh_slider=?,mota_slider=? WHERE id_slider=?";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, objSlider.getTenSlider());
			pst.setString(2, objSlider.getLinkSlider());
			pst.setString(3, objSlider.getHinhanhSlider());
			pst.setString(4, objSlider.getMotaSlider());
			pst.setInt(5, objSlider.getIdSlider());
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

	public int delItem(int idS1) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "DELETE FROM slider WHERE id_slider = ? LIMIT 1 ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idS1);
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
}
