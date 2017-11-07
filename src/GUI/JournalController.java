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
	private TextField ssntext;
	@FXML
	private TextField ziptext;
	@FXML
	private TextField citytext;
	@FXML
	private TextField diseasetext;
	@FXML
	private TextField medicinetext;
	@FXML
	private TextField testtext;
	@FXML
	private TextArea remarkarea;
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
		
		fnametext.setText(currentPatient.getFname());
		lnametext.setText(currentPatient.getLname());
		ssntext.setText(currentPatient.getSsn() + "");
		adresstext.setText(currentPatient.getAdress());
		ziptext.setText(currentPatient.getZipcode() + "");
		citytext.setText(dbhandler.getCity(currentPatient.getZipcode()));
		phonetext.setText(currentPatient.getPhone() + "");
		
	
                
        
        
	}
	
	public void updateJournal () {
		
		dbhandler.updateJournal(fnametext.getText(), lnametext.getText(), adresstext.getText(), Long.parseLong(phonetext.getText()),
				Long.parseLong(ssntext.getText()), diseasetext.getText(), medicinetext.getText(), testtext.getText(), remarkarea.getText());
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
	@FXML
	public void getCity() {
		int zip = Integer.parseInt(ziptext.getText());
		citytext.setText(dbhandler.getCity(zip));
		
	}
	
	
	

}
