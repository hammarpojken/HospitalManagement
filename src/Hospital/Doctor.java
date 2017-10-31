package Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class Doctor extends Person {
	
	public Doctor(String firstName, String lastName, String role) {
		super(firstName, lastName, role);
	}
	
	
	
	public ObservableList<Patient> getPatients(){
		Connection con;
		 ObservableList<Patient> data = FXCollections.observableArrayList();
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select fname, lname, adress, phone, ssn FROM projecthospita.patient;");
			while(rs.next()){
				data.add(new Patient(rs.getString("fname"), rs.getString("lname"), rs.getString("adress"), rs.getInt("phone"),rs.getLong("ssn")));
				  
               }
			// Change JOIN? and remove disease, medicine, test from Patient DB
 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	

	
		
		
	
	
	public ResultSet getResultCard(long ssn) {
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
	public ResultSet getPatientInfo(long ssn) {
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * FROM projecthospita.patient WHERE patient.ssn = " + ssn);
			 if(rs.next() == true) {
				 
				 return rs;
			 }
			 
				  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}
	
	public void setResultCard(String disease, String medicine, String test, String remark, long ssn) {
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
		
		private void updateResultCard(String disease, String medicine, String test, String remark, long ssn) {
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
			
		private void updatePatient(String fname, String lname, String adress, long phone, long ssn) {
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
		
		public void updateJournal (String fname, String lname, String adress, long phone, long ssn, String disease, String medicine, String test, String remark) {
			
			this.updatePatient(fname, lname, adress, phone, ssn);
		
			this.updateResultCard(disease, medicine, test, remark, ssn);
			
			
		}
		
		public boolean resultcardExist(long ssn) {
			
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

}



