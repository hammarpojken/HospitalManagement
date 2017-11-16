package GUI;

import com.sun.java.swing.plaf.windows.WindowsTableHeaderUI;

import Hospital.Doctor;
import Hospital.Medicine;
import Hospital.Patient;
import Hospital.Prescription;
import Utils.dbhandler;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class PrescribeMedController {
	
	private Patient currentPatient;
	private Doctor doc;
	
	@FXML
	private TextArea prescInfo;
	@FXML
	private ChoiceBox<Medicine> medicines;
	@FXML
	private ChoiceBox<String> amount;
	@FXML
	private Button createBtn;


	
	
	@FXML
	public void initialize() {
		
		amount.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5"));
		medicines.setItems(dbhandler.getMedicine());
		//medicines.converterProperty();
	}
	@FXML
	public void createPrescription() {
		int medId = medicines.getSelectionModel().selectedItemProperty().get().getMedicineId();
		int withrawl = Integer.parseInt(amount.getSelectionModel().getSelectedItem());
		Prescription p = new Prescription()
		dbhandler.prescribeMed(currentPatient.getSsn(), )
		
		
	}
	public void setPatient(Patient p) {
		this.currentPatient = p;
	}
	public void setDoctor(Doctor d) {
		this.doc = d;
	}

}
