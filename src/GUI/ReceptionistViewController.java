package GUI;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import Hospital.Doctor;
import Hospital.MainApp;
import Hospital.Patient;
import Hospital.Receptionist;
import Utils.dbhandler;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ReceptionistViewController {
	
	private Receptionist rec;
	private MainApp mainapp;
	private BorderPane journalLayout;
	private ObservableList<Patient> data;
	

	@FXML
	private HBox ReceptionistHbox;
	@FXML
	private BorderPane ReceptionistViewPane;
	@FXML
	private TableView<Patient> tv;
	@FXML
	private TableColumn<Patient, String> nameCol;
	@FXML
	private TableColumn<Patient, String> lnameCol;
	@FXML
	private Button registerPatient;
	@FXML
	private Button showJournal;
	@FXML
	private Button searchDoctor;
	@FXML
	private Button appointment;
	@FXML
	private Button showSchedule;	
	
	@FXML
	public void initialize() {
		nameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("fname"));
	    lnameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("lname"));
	    
	}
	

	@FXML
	public void ShowJournal() throws IOException {
		
		Patient p = tv.getSelectionModel().getSelectedItem();
		FXMLLoader loader = new FXMLLoader();

		
        loader.setLocation(ReceptionistViewController.class.getResource("Journal2.fxml"));
        BorderPane page = (BorderPane) loader.load();
        
        JournalController controller = loader.getController();
        controller.setPatient(p);
        
        controller.setParentControllerRec(this);
        controller.setTable(this.tv);
        controller.setPatientInfo();
        
        if (ReceptionistHbox.getChildren().size() >= 3) {
        	ReceptionistHbox.getChildren().remove(2);
        }
        ReceptionistHbox.getChildren().add(page);
        
	}
	
	public void setPatientTableView() {
		data = dbhandler.getPatients();
		
		if(data !=null) {
			tv.getItems().setAll(data);
			
		}
		
	}
	public void setMainApp(MainApp mainapp) {
		this.mainapp = mainapp; 
	}
	public ObservableList<Patient> getData() {
		return data;
	}
	
	public void registerPatient() throws IOException {

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(ReceptionistViewController.class.getResource("RegisterView.fxml"));
        BorderPane page = (BorderPane) loader.load();
        
        RegisterViewController controller = loader.getController();
        
        if (ReceptionistHbox.getChildren().size() >= 3) {
            ReceptionistHbox.getChildren().remove(2);
        }
         ReceptionistHbox.getChildren().add(page);
       
	
	}
	
	@FXML
	public void searchDoctor() throws IOException {
		
		
		List<Doctor> choices = dbhandler.getDoctors();
				
				if(choices != null) {
					ChoiceDialog<Doctor> dialog = new ChoiceDialog("Doctors", choices);
//					dialog.getItems().add(choices.get(0));
					dialog.setTitle("Choice Dialog");
					dialog.setHeaderText("");
					dialog.setContentText("Choose a doctor:");
	
					// Traditional way to get the response value.
					Optional<Doctor> result = dialog.showAndWait();
					if (result.isPresent()){
						
					  
						
						FXMLLoader loader = new FXMLLoader();

						loader.setLocation(ReceptionistViewController.class.getResource("DoctorInfo.fxml"));
				        BorderPane page = (BorderPane) loader.load();
				        
				        Doctor d = result.get();
				        DoctorInfoController controller = loader.getController();
				        controller.setDoctor(d);
				        controller.setDoctorInfo();
				        
				        if (ReceptionistHbox.getChildren().size() >= 3) {
				            ReceptionistHbox.getChildren().remove(2);
				        }
				         ReceptionistHbox.getChildren().add(page);
				         
				         
					}
				}
				
		
	}
	
	
	
	
	
}
