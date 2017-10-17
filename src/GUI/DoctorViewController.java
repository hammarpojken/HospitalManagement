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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DoctorViewController {
	
	private Doctor doc;
	private MainApp mainapp;
	
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
	//journal components
	@FXML
	private TextField fnametext;
	@FXML
	private TextField lnametext;
	@FXML
	private TextField adresstext;
	@FXML
	private TextField phonetext;
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
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "jqjipotv1");
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
	
	
	
	public void ShowJournal() throws IOException {
		
		Patient p = tv.getSelectionModel().getSelectedItem();
		getJournalLayout();
		showPatient(p);
		
	}
	public void getJournalLayout() {
		  FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(DoctorViewController.class.getResource("Journal.fxml"));
	        BorderPane page;
			try {
				page = (BorderPane) loader.load();
				 DoctorHbox.getChildren().add(page);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        loader.setController(this);
	  
	       
	}
	
	public void setMainApp(MainApp mainapp) {
		this.mainapp = mainapp; 
	}
	 public void setDoctor(Doctor d) {
	    	this.doc = d;
	    }
		
	
	public void showPatient(Patient pat) {
		
		fnametext.setText(pat.getFirstName());
        lnametext.setText(pat.getLastName());
        //adresstext.setText();
        //phonetext.setText();
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
    
    
    
    
