package GUI;

import java.io.IOException;
import java.sql.ResultSet;
import Hospital.Patient;
import Hospital.ResultCard;
import Hospital.Test;
import Utils.dbhandler;

import java.sql.SQLException;

import Hospital.MainApp;
import Hospital.PatientUser;
import Hospital.Prescription;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
	private TableView<Prescription> tvMedicine;
	@FXML
	private TableView<Test> tvTests;
	
	// Table Columns
	@FXML
	private TableColumn<Prescription, String> nameCol;
	@FXML
	private TableColumn<Test, String> testTypeCol;
	@FXML
	private TableColumn<Prescription, String> typeCol;
	@FXML
	private TableColumn<Prescription, String> volumeCol;
	@FXML
	private TableColumn<Prescription, String> test;
	
	@FXML
	public void initialize(){
		// Table columns initialized
				nameCol.setCellValueFactory(new javafx.util.Callback<TableColumn.CellDataFeatures<Prescription, String>, ObservableValue<String>>() {
					
					@Override
					public ObservableValue<String> call(CellDataFeatures<Prescription, String> param) {
						
						return param.getValue().getMedicine().nameProperty();
					}
				});
				
				typeCol.setCellValueFactory(new javafx.util.Callback<TableColumn.CellDataFeatures<Prescription, String>, ObservableValue<String>>() {
				
					@Override
					public ObservableValue<String> call(CellDataFeatures<Prescription, String> param) {
						
						return param.getValue().getMed().get().typeProperty();
					}
				});
				
			    volumeCol.setCellValueFactory(new javafx.util.Callback<TableColumn.CellDataFeatures<Prescription, String>, ObservableValue<String>>() {
					
					@Override
					public ObservableValue<String> call(CellDataFeatures<Prescription, String> param) {
						
						return param.getValue().getMedicine().volumeProperty();
					}
				});
			    
			   
			    
			    test.setCellValueFactory(new javafx.util.Callback<TableColumn.CellDataFeatures<Prescription, String>, ObservableValue<String>>() {
					
					@Override
					public ObservableValue<String> call(CellDataFeatures<Prescription, String> param) {
						
						return param.getValue().prescIdProperty().asString();
					}
				});
			    
			    testTypeCol.setCellValueFactory(new PropertyValueFactory<Test, String>("type"));
			    
			    
		
	}
	
	public void prePopup() {
		Prescription p = tvMedicine.getSelectionModel().getSelectedItem();
	
        try {
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DoctorViewController.class.getResource("PrescriptionDialog.fxml"));
			DialogPane page =  loader.load();
			PrescriptionPopup controller = loader.getController();
			controller.setPrescription(p);
			controller.setinfo();
			
			Stage stage = new Stage();
			Scene scene = new Scene(page);
			stage.setScene(scene);
			
			stage.showAndWait();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
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
	
	public void setPatientTable() {
		
		tvMedicine.getItems().setAll(dbhandler.getPatientPrescriptions(p.getSSN()));
		tvTests.getItems().setAll(dbhandler.getTest(p.getSSN()));
	}
}
