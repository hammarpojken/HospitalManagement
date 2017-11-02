package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Hospital.Doctor;
import Hospital.Patient;
import Hospital.PatientUser;

public class dbhandler {
	
	//--------------------------------------- LOGIN METHODS--------------------------------------------
	
	public static ResultSet getUser(String proffession, String userName, String passWord) throws SQLException {
		ResultSet rs;
		
		try {
			
			Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			
			if (proffession == "Staff") {
				 rs = st.executeQuery("select * FROM projecthospita.staff WHERE staff.username = '" + userName + "' AND staff.password = " + passWord + ";");
				 con.close();
				 return rs;
				}
			
			else if (proffession == "Patient") {
				rs = st.executeQuery("select * FROM projecthospita.patient WHERE patient.username = '" + userName + "' AND patient.password = " + passWord + ";");
				con.close();
				return rs;
			}
			
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
			return rs = null;
			
		}
		
		return rs = null;
	}
	
	//-----------------------------------DOCTOR METHODS----------------------------------------------------------
	public static ResultSet getPatients(){
		Connection con;
		ResultSet rs;
	try {
		con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
		Statement st = con.createStatement();
		 rs = st.executeQuery("select fname, lname, adress, phone, ssn FROM projecthospita.patient;");
		 con.close();
		 
		 return rs;
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	return rs = null;
	}
	

}
