package GUI;

import java.io.IOException;
import java.sql.SQLException;

import Hospital.Login;
import Hospital.MainApp;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
				String role = login.checkRole();
				if(role.equals("nurse")) {
					 FXMLLoader loader = new FXMLLoader();
			         loader.setLocation(LoginViewController.class.getResource("../GUI/Journal.fxml"));
			         Pane journal = (Pane) loader.load();
			         mainApp.getRoot().setCenter(journal);
				}
				
			}
			System.out.println(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	

}
