package GUI;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import GUI.DoctorViewController.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class JournalController {
	
	@FXML
	private TextField fnametext;
	@FXML
	private TextField lnametext;
	@FXML
	private TextField adresstext;
	@FXML
	private TextField phonetext;
	
	
	public void getJournal() {
	
		try {
			
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "backstab1870");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select fname, lname, adress, phone FROM projecthospita.patient;");
				
	    while(rs.next()) { 
	   
	    }
	        fnametext.setText(rs.getString("firstname"));
	        lnametext.setText(rs.getString("lastname"));
	        adresstext.setText(rs.getString("adress"));
	        phonetext.setText(rs.getString("phone"));
		
	    				} 
			
		}
	}
		
}
