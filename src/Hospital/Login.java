package Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Login {
	
	private String userName;
	private String password;
	private String proffession;
	
	public Login(String uname, String pass, String proff) {
		this.userName = uname;
		this.password = pass;
		this.proffession = proff;
		
	}
	
	public void checkUser() {
		try {
			Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/world?autoReconnect=true&useSSL=false", "root", "backstab1870"
					);
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select Name FROM world.city;");
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
