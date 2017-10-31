package GUI;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Hospital.Doctor;
import Hospital.MainApp;
import Hospital.Patient;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DoctorViewController {
	
	private Doctor doc;
	private MainApp mainapp;
	private BorderPane journalLayout;
	

	@FXML
	private HBox DoctorHbox;
	@FXML
	private BorderPane DoctorViewPane;
	@FXML
	private TableView<Patient> tv;
	@FXML
	private TableColumn<Patient, String> nameCol;
	@FXML
	private TableColumn<Patient, String> lnameCol;
	@FXML
	private Button showJournal;
	@FXML
	private Button assignbtn;
	@FXML
	private Button appointmentbtn;
	@FXML
	private Button CreateRSbtn;



	@FXML
	public void initialize() {
		nameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
	    lnameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
	    
	   

	}
	

	@FXML
	public void ShowJournal() throws IOException {
		
		Patient p = tv.getSelectionModel().getSelectedItem();
		FXMLLoader loader = new FXMLLoader();

		
        loader.setLocation(DoctorViewController.class.getResource("Journal.fxml"));
        BorderPane page = (BorderPane) loader.load();
        
        JournalController controller = loader.getController();
        controller.setPatient(p);
        controller.setDoctor(doc);
        controller.setTable(this.tv);
        controller.setPatientInfo(doc.getPatientInfo(p.getSSN()), doc.getResultCard(p.getSSN()));
        
        if (DoctorHbox.getChildren().size() >= 3) {
        	DoctorHbox.getChildren().remove(2);
        }
        DoctorHbox.getChildren().add(page);
		
		

		
	}
	
	@FXML
	public void ShowResultCard() throws IOException {
		
		if(tv.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("You need to select a patient to create a resultcard");
			alert.showAndWait();
		}
			else if (tv.getSelectionModel().getSelectedItem() != null) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(DoctorViewController.class.getResource("CreateResultCard.fxml"));
	        BorderPane page = (BorderPane) loader.load();
	        
	        ResultCardController controller = loader.getController();
	        controller.setDoctor(doc);
	        controller.setSSN( tv.getSelectionModel().getSelectedItem().getSSN());
		
       
	        if (DoctorHbox.getChildren().size() >= 3)
	        	DoctorHbox.getChildren().remove(2);
	        DoctorHbox.getChildren().add(page);
			}
		
	}
	
	@FXML
	public void assignDoctor() {
		
		
		List<String> choices = new ArrayList<>();
		ResultSet rs = doc.getDoctors();
			
			
			try {
				while(rs.next()) {
					choices.add(rs.getString("fname") + " " + rs.getString("lname") + " " + rs.getLong("staffid"));
				}
				
				ChoiceDialog<String> dialog = new ChoiceDialog<>("Doctors", choices);
				dialog.setTitle("Choice Dialog");
				dialog.setHeaderText("Assign a doctor to " + tv.getSelectionModel().getSelectedItem().getFirstName() + " " +
						tv.getSelectionModel().getSelectedItem().getLastName());
				dialog.setContentText("Choose a doctor:");

				// Traditional way to get the response value.
				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()){
				    
				    long doctorid = Long.parseLong(result.get().substring(result.get().length() - 10));
				    long patient = tv.getSelectionModel().getSelectedItem().getSSN();
				    doc.assignDoctor(patient, doctorid);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
			

			
			
			 
				  
	
		
		
		

		
		
	}
	
	
	public void setJournalInfo() {
		tv.getItems().setAll(doc.getPatients());
		
	}
	



	public void setMainApp(MainApp mainapp) {
		this.mainapp = mainapp; 
	}
	 public void setDoctor(Doctor d) {
	    	this.doc = d;
	}

   
    
    

}
    
    
    
    
