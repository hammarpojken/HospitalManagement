package GUI;

import Hospital.Login;
import Hospital.MainApp;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    "Nurse", "Doctor", "Receptionist", "Patient", "Admin"));
	}
	
	public LoginViewController() {
		
		
	}
	@FXML
	private void tryLogin() {
		String tempUserName;
		String tempPass;
		String tempProff;
		
		tempUserName = userNameField.getText();
		tempPass = passwordField.getText();
		tempProff = (String) proffChoice.getSelectionModel().getSelectedItem();
		
		login = new Login(tempUserName, tempPass, tempProff);
		
		login.checkUser();
		
		
	}
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	

}
