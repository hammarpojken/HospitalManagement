package GUI;

import GUI.DoctorViewController.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class JournalController {
	
	private Patient currentPatient;
	//journal components
	@FXML
	private TextField fnametext;
	@FXML
	private TextField lnametext;
	@FXML
	private TextField adresstext;
	@FXML
	private TextField phonetext;
	@FXML
	private Button buttonTest;
	
	@FXML
	private void initialize(){
		setPatientInfo(currentPatient);
	}
	
	public void setPatient(Patient p) {
		this.currentPatient = p;
	}
	public void setPatientInfo(Patient pat) {
		System.out.println(pat.getFirstName());
		fnametext.setText(pat.getFirstName());
        lnametext.setText(pat.getLastName());
        
        //adresstext.setText();
        //phonetext.setText();
	}
	
	

}
