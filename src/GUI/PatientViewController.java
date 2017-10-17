package GUI;

import Hospital.MainApp;
import Hospital.PatientUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PatientViewController {
	
	private PatientUser p;
	private MainApp mainApp;
	
	@FXML
	private Button personalInfoBtn;
	@FXML
	private Button payBillBtn;
	@FXML
	@FXML
	@FXML
	@FXML
	@FXML
	@FXML
	@FXML
	public void initialize(){
		
	}
	public void setPatientUser(PatientUser pat) {
		this.p = pat;
	}
	
	public void setMainApp(MainApp app) {
		this.mainApp = app;
	}

}
