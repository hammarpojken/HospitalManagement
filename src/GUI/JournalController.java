package GUI;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.callback.Callback;

import Hospital.Doctor;
import Hospital.Medicine;
import Hospital.Patient;
import Hospital.Prescription;
import Hospital.Test;
import Utils.dbhandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.control.Toggle;

import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class JournalController {
	
	private Doctor doctor;
	private Patient currentPatient;
	private TableView<Patient> tv;
	private DoctorViewController dc;
	
	//journal components
	@FXML
	private boolean updateState = true;
	// Table Views
	@FXML
	private TableView<Medicine> tvMedicine;
	@FXML
	private TableView<Test> tvTests;
	
	// Table Columns
	@FXML
	private TableColumn<Medicine, String> nameCol;
	@FXML
	private TableColumn<Test, String> testTypeCol;
	@FXML
	private TableColumn<Medicine, String> typeCol;
	@FXML
	private TableColumn<Medicine, String> volumeCol;
	
	// Text Fields
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
	private Label checkinDate;
	@FXML
	private Label checkoutDate;
	
	
	//Toggle groups
	@FXML
	private ToggleGroup tglGender;
	@FXML
	private ToggleGroup tglStatus;
	
	//Radio buttons
	@FXML
	private RadioButton radioFemale;
	@FXML
	private RadioButton radioMale;
	@FXML
	private RadioButton radioInprocess;
	@FXML
	private RadioButton radioDischarged;
	@FXML
	private ChoiceBox<String> bloodChoice;
	@FXML
	private ChoiceBox<String> roomChoice;
	

	
	
	@FXML
	private void initialize(){
		// Table columns initialized
		nameCol.setCellValueFactory(new PropertyValueFactory<Medicine, String>("name"));
	    typeCol.setCellValueFactory(new PropertyValueFactory<Medicine, String>("type"));
	    volumeCol.setCellValueFactory(new PropertyValueFactory<Medicine, String>("volume"));
	    testTypeCol.setCellValueFactory(new PropertyValueFactory<Test, String>("type"));
	    radioMale.setToggleGroup(tglGender);
	    radioMale.setToggleGroup(tglGender);
	    bloodChoice.setItems(FXCollections.observableArrayList(
	    "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+"));
	    roomChoice.setItems(dbhandler.getRooms());
	    
	    //Input controll events
	    
	    fnametext.focusedProperty().addListener(new ChangeListener<Boolean>()
	    {
	        @Override
	        public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
	        {
	            if (newPropertyValue)
	            {
	                System.out.println("Textfield on focus");
	            }
	            else
	            {
	            	String nametemp = fnametext.getText();
	            	if(nametemp.matches("") )
	            	buttonUpdate.setDisable(true);
	                fnametext.setStyle("-fx-border-color: RED");
	            }
	        }
	    });
	    
	    
	    
	    
	    // toggleGroup/radioButtons initialized and added listener
	    tglGender = new ToggleGroup();
	    radioFemale.setToggleGroup(tglGender);
	    radioMale.setToggleGroup(tglGender);
	    
	    tglGender.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	        public void changed(ObservableValue<? extends Toggle> ov,
	                Toggle old_toggle, Toggle new_toggle) {
	                    if (tglGender.getSelectedToggle() != null) {
	                        tglGender.getSelectedToggle().setSelected(true);
	                        
	                        
	                    }                
	                }
	        });
	    
	    tglStatus = new ToggleGroup();
	    radioDischarged.setToggleGroup(tglStatus);
	    radioInprocess.setToggleGroup(tglStatus);
	    
	    tglStatus.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	        public void changed(ObservableValue<? extends Toggle> ov,
	                Toggle old_toggle, Toggle new_toggle) {
	                    if (tglStatus.getSelectedToggle() != null) {
	                        tglStatus.getSelectedToggle().setSelected(true);
	                        
	                        
	                    }                
	                }
	        });
		
		
	}
	
	public void setPatient(Patient p) {
		this.currentPatient = p;
	}
	public void setPatientInfo() {
		
		// personal info
		fnametext.setText(currentPatient.getFname());
		lnametext.setText(currentPatient.getLname());
		ssntext.setText(currentPatient.getSsn() + "");
		adresstext.setText(currentPatient.getAdress());
		ziptext.setText(currentPatient.getZipcode() + "");
		citytext.setText(dbhandler.getCity(currentPatient.getZipcode()));
		phonetext.setText(currentPatient.getPhone() + "");
		checkinDate.setText(currentPatient.getCheckin_date() + " " + currentPatient.getCheckinTime());
		checkoutDate.setText(currentPatient.getCheckout_date() + " " + currentPatient.getCheckoutTime());
		assignedDoctorText.setText(dbhandler.getDoctor(currentPatient.getDoctorid()));
		
		//room
		for(int i = 0; i< roomChoice.getItems().size(); i++) {
			String item = roomChoice.getItems().get(i);
			if(currentPatient.getRoom() == Integer.parseInt(item.substring(0, 1))){
				roomChoice.getSelectionModel().select(i);
				
			}
			
		}
		//bloodtype
		for(int i = 0; i< bloodChoice.getItems().size(); i++) {
			String item = bloodChoice.getItems().get(i);
			
			if(currentPatient.getBlood_type() !=  null && currentPatient.getBlood_type().equals(item)){
				bloodChoice.getSelectionModel().select(i);
				
			}
			
		}
			
		
		
		//Gender toggle
		if(currentPatient.getGender().equals("Female"))
			radioFemale.setSelected(true);
		else if (currentPatient.getGender().equals("Male"))
			radioMale.setSelected(true);
		
		//Patient status
		if(currentPatient.getStatus_patient() == true)
			radioInprocess.setSelected(true);
		else if (currentPatient.getStatus_patient()== false)
			radioDischarged.setSelected(true);
		
		
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
