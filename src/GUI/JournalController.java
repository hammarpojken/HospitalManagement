package GUI;

import java.sql.ResultSet;
import java.sql.SQLException;

import Hospital.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class JournalController {
	
	private Patient currentPatient;
	//journal components
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
	private TextField ssnText;
	@FXML
	private TextField diseaseText;
	@FXML
	private TextField medicineText;
	@FXML
	private TextField testText;
	@FXML
	private TextArea remarkArea;
	@FXML
	private Button buttonUpdate;
	
	@FXML
	private void initialize(){
		
	}
	
	public void setPatient(Patient p) {
		this.currentPatient = p;
	}
	public void setPatientInfo(Patient pat,  ResultSet rs) {
		fnametext.setText(pat.getFirstName());
        lnametext.setText(pat.getLastName());
        adresstext.setText(pat.getAdress());
        phonetext.setText(pat.getPhone() + "");
        ssnText.setText(pat.getSSN() + "");
        
        if(rs != null) {
        	try {
        		
				diseaseText.setText(rs.getString("disease"));
				medicineText.setText(rs.getString("medicine"));
				testText.setText(rs.getString("test"));
				remarkArea.setText(rs.getString("remark"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
	}
	
	

}
