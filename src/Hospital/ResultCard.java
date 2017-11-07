package Hospital;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class ResultCard {
	
	private final SimpleIntegerProperty resultcardId;
    private final SimpleLongProperty patientId;
    private final SimpleStringProperty diagnose;
    private final SimpleStringProperty remark;
    
    
	public ResultCard(int resultcard_id, long patient_id, String diagnose,String remark) {
	
		
		this.resultcardId = new SimpleIntegerProperty(resultcard_id);
		this.patientId = new SimpleLongProperty(patient_id);
		this.diagnose = new SimpleStringProperty(diagnose);
		this.remark = new SimpleStringProperty(remark);
	}


	public final SimpleIntegerProperty resultcardIdProperty() {
		return this.resultcardId;
	}
	


	public final int getResultcardId() {
		return this.resultcardIdProperty().get();
	}
	


	public final void setResultcardId(final int resultcardId) {
		this.resultcardIdProperty().set(resultcardId);
	}
	


	public final SimpleLongProperty patientIdProperty() {
		return this.patientId;
	}
	


	public final long getPatientId() {
		return this.patientIdProperty().get();
	}
	


	public final void setPatientId(final long patientId) {
		this.patientIdProperty().set(patientId);
	}
	


	public final SimpleStringProperty diagnoseProperty() {
		return this.diagnose;
	}
	


	public final String getDiagnose() {
		return this.diagnoseProperty().get();
	}
	


	public final void setDiagnose(final String diagnose) {
		this.diagnoseProperty().set(diagnose);
	}
	


	public final SimpleStringProperty remarkProperty() {
		return this.remark;
	}
	


	public final String getRemark() {
		return this.remarkProperty().get();
	}
	


	public final void setRemark(final String remark) {
		this.remarkProperty().set(remark);
	}
	
	

}
