package GUI;

import java.sql.ResultSet;
import java.sql.SQLException;

import Hospital.Doctor;
import Hospital.Patient;
import Utils.dbhandler;
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
	private DoctorViewController dc;
	
	@FXML
	private void initialize(){
		
	}
	
	public void setPatient(Patient p) {
		this.currentPatient = p;
	}
	public void setPatientInfo() {
	
                
        
        
	}
	
	public void updateJournal () {
		
		dbhandler.updateJournal(fnametext.getText(), lnametext.getText(), adresstext.getText(), Long.parseLong(phonetext.getText()),
				Long.parseLong(ssnText.getText()), diseaseText.getText(), medicineText.getText(), testText.getText(), remarkArea.getText());
		tv.getItems().clear();
		dc.setPatientTableView();
		
	}
	public void setDoctor(Doctor doc) {
		this.doctor = doc;
	}
	
	public void setTable(TableView tv) {
		this.tv = tv;
	}
	public void setParentController(DoctorViewController dc){
		this.dc = dc;
	}
	
	
	

}
