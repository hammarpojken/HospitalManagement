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
	
	public void setResultCard() {
		
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "backstab1870");
			Statement st = con.createStatement();
			
			st.executeUpdate("INSERT INTO projecthospita.resultcard (disease, medicine, tests, remark) + VALUES (diseaseText.getText(), medicineText.getText(), testText.getText(), remarkArea.getText())");
		}catch (SQLException e) {
			
		}
	}
	
}


