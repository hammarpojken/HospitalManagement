package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hospital.Doctor;
import Hospital.Patient;
import Hospital.PatientUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class dbhandler {
	
	
	
	//--------------------------------------- LOGIN METHODS--------------------------------------------
	
	public static ResultSet getUser(String proffession, String userName, String passWord) throws SQLException {
		ResultSet rs;
		
		try {
			
			Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			
			if (proffession == "Staff") {
				 rs = st.executeQuery("select * FROM projecthospita.staff WHERE staff.username = '" + userName + "' AND staff.password = " + passWord + ";");
				 //con.close();
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
	public static ObservableList<Patient> getPatients(){
		ObservableList<Patient> data = FXCollections.observableArrayList();
		Connection con;
		ResultSet rs;
	try {
		con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");
		Statement st = con.createStatement();
		 rs = st.executeQuery("select * FROM mydb.patient;");
		 
		 while(rs.next()){
			 data.add(new Patient(
					 rs.getLong("ssn"),
					 rs.getString("fname"),
					 rs.getString("lname"),
					 rs.getLong("phone"),
					 rs.getString("username"),
					 rs.getString("password"),
					 rs.getString("adress"),
					 rs.getInt("zipcode"),
					 rs.getString("role"),
					 rs.getLong("doctorid"),
					 rs.getString("gender"),
					 rs.getInt("status_patient"),
					 rs.getDate("checkin_date"),
					 rs.getDate("checkout_date"),
					 rs.getInt("room"),
					 rs.getString("blood_type")));
		 }
		 

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	} finally {
		con.close();
	}
	return data;
	
	}
	
	public static ResultSet getResultCard(long ssn) {
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * FROM projecthospita.resultcard WHERE resultcard.patientssn = " + ssn);
			 if(rs.next() == true) {
				 
				 return rs;
			 }
			 
				  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	

	}
	
	public static ResultSet getPatientInfo(long ssn) {
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select projecthospita.patient.*, projecthospita.staff.fname AS doctorfname, projecthospita.staff.lname AS doctorlname"
					+ " from projecthospita.patient left join projecthospita.staff on patient.doctorid = staff.staffid WHERE patient.ssn = " + ssn );
			 if(rs.next() == true) {
				 
				 return rs;
			 }
			 
				  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}
	
	public static void setResultCard(String disease, String medicine, String test, String remark, long ssn) {
		System.out.println("hej");
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			
			st.executeUpdate("INSERT INTO projecthospita.resultcard (patientssn, disease, medicine, test, remark) VALUES (" + ssn + ",'" + disease + "','" + medicine + "','" + test + "','" + remark +"')");
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void updateResultCard(String disease, String medicine, String test, String remark, long ssn) {
		System.out.println("hej");
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			
			if (resultcardExist(ssn)) {
				st.executeUpdate("UPDATE projecthospita.resultcard SET patientssn = " + ssn + ", disease = '" + disease
						+ "', medicine = '" + medicine + "', test = '" + test + "', remark = '" + remark + "' WHERE patientssn = "+ ssn);
			}
			
		}
			catch (SQLException e) {
				e.printStackTrace();
			}

	}
	public static void updatePatient(String fname, String lname, String adress, long phone, long ssn) {
		System.out.println("hej");
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
				
			st.executeUpdate("UPDATE projecthospita.patient SET fname = '" + fname + "', lname = '" + lname + "', adress = '" + adress 
					+ "', phone = " + phone + ", ssn = " + ssn + " WHERE patient.ssn = " + ssn);
		}
			catch (SQLException e) {
				e.printStackTrace();
	
			}

	}
	public static boolean resultcardExist(long ssn) {
		
		Connection con;
		ResultSet rs;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
				
			rs = st.executeQuery("SELECT * FROM projecthospita.resultcard WHERE patientssn = " + ssn);
			if (rs.next()) {
				return true;
			}
		
		}
		
			catch (SQLException e) {
				
				e.printStackTrace();
				return false;
				
	
			}
		
		return false;
		
	}
	public static void assignDoctor(long ssn, long docid) {
		
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
				
			st.executeUpdate("UPDATE projecthospita.patient SET doctorid = " + docid + " WHERE patient.ssn = " + ssn);
		}
			catch (SQLException e) {
				e.printStackTrace();
	
			}
		
	}
	public static List<String> getDoctors() {
		
		Connection con;
		ResultSet rs;
		List<String> choices = new ArrayList<>();
		
		
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			rs = st.executeQuery("select * FROM projecthospita.staff WHERE role = 'doctor'");
			
			if(rs.next() == true) {
				rs.beforeFirst();
				
				while(rs.next()) {
					choices.add(rs.getString("fname") + " " + rs.getString("lname") + " " + rs.getLong("staffid"));
				}
				
			} else {
				choices = null;
			}
										
				
				  
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
		}
		return choices;
	}
		
	
	public static void updateJournal (String fname, String lname, String adress, long phone, long ssn, String disease, String medicine, String test, String remark) {
		
		dbhandler.updatePatient(fname, lname, adress, phone, ssn);
	
		dbhandler.updateResultCard(disease, medicine, test, remark, ssn);
		
		
	}
}
