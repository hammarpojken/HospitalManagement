package GUI;

import java.awt.Button;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Hospital.Doctor;
import Hospital.MainApp;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DoctorViewController {
	
	private Doctor doc;
	private MainApp mainapp;
	
	@FXML
	private TableView<Patient> tv;
	@FXML
	private TableColumn<Patient, String> nameCol;
	@FXML
	private TableColumn<Patient, String> lnameCol;
	@FXML
	private Button showJournal;
	@FXML
	public void initialize() {
		 nameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
	     lnameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
	     tv.getItems().setAll(getPatients());
	     
		
	}
	private ObservableList<Patient> getPatients(){
		Connection con;
		 ObservableList<Patient> data = FXCollections.observableArrayList();
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "backstab1870");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select fname, lname FROM projecthospita.patient;");
			
			while(rs.next()){
				data.add(new Patient(rs.getString(1), rs.getString(2), 22222222));
				  
                }
  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	
	}
	@FXML
	public void ShowJournal() throws IOException {
		Connection con;
		Patient p = tv.getSelectionModel().getSelectedItem();
		
		try {
			 // Load the fxml file and create a new stage for the popup dialog.
			
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(DoctorViewController.class.getResource("Journal.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
	        loader.getController().setPatient(p);
	        loader.getController().setDoctor(this.doc);

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Journal");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(null);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	       
	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();
	  
	    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
				
		
	}
	
	public void setMainApp(MainApp mainapp) {
		this.mainapp = mainapp; 
	}
	 public void setDoctor(Doctor d) {
	    	this.doc = d;
	    }
		
	
	
    public static class Patient {
    	 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleLongProperty SSN;
 
        public Patient(String fName, String lName, long SSN) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.SSN = new SimpleLongProperty(SSN);
        }
 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
        
        public long getSSN() {
        	return SSN.get();
        }
    }
    
    

}
    
    
    
    
