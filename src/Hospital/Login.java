package Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Login {
	
	private String userName;
	private String passWord;
	private String proffession;
	private MainApp mainApp;
	private ResultSet rs = null;
	private Doctor doc;
	
	public Login(MainApp app, String uname, String pass, String proff) {
		this.mainApp = app;
		this.userName = uname;
		this.passWord = pass;
		this.proffession = proff;
		
	}
	// TODO if user does not exist inform the user.
	public boolean checkUser() throws SQLException {
		
		try {
			Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "backstab1870"
					);
			Statement st = con.createStatement();
			
			if (proffession == "Staff") {
				 rs = st.executeQuery("select * FROM projecthospita.staff WHERE staff.username = '" + userName + "' AND staff.password = " + passWord + ";");
				 rs.next();
				 if(rs.getString(3).equals("doctor"))
					 doc = new Doctor(rs.getString(1), rs.getString(2), rs.getString(3));
				 
	
					
			}
			else if (proffession == "Patient") {
				rs = st.executeQuery("select * FROM projecthospita.patient WHERE patient.username = '" + userName + "' AND patient.password = " + passWord + ";");
				
				
			}
			
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs.first())
			return true;
		return false;
		
		
		
	}
	public String checkRole() throws SQLException {
		return rs.getString(3);
	
			
	}
	public Doctor getDoc() {
		return doc;
	}
	


}
