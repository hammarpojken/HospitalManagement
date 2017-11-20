package GUI;

import Hospital.Prescription;
import Utils.dbhandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrescriptionPopup {
	private Prescription p;
	private Stage stage;
	
	@FXML
	private Label mName;
	@FXML
	private Label mType;
	@FXML
	private Label mVolume;
	@FXML
	private Label mWithdrawl;
	@FXML
	private Label docName;
	@FXML
	private TextArea info;
	@FXML
	private Button close;
	
	
	@FXML
	public void initialize() {
		
		
		
		
	}
	public void setPrescription(Prescription p) {
		this.p = p;
	}
	public void setinfo() {
		mName.setText(p.getMedicine().getName());
		mType.setText(p.getMedicine().getType());
		mVolume.setText(p.getMedicine().getVolume());
		mWithdrawl.setText(p.getWithdrawlAmount() + "");
		docName.setText(dbhandler.getDoctor(p.getDoctorId()));
		info.setText(p.getPrescriptionInfo());
	}
	@FXML
	public void closeEvent() {
		this.stage.close();
		
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}

}


