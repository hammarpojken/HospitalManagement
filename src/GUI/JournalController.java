package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import GUI.DoctorViewController.Patient;
import Hospital.Doctor;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class JournalController {
	private Doctor doc;
	private Patient pat;
	
	@FXML
	private TextField fnametext;
	@FXML
	private TextField lnametext;
	@FXML
	private TextField adresstext;
	@FXML
	private TextField phonetext;
	
	@FXML
	public void initialize() {
		
		
		
	}
	
	public void setPatient(Patient p) {
		this.pat = p;
		fnametext.setText(pat.getFirstName());
        lnametext.setText(pat.getLastName());
        //adresstext.setText();
        //phonetext.setText();
	}
	public void setDoctor(Doctor d) {
		this.doc = d;
	}
	
	
	public void getJournal() {
	
		try {
			Connection con;
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "backstab1870");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select fname, lname, adress, phone FROM projecthospita.patient;");
				
	    while(rs.next()) { 
	    	  	fnametext.setText(rs.getString("firstname"));
		        lnametext.setText(rs.getString("lastname"));
		        adresstext.setText(rs.getString("adress"));
		        phonetext.setText(rs.getString("phone"));
			
	    }
	   
	    }
		catch (SQLException e) {
			
		}
	      
	    				
			
		
	}
		
}
