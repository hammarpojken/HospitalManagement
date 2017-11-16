package GUI;

import Hospital.Patient;
import Utils.dbhandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
	
	@FXML
	public void initialize() {
		radioMale.setToggleGroup(tglGender);
	    radioMale.setToggleGroup(tglGender);
	    bloodType.setItems(FXCollections.observableArrayList(
	    "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+"));
	    
 //Input control events
	    
	    fNametext.focusedProperty().addListener(new ChangeListener<Boolean>()
	    {
	        @Override
	        public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
	        {
	            if (newPropertyValue)
	            {
	                
	            }
	            else
	            {
	            	String nametemp = fNametext.getText();
	            	if(nametemp.matches("^[a-zA-Z]+$")) {
	            		savebtn.setDisable(false);
	            		fNametext.setStyle("-fx-border-color: null");
	            		
	                }else  {
	                	fNametext.setStyle("-fx-border-color: RED");
	                	savebtn.setDisable(true);

	                }
	            	
	            	
	            }
	        }
	    });
	    
	    lNametext.focusedProperty().addListener(new ChangeListener<Boolean>()
	    {
	        @Override
	        public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
	        {
	            if (newPropertyValue)
	            {
	                
	            }
	            else
	            {
	            	String nametemp = lNametext.getText();
	            	if(nametemp.matches("^[a-zA-Z]+$")) {
	            		savebtn.setDisable(false);
	            		lNametext.setStyle("-fx-border-color: null");
	            		
	                }else  {
	                	lNametext.setStyle("-fx-border-color: RED");
	                	savebtn.setDisable(true);
	                }
	            	
	            	
	            }
	        }
	    });
	    
	    ssntext.focusedProperty().addListener(new ChangeListener<Boolean>()
	    {
	        @Override
	        public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
	        {
	            if (newPropertyValue)
	            {
	                
	            }
	            else
	            {
	            	String nametemp = ssntext.getText();
	            	if(nametemp.matches("^[0-9]{2}((0[0-9])|(10|11|12))(([1-2][0-9])|(3[0-1])|(0[1-9]))[0-9]{4}$")) {
	            		buttonUpdate.setDisable(false);
	            		ssntext.setStyle("-fx-border-color: null");
	            		
	                }else  {
	                	ssntext.setStyle("-fx-border-color: RED");
	                	buttonUpdate.setDisable(true);
	                }
	            	
	            	
	            }
	        }
	    });
	    
	    adresstext.focusedProperty().addListener(new ChangeListener<Boolean>()
	    {
	        @Override
	        public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
	        {
	            if (newPropertyValue)
	            {
	                
	            }
	            else
	            {
	            	String nametemp = adresstext.getText();
	            	if(nametemp.matches("^[a-zA-Z0-9 ]*$")) {
	            		buttonUpdate.setDisable(false);
	            		adresstext.setStyle("-fx-border-color: null");
	            		
	                }else  {
	                	adresstext.setStyle("-fx-border-color: RED");
	                	buttonUpdate.setDisable(true);
	                }
	            	
	            	
	            }
	        }
	    });
	    
	    ziptext.focusedProperty().addListener(new ChangeListener<Boolean>()
	    {
	        @Override
	        public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
	        {
	            if (newPropertyValue)
	            {
	                
	            }
	            else
	            {
	            	String nametemp = ziptext.getText();
	            	if(nametemp.matches("^[0-9]{5}$")) {
	            		buttonUpdate.setDisable(false);
	            		ziptext.setStyle("-fx-border-color: null");
	            		
	                }else  {
	                	ziptext.setStyle("-fx-border-color: RED");
	                	buttonUpdate.setDisable(true);
	                }
	            	
	            	
	            }
	        }
	    });
	    
	    phonetext.focusedProperty().addListener(new ChangeListener<Boolean>()
	    {
	        @Override
	        public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
	        {
	            if (newPropertyValue)
	            {
	                
	            }
	            else
	            {
	            	String nametemp = phonetext.getText();
	            	if(nametemp.matches("^[0-9]{9,10}$")) {
	            		buttonUpdate.setDisable(false);
	            		phonetext.setStyle("-fx-border-color: null");
	            		
	                }else  {
	                	phonetext.setStyle("-fx-border-color: RED");
	                	buttonUpdate.setDisable(true);
	                }
	            	
	            	
	            }
	        }
	    });
	    
	}
	
	@FXML
	public void createPatient() {

		Patient p = new Patient(Long.parseLong(ssntext.getText()), fNametext.getText(), lNametext.getText(), Long.parseLong(phonetext.getText()), adresstext.getText(),
				Integer.parseInt(ziptext.getText()), tglGender.getSelectedToggle().getUserData().toString(), bloodType.getSelectionModel().getSelectedItem());
		dbhandler.savePatient(p);
	
	}
	
	
	
	
	
	
}
