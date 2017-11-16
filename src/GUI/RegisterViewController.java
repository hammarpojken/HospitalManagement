package GUI;

import Hospital.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class RegisterViewController {

	private ReceptionistViewController rec;
	

	@FXML
	private TextField fNametext;
	@FXML
	private TextField lNametext;
	@FXML
	private TextField ssntext;
	@FXML
	private TextField adresstext;
	@FXML
	private TextField ziptext;
	@FXML
	private TextField citytext;
	@FXML
	private TextField phonetext;
	@FXML
	private ChoiceBox<String> bloodType;
	@FXML
	private Button savebtn;
	
	// Radio buttons
	
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
	
	
	
	
}
