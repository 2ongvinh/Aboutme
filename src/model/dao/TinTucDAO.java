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
import model.bean.TinTuc;

public class TinTucDAO {
	private ConnectDBLibrary connectDBLibrary;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public TinTucDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}
	public ArrayList<TinTuc> getItems() {
		ArrayList<TinTuc> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM tintuc INNER JOIN danhmuctin ON danhmuctin.id_dmt = tintuc.id_dmt";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idTT = rs.getInt("id_tintuc");
				String tenTT = rs.getString("ten_tintuc");
				String motaTT = rs.getString("mota_tintuc");
				String chitietTT = rs.getString("chitiet_tintuc");
				String hinhanhTT = rs.getString("hinhanh_tintuc");
				Timestamp ngaydang = rs.getTimestamp("ngaydang");
				int idDMT = rs.getInt("id_dmt");
				String tenDMT = rs.getString("ten_dmt");
				int luotview = rs.getInt("luotview");
				int status = rs.getInt("status");
				int id_users = rs.getInt("id_users");
				TinTuc objTT = new TinTuc(idTT, tenTT, motaTT, chitietTT, hinhanhTT, ngaydang, idDMT, tenDMT, luotview, status, id_users);
				listItem.add(objTT);
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
	public ArrayList<TinTuc> getItemsTK() {
		ArrayList<TinTuc> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM tintuc INNER JOIN danhmuctin ON danhmuctin.id_dmt = tintuc.id_dmt INNER JOIN users ON tintuc.id_users = users.id_users";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idTT = rs.getInt("id_tintuc");
				String tenTT = rs.getString("ten_tintuc");
				String motaTT = rs.getString("mota_tintuc");
				String chitietTT = rs.getString("chitiet_tintuc");
				String hinhanhTT = rs.getString("hinhanh_tintuc");
				Timestamp ngaydang = rs.getTimestamp("ngaydang");
				int idDMT = rs.getInt("id_dmt");
				String tenDMT = rs.getString("ten_dmt");
				int luotview = rs.getInt("luotview");
				int status = rs.getInt("status");
				int id_users = rs.getInt("id_users");
				String tenUsers= rs.getString("username");
				TinTuc objTT = new TinTuc(idTT, tenTT, motaTT, chitietTT, hinhanhTT, ngaydang, idDMT, tenDMT, luotview,status,id_users,tenUsers);
				listItem.add(objTT);
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
	
	public TinTuc getItemByID(int idNews) {
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " SELECT * FROM tintuc INNER JOIN danhmuctin ON danhmuctin.id_dmt = tintuc.id_dmt WHERE id_tintuc = ? ";
		TinTuc objTT = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idNews);
			rs = pst.executeQuery();
			if (rs.next()) {
				int idTT = rs.getInt("id_tintuc");
				String tenTT = rs.getString("ten_tintuc");
				String motaTT = rs.getString("mota_tintuc");
				String chitietTT = rs.getString("chitiet_tintuc");
				String hinhanhTT = rs.getString("hinhanh_tintuc");
				Timestamp ngaydang = rs.getTimestamp("ngaydang");
				int idDMT = rs.getInt("id_dmt");
				String tenDMT = rs.getString("ten_dmt");
				int luotview = rs.getInt("luotview");
				int idUsers = rs.getInt("id_users");
				int status=rs.getInt("status");
				
				objTT = new TinTuc(idTT, tenTT, motaTT, chitietTT, hinhanhTT, ngaydang, idDMT, tenDMT, luotview, status, idUsers);
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
		return objTT;
	}
	public ArrayList<TinTuc> getItemsByID(int idCat) {
		ArrayList<TinTuc> listNewsByID = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
				String sql="SELECT * FROM tintuc INNER JOIN danhmuctin ON danhmuctin.id_dmt = tintuc.id_dmt WHERE tintuc.id_dmt = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCat);
			rs = pst.executeQuery();
			while (rs.next()) {
				int idTT = rs.getInt("id_tintuc");
				String tenTT = rs.getString("ten_tintuc");
				String motaTT = rs.getString("mota_tintuc");
				String chitietTT = rs.getString("chitiet_tintuc");
				String hinhanhTT = rs.getString("hinhanh_tintuc");
				Timestamp ngaydang = rs.getTimestamp("ngaydang");
				int idDMT = rs.getInt("id_dmt");
				String tenDMT = rs.getString("ten_dmt");
				TinTuc objTT = new TinTuc(idTT, tenTT, motaTT, chitietTT, hinhanhTT, ngaydang, idDMT, tenDMT);
				listNewsByID.add(objTT);
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

		return listNewsByID;
	}
	public int countItem() {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT COUNT(*) AS countTT FROM tintuc INNER JOIN danhmuctin ON danhmuctin.id_dmt = tintuc.id_dmt";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("countTT");
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
	public ArrayList<TinTuc> getItemsPagination(int offset, int row_count) {
		ArrayList<TinTuc> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM tintuc INNER JOIN danhmuctin ON danhmuctin.id_dmt = tintuc.id_dmt LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, row_count);
			rs = pst.executeQuery();
			while (rs.next()) {
				int idTT = rs.getInt("id_tintuc");
				String tenTT = rs.getString("ten_tintuc");
				String motaTT = rs.getString("mota_tintuc");
				String chitietTT = rs.getString("chitiet_tintuc");
				String hinhanhTT = rs.getString("hinhanh_tintuc");
				Timestamp ngaydang = rs.getTimestamp("ngaydang");
				int idDMT = rs.getInt("id_dmt");
				String tenDMT = rs.getString("ten_dmt");
				int luotview = rs.getInt("luotview");
				int status=rs.getInt("status");
				int id_users = rs.getInt("id_users");
				TinTuc objTT = new TinTuc(idTT, tenTT, motaTT, chitietTT, hinhanhTT, ngaydang, idDMT, tenDMT, luotview,status,id_users);
				listItem.add(objTT);
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
	public int countItem(int idCat) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT COUNT(*) AS countTT FROM tintuc INNER JOIN danhmuctin ON danhmuctin.id_dmt = tintuc.id_dmt WHERE tintuc.id_dmt="+idCat;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("countTT");
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
	public Object getItemsPagition1(int offset, int row_count, int idCat) {
		ArrayList<TinTuc> listItem =new ArrayList<>();
		String sql="select * from tintuc INNER JOIN danhmuctin on danhmuctin.id_dmt=tintuc.id_dmt WHERE tintuc.id_dmt=?  order by id_tintuc DESC LIMIT ?, ?";
		conn = connectDBLibrary.getConnectMySQL();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, idCat);
			pst.setInt(2, offset);
			pst.setInt(3, row_count);
			rs=pst.executeQuery();
			while(rs.next()){
				int idTT = rs.getInt("id_tintuc");
				String tenTT = rs.getString("ten_tintuc");
				String motaTT = rs.getString("mota_tintuc");
				String chitietTT = rs.getString("chitiet_tintuc");
				String hinhanhTT = rs.getString("hinhanh_tintuc");
				Timestamp ngaydang = rs.getTimestamp("ngaydang");
				int idDMT = rs.getInt("id_dmt");
				String tenDMT = rs.getString("ten_dmt");
				int status = rs.getInt("status");
				int luotview = rs.getInt("luotview");
				int idUsers = rs.getInt("id_users");
				TinTuc objTT = new TinTuc(idTT, tenTT, motaTT, chitietTT, hinhanhTT, ngaydang, idDMT, tenDMT, luotview, status, idUsers);
				listItem.add(objTT);
			}
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
		return listItem;
	}
	public int luotView(int idNews,int luot) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "UPDATE tintuc SET luotview = ? WHERE id_tintuc = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, luot);
			pst.setInt(2, idNews);
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
	public int addItem(TinTuc objTT) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		System.out.println(objTT.getIdUsers());
		String sql = "INSERT INTO tintuc(ten_tintuc, mota_tintuc, chitiet_tintuc, hinhanh_tintuc, ngaydang, id_dmt,luotview,status,id_users) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objTT.getTenTT());
			pst.setString(2, objTT.getMotaTT());
			pst.setString(3, objTT.getChitietTT());
			pst.setString(4, objTT.getHinhanhTT());
			pst.setTimestamp(5, objTT.getNgaydang());
			pst.setInt(6, objTT.getIdDMT());
			pst.setInt(7, objTT.getLuotview());
			pst.setInt(8, objTT.getStatus());
			pst.setInt(9, objTT.getIdUsers());
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
	public int delItem(int idNews) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "DELETE FROM tintuc WHERE id_tintuc = ? LIMIT 1 ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idNews);
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
	public int changeTT(int idNews, int i) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "UPDATE tintuc SET status=? WHERE id_tintuc=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, i);
			pst.setInt(2, idNews);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public TinTuc checkNews(String tenbaiviet) {
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " SELECT * FROM tintuc WHERE ten_tintuc = ? ";
		TinTuc objTT = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, tenbaiviet);
			rs = pst.executeQuery();
			if (rs.next()) {
				int idTT = rs.getInt("id_tintuc");
				String tenTT = rs.getString("ten_tintuc");
				String motaTT = rs.getString("mota_tintuc");
				String chitietTT = rs.getString("chitiet_tintuc");
				String hinhanhTT = rs.getString("hinhanh_tintuc");
				Timestamp ngaydang = rs.getTimestamp("ngaydang");
				int idDMT = rs.getInt("id_dmt");
				objTT = new TinTuc(idTT, tenTT, motaTT, chitietTT, hinhanhTT, ngaydang, idDMT);
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
		return objTT;
	}
	public int editItem(TinTuc objTT) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " UPDATE tintuc SET ten_tintuc = ?, mota_tintuc = ? , chitiet_tintuc = ? , hinhanh_tintuc = ? , ngaydang = ? , id_dmt = ? WHERE id_tintuc = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objTT.getTenTT());
			pst.setString(2, objTT.getMotaTT());
			pst.setString(3, objTT.getChitietTT());
			pst.setString(4, objTT.getHinhanhTT());
			pst.setTimestamp(5, objTT.getNgaydang());
			pst.setInt(6, objTT.getIdDMT());
			pst.setInt(7, objTT.getIdTT());
			result = pst.executeUpdate();
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
		return result;
	}
	public int CountLuotView() {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT SUM(luotview) AS countLuotView FROM tintuc";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("countLuotView");
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
	public int countBaiViet() {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT COUNT(*) AS countBaiViet FROM tintuc";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("countBaiViet");
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
	public int luotView(TinTuc objTT) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "UPDATE tintuc SET luotview =? ,ngaydang=? WHERE id_tintuc = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objTT.getLuotview()+1);
			pst.setTimestamp(2, objTT.getNgaydang());
			pst.setInt(3, objTT.getIdTT());
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
	public ArrayList<String[]> countNews() {
		ArrayList<String[]> listStringTT = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT COUNT(*) AS sobaiviet, users.username AS users FROM tintuc INNER JOIN users"
				+ " ON tintuc.id_users = users.id_users GROUP BY tintuc.id_users";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String sobaiviet=rs.getString("sobaiviet");
				String users=rs.getString("users");
				String mang[]={users,sobaiviet};
				listStringTT.add(mang);
			}
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
		return listStringTT;
	}
	
	public int delItemByIDUSER(int idUser) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "DELETE FROM tintuc WHERE id_users = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idUser);
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
	public int delItemByIDCAT(int idCat) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "DELETE FROM tintuc WHERE id_dmt = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCat);
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
