package GUI;

import java.sql.ResultSet;
import java.sql.SQLException;

import Hospital.Doctor;
import Hospital.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class JournalController {
	
	private Doctor doctor;
	private Patient currentPatient;
	private TableView<Patient> tv;
	//journal components
	
	@FXML
	private Text doctorText;
	@FXML
	private TextField fnametext;
	@FXML
	private TextField lnametext;
	@FXML
	private TextField adresstext;
	@FXML
	private TextField phonetext;
	@FXML
	private TextField ssnText;
	@FXML
	private TextField diseaseText;
	@FXML
	private TextField medicineText;
	@FXML
	private TextField testText;
	@FXML
	private TextArea remarkArea;
	@FXML
	private Button buttonUpdate;
	@FXML
	private TextField assignedDoctorText;
	
	@FXML
	private void initialize(){
		
	}
	
	public void setPatient(Patient p) {
		this.currentPatient = p;
	}
	public void setPatientInfo(ResultSet rspat,  ResultSet rs) {
	
        try {
        	fnametext.setText(rspat.getString("fname"));
            lnametext.setText(rspat.getString("lname"));
            adresstext.setText(rspat.getString("adress"));
            phonetext.setText(rspat.getLong("phone") + "");
			ssnText.setText(rspat.getLong("ssn") + "");
			assignedDoctorText.setText(rspat.getString("doctorfname") + " " + rspat.getString("doctorlname"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        if(rs != null) {
        	try {
        		
				diseaseText.setText(rs.getString("disease"));
				medicineText.setText(rs.getString("medicine"));
				testText.setText(rs.getString("test"));
				remarkArea.setText(rs.getString("remark"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
	}
	
	public void updateJournal () {
		
		doctor.updateJournal(fnametext.getText(), lnametext.getText(), adresstext.getText(), Long.parseLong(phonetext.getText()),
				Long.parseLong(ssnText.getText()), diseaseText.getText(), medicineText.getText(), testText.getText(), remarkArea.getText());
		tv.getItems().clear();
		tv.getItems().setAll(doctor.getPatients());
		
	}
	public void setDoctor(Doctor doc) {
		this.doctor = doc;
	}
	
	public void setTable(TableView tv) {
		this.tv = tv;
	}
	
	
	

}
