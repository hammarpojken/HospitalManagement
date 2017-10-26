package GUI;

import Hospital.Doctor;
import Hospital.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ResultCardController {

private Doctor doctor;
private long ssn;

	
@FXML
private TextField diseaseText;
@FXML
private TextField medicineText;
@FXML
private TextArea remarkArea;
@FXML
private TextField testText;
@FXML
private Button RSbtn;

	public void setResultCard() {
	
		doctor.setResultCard(diseaseText.getText(), medicineText.getText(), testText.getText(), remarkArea.getText(), ssn);
	 
	
}
	public void setDoctor(Doctor doc) {
		
		this.doctor = doc;
	}
	
	public void setSSN(long ssn) {
		
		this.ssn = ssn;
	}







}
