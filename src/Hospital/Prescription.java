package Hospital;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Prescription {
	
	private final SimpleIntegerProperty testId;
    private final SimpleLongProperty patientId;
    private final SimpleLongProperty doctorId;
    private final SimpleIntegerProperty medicineId;
    private final SimpleStringProperty prescriptionInfo;
    private final SimpleStringProperty withdrawlAmount;
    private final Medicine med;
    
    
    public Prescription(int test_id, Long patient_id, Long doctor_id, int medicine_id, String prescription_info, String withdrawl_amount, Medicine med) {
    	this.testId = new SimpleIntegerProperty(test_id);
    	this.patientId = new SimpleLongProperty(patient_id);
    	this.doctorId = new SimpleLongProperty(doctor_id);
    	this.medicineId = new SimpleIntegerProperty(medicine_id);
    	this.prescriptionInfo = new SimpleStringProperty(prescription_info);
    	this.withdrawlAmount = new SimpleStringProperty(withdrawl_amount);
    	this.med = med;
    	
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
	


	public final SimpleLongProperty doctorIdProperty() {
		return this.doctorId;
	}
	


	public final long getDoctorId() {
		return this.doctorIdProperty().get();
	}
	


	public final void setDoctorId(final long doctorId) {
		this.doctorIdProperty().set(doctorId);
	}
	


	public final SimpleIntegerProperty medicineIdProperty() {
		return this.medicineId;
	}
	


	public final int getMedicineId() {
		return this.medicineIdProperty().get();
	}
	


	public final void setMedicineId(final int medicineId) {
		this.medicineIdProperty().set(medicineId);
	}
	


	public final SimpleStringProperty prescriptionInfoProperty() {
		return this.prescriptionInfo;
	}
	


	public final String getPrescriptionInfo() {
		return this.prescriptionInfoProperty().get();
	}
	


	public final void setPrescriptionInfo(final String prescriptionInfo) {
		this.prescriptionInfoProperty().set(prescriptionInfo);
	}
	


	public final SimpleStringProperty withdrawlAmountProperty() {
		return this.withdrawlAmount;
	}
	


	public final String getWithdrawlAmount() {
		return this.withdrawlAmountProperty().get();
	}
	


	public final void setWithdrawlAmount(final String withdrawlAmount) {
		this.withdrawlAmountProperty().set(withdrawlAmount);
	}
	


}
