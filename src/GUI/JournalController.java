package GUI;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.callback.Callback;

import Hospital.Doctor;
import Hospital.Medicine;
import Hospital.Patient;
import Hospital.Prescription;
import Hospital.Test;
import Utils.dbhandler;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class JournalController {
	
	private Doctor doctor;
	private Patient currentPatient;
	private TableView<Patient> tv;
	private DoctorViewController dc;
	//journal components
	@FXML
	private TableView<Medicine> tvMedicine;
	@FXML
	private TableView<Test> tvTests;
	@FXML
	private TableColumn<Medicine, String> nameCol;
	@FXML
	private TableColumn<Test, String> testTypeCol;
	@FXML
	private TableColumn<Medicine, String> typeCol;
	@FXML
	private TableColumn<Medicine, String> volumeCol;
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

	
	
	@FXML
	private void initialize(){
		nameCol.setCellValueFactory(new PropertyValueFactory<Medicine, String>("name"));
	    typeCol.setCellValueFactory(new PropertyValueFactory<Medicine, String>("type"));
	    volumeCol.setCellValueFactory(new PropertyValueFactory<Medicine, String>("volume"));
	    testTypeCol.setCellValueFactory(new PropertyValueFactory<Test, String>("type"));
	    
		
		
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
		
		tvMedicine.getItems().setAll(dbhandler.getMedicine(currentPatient.getSsn()));
		
		tvTests.getItems().setAll(dbhandler.getTest(currentPatient.getSsn()));
        System.out.println(dbhandler.getResultCardInfo(currentPatient.getSsn()).size());
        remarkarea.setText(dbhandler.getResultCardInfo(currentPatient.getSsn()).get(0).getRemark());
        
        diseasetext.setText(dbhandler.getResultCardInfo(currentPatient.getSsn()).get(0).getDiagnose());
        
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
