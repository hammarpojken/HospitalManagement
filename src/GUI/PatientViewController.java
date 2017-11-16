package GUI;

import java.sql.ResultSet;
import java.sql.SQLException;

import Hospital.MainApp;
import Hospital.PatientUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PatientViewController {
	
	private PatientUser p;
	private MainApp mainApp;
	
	@FXML
	private Button personalInfoBtn;
	@FXML
	private Button payBillBtn;
	@FXML
	private TextField diseaseText;
	@FXML
	private TextField testText;
	@FXML
	private TextField medicineText;
	@FXML
	private TextArea remarkArea;
	
	@FXML
	public void initialize(){
		
	}
	public void setPatientUser(PatientUser pat) {
		this.p = pat;
	}
	
	public void setMainApp(MainApp app) {
		this.mainApp = app;
	}
//	public void fillResultCard(){
//		
//		try {
//			ResultSet rs = p.getResultCard();
//			medicineText.setText(rs.getString("medicine"));
//			diseaseText.setText(rs.getString("disease"));
//			testText.setText(rs.getString("test"));
//			remarkArea.setText(rs.getString("remark"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}

}
