package Hospital;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Test {
	
	private final SimpleIntegerProperty testId;
    private final SimpleLongProperty patientId;
    private final SimpleStringProperty type;
    
    
    public Test(int test_id, long patient_id, String type){
    	
    	this.testId = new SimpleIntegerProperty(test_id);
    	this.patientId = new SimpleLongProperty(patient_id);
    	this.type = new SimpleStringProperty(type);
    	
    }


	public final SimpleIntegerProperty testIdProperty() {
		return this.testId;
	}
	


	public final int getTestId() {
		return this.testIdProperty().get();
	}
	


	public final void setTestId(final int testId) {
		this.testIdProperty().set(testId);
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
	


	public final SimpleStringProperty typeProperty() {
		return this.type;
	}
	


	public final String getType() {
		return this.typeProperty().get();
	}
	


	public final void setType(final String type) {
		this.typeProperty().set(type);
	}
	
}
