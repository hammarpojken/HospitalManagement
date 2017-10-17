package GUI;

import Hospital.Patient;
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
	private TextField diseaseText;
	@FXML
	private TextField medicineText;
	@FXML
	private TextField testText;
	@FXML
	private Button buttonUpdate;
	
	@FXML
	private void initialize(){
		
	}
	
	public void setPatient(Patient p) {
		this.currentPatient = p;
	}
	public void setPatientInfo(Patient pat) {
		System.out.println(pat.getFirstName());
		fnametext.setText(pat.getFirstName());
        lnametext.setText(pat.getLastName());
        adresstext.setText(pat.getAdress());
        phonetext.setText(pat.getPhone() + "");
//        diseaseText.setText(pat.getDisease());
//        medicineText.setText(pat.getMedicine());
//        testText.setText(pat.getTest());
        
	}
	
	

}
