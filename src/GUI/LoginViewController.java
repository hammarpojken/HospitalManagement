package GUI;

import java.io.IOException;
import java.sql.SQLException;

import Hospital.Login;
import Hospital.MainApp;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class LoginViewController {
	
	private MainApp mainApp;
	private Login login;
	
	
	@FXML
	private TextField userNameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private ChoiceBox<String> proffChoice;
	
	@FXML
	public void initialize() {
		proffChoice.setItems(FXCollections.observableArrayList(
    "Staff", "Patient"));
	}
	
	public LoginViewController() {
		
		
	}
	@FXML
	private void tryLogin() throws IOException {
		String tempUserName;
		String tempPass;
		String tempProff;
		
		tempUserName = userNameField.getText();
		tempPass = passwordField.getText();
		tempProff = (String) proffChoice.getSelectionModel().getSelectedItem();
		
		login = new Login(this.mainApp, tempUserName, tempPass, tempProff);
		
		try {
			boolean b = login.checkUser();
			
			if (b == true) {
				FXMLLoader loader = new FXMLLoader();
				String role = login.checkRole();
				if(role.equals("nurse")) {
			         loader.setLocation(LoginViewController.class.getResource("../GUI/NurseView.fxml"));
			         Pane journal = (Pane) loader.load();
			         mainApp.getRoot().setCenter(journal);
			         
				}
				else if(role.equals("Doctor")) {
			         loader.setLocation(LoginViewController.class.getResource("../GUI/DoctorView.fxml"));
			         BorderPane journal = (BorderPane) loader.load();
			         DoctorViewController controller = loader.getController();
			         controller.setDoctor(login.getDoc());
			         controller.setMainApp(mainApp);
			         controller.setPatientTableView();
			         mainApp.getRoot().setCenter(journal);
			         mainApp.getPrimaryStage().setTitle(login.getDoc().getfname());
				
			    }
				else if(role.equals("admin")) {
			         loader.setLocation(LoginViewController.class.getResource("../GUI/AdminView.fxml"));
			         Pane journal = (Pane) loader.load();
			         mainApp.getRoot().setCenter(journal);
				}
				else if(role.equals("receptionist")) {
			         loader.setLocation(LoginViewController.class.getResource("../GUI/ReceptionistView.fxml"));
			         Pane journal = (Pane) loader.load();
			         mainApp.getRoot().setCenter(journal);
				}
				else if(role.equals("patient")) {
			         loader.setLocation(LoginViewController.class.getResource("../GUI/PatientView.fxml"));
			         Pane journal = (Pane) loader.load();
			         PatientViewController controller = loader.getController();
			         
			         controller.setMainApp(this.mainApp);
			         controller.setPatientUser(login.getPatientUser());
			         
			         controller.fillResultCard();
			         mainApp.getRoot().setCenter(journal);
				}
				
			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("The username or password does not exist");
				alert.showAndWait();
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	

}
