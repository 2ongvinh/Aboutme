package library;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDBLibrary {
	private Connection conn;
	private String url;
	private String user;
	private String pass;
	private String db;
	
	public ConnectDBLibrary(){
		

		
		
		this.db = "aboutme";
		this.url = "jdbc:mysql://localhost:3306/"+db+"?useUnicode=true&characterEncoding=UTF-8";
		//this.url = "jdbc:mysql://node39760-trannhatvinh.jelastic.skali.net/"+db+"?useUnicode=true&characterEncoding=UTF-8";
		this.user = "root";
		//this.pass = "LSYbai72698";
		this.pass = "";
		
		
	}
	
	public Connection getConnectMySQL(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		//ConnecDBLibrary connecDBLibrary = new ConnecDBLibrary();
		//System.out.println(connecDBLibrary.getConnectMySQL());
	}

}
