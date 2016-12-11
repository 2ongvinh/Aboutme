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
import model.bean.Users;

public class UsersDAO {
	private ConnectDBLibrary connectDBLibrary;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public UsersDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}

	public ArrayList<Users> getItems() {
		ArrayList<Users> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM users INNER JOIN capbac ON users.id_capbac = capbac.id_capbac";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idUsers = rs.getInt("id_users");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				String picture = rs.getString("picture");
				int idCapbac = rs.getInt("id_capbac");
				String tenCapbac = rs.getString("ten_capbac");
				Users objUsers = new Users(idUsers, username, password, fullname, picture, idCapbac, tenCapbac);
				listItem.add(objUsers);
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
	
	public Users getItemByID(int idUser) {
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " SELECT * FROM users INNER JOIN capbac ON users.id_capbac = capbac.id_capbac WHERE id_users = ? ";
		Users objUsers = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idUser);
			pst.executeQuery();
			rs = pst.executeQuery();
			if (rs.next()) {
				int idUsers = rs.getInt("id_users");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				String picture = rs.getString("picture");
				int idCapbac = rs.getInt("id_capbac");
				String tenCapbac = rs.getString("ten_capbac");
				objUsers = new Users(idUsers, username, password, fullname, picture, idCapbac, tenCapbac);
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
		return objUsers;
	}

	public int countItem() {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT COUNT(*) AS countUsers FROM users";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("countUsers");
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
	public ArrayList<Users> getItemsPagination(int offset, int row_count) {
		ArrayList<Users> listItem = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM users INNER JOIN capbac ON users.id_capbac = capbac.id_capbac LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, row_count);
			rs = pst.executeQuery();
			while (rs.next()) {
				int idUsers = rs.getInt("id_users");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				String picture = rs.getString("picture");
				int idCapbac = rs.getInt("id_capbac");
				String tenCapbac = rs.getString("ten_capbac");
				Users objUsers = new Users(idUsers, username, password, fullname, picture, idCapbac,tenCapbac);
				listItem.add(objUsers);
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

	public int addItem(Users objUsers) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "INSERT INTO users(username, password, fullname, picture, id_capbac) VALUES(?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objUsers.getUsername());
			pst.setString(2, objUsers.getPassword());
			pst.setString(3, objUsers.getFullname());
			pst.setString(4, objUsers.getPicture());
			pst.setInt(5, objUsers.getIdCapbac());
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

	public int delItem(int idUser) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "DELETE FROM users WHERE id_users = ? LIMIT 1 ";
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

	public int editItem(Users objUsers) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " UPDATE users SET username = ? , password = ? , fullname = ? , picture = ? , id_capbac = ? WHERE id_users = ? ";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, objUsers.getUsername());
			pst.setString(2, objUsers.getPassword());
			pst.setString(3, objUsers.getFullname());
			pst.setString(4, objUsers.getPicture());
			pst.setInt(5, objUsers.getIdCapbac());
			pst.setInt(6, objUsers.getIdUsers());
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
	public int editItem1(Users objUsers1) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " UPDATE users SET username = ? , password = ? , fullname = ? , picture = ? WHERE id_users = ? ";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, objUsers1.getUsername());
			pst.setString(2, objUsers1.getPassword());
			pst.setString(3, objUsers1.getFullname());
			pst.setString(4, objUsers1.getPicture());
			
			pst.setInt(5, objUsers1.getIdUsers());
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
	public Object checkLogin(String username1, String password1) {
		Users objUsers = null;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " SELECT * FROM users INNER JOIN capbac ON users.id_capbac = capbac.id_capbac WHERE username = ? && password = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username1);
			pst.setString(2, password1);
			rs=pst.executeQuery();
			
			if(rs.next()){
				int idUsers = rs.getInt("id_users");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				String picture = rs.getString("picture");
				int idCapbac = rs.getInt("id_capbac");
				String tenCapbac = rs.getString("ten_capbac");
				objUsers = new Users(idUsers, username, password, fullname, picture, idCapbac, tenCapbac);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return objUsers;
	}

	public ArrayList<String[]> countUsers() {
		ArrayList<String[]> listString = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT COUNT(*) AS sousers, capbac.ten_capbac AS capbac FROM users INNER JOIN capbac"
				+ " ON users.id_capbac = capbac.id_capbac GROUP BY users.id_capbac";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String sousers=rs.getString("sousers");
				String capbac=rs.getString("capbac");
				String mang[]={capbac,sousers};
				listString.add(mang);
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
		return listString;
	}

	public Object checkUsername(String username) {
		conn = connectDBLibrary.getConnectMySQL();
		String sql = " SELECT * FROM users WHERE username = ? ";
		Users objUsers = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if (rs.next()) {
				int idUsers = rs.getInt("id_users");
				String username1 = rs.getString("username");
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				String picture = rs.getString("picture");
				objUsers = new Users(idUsers, username1, password, fullname, picture);
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
		return objUsers;
	}
	

}
