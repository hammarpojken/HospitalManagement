package Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utils.dbhandler;



public class Login {
	
	private String userName;
	private String passWord;
	private String proffession;
	private MainApp mainApp;
	private ResultSet rs = null;
	private Doctor doc;
	private PatientUser pat;
	
	public Login(MainApp app, String uname, String pass, String proff) {
		this.mainApp = app;
		this.userName = uname;
		this.passWord = pass;
		this.proffession = proff;
		
	}
	// TODO if user does not exist inform the user.
	public boolean checkUser() throws SQLException {
		
			rs = dbhandler.getUser(this.proffession, this.userName, this.passWord);
			
			if (rs != null) {
				 
				 rs.next();
				 if(rs.getString("role").equals("Doctor")) {
					 doc = new Doctor(rs.getString("fname"), rs.getString("lname"), rs.getString("role"));
					 
				 }
				 else if (rs.getString("role").equals("Patient")) {
					 
					 pat = new PatientUser(rs.getString("fname"), rs.getString("lname"), rs.getString("role"), rs.getLong("ssn"));
					 
				 }
				 
				
			}
			
		if(rs != null)
			return true;
		return false;
		
		
		
	}
	public String checkRole() throws SQLException {
		return rs.getString("role");
	
			
	}
	public Doctor getDoc() {
		return doc;
	}
	public PatientUser getPatientUser() {
		System.out.println(pat.getfname());
		return pat;
	}
	


}
