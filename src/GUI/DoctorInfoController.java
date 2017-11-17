package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Hospital.Doctor;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DoctorInfoController {
	private Doctor doc;
	
	@FXML
	private TextField fnametext;
	@FXML
	private TextField lnametext;
	@FXML
	private TextField doctoridtext;
	

	
	
	public void setDoctor(Doctor d) {
		this.doc = d;
	}
	
	public void setDoctorInfo() {
		
		fnametext.setText(doc.getfname());
		lnametext.setText(doc.getlname());
		doctoridtext.setText(doc.getId() + "");
				
	}


}
