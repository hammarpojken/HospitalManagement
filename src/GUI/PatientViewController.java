package GUI;

import java.sql.ResultSet;
import Hospital.Patient;
import Hospital.ResultCard;
import Utils.dbhandler;

import java.sql.SQLException;

import Hospital.MainApp;
import Hospital.PatientUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PatientViewController {
	
	private Patient currentPatient;
	private PatientUser p;
	private MainApp mainApp;
	
	@FXML
	private TextField diagnosetext;
	@FXML
	private TextArea remarkArea;
	@FXML
	private TableView<String> prescription;
	@FXML
	private TableView<String> tests;
	@FXML
	private TableView<String> appointments;
	
	@FXML
	public void initialize(){
		
		
	}
	public void setPatientUser(PatientUser pat) {
		this.p = pat;
	}
	
	public void setMainApp(MainApp app) {
		this.mainApp = app;
	}
	
	public void setResultcard () {
		remarkArea.setText(dbhandler.getResultCardInfo(p.getSSN()).get(0).getRemark());    
        diagnosetext.setText(dbhandler.getResultCardInfo(p.getSSN()).get(0).getDiagnose());
	}
}
