package Hospital;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Prescription {
	
	private final SimpleIntegerProperty prescId;
    private final SimpleLongProperty patientId;
    private final SimpleLongProperty doctorId;
    private final SimpleIntegerProperty medicineId;
    private final SimpleStringProperty prescriptionInfo;
    private final SimpleIntegerProperty withdrawlAmount;
    private final SimpleObjectProperty<Medicine>  med;
    
    
    public Prescription(int prescId, Long patient_id, Long doctor_id, int medicine_id, String prescription_info, int withdrawl_amount, Medicine med) {
    	this.prescId = new SimpleIntegerProperty(prescId);
    	this.patientId = new SimpleLongProperty(patient_id);
    	this.doctorId = new SimpleLongProperty(doctor_id);
    	this.medicineId = new SimpleIntegerProperty(medicine_id);
    	this.prescriptionInfo = new SimpleStringProperty(prescription_info);
    	this.withdrawlAmount = new SimpleIntegerProperty(withdrawl_amount);
    	this.med = new SimpleObjectProperty(med);
    	
    }
    public Prescription(Long patient_id, Long doctor_id, int medicine_id, String prescription_info, int withdrawl_amount, Medicine med) {
    	this.prescId = null;
    	this.patientId = new SimpleLongProperty(patient_id);
    	this.doctorId = new SimpleLongProperty(doctor_id);
    	this.medicineId = new SimpleIntegerProperty(medicine_id);
    	this.prescriptionInfo = new SimpleStringProperty(prescription_info);
    	this.withdrawlAmount = new SimpleIntegerProperty(withdrawl_amount);
    	this.med = new SimpleObjectProperty(med);
    	
    }


	public final SimpleIntegerProperty prescIdProperty() {
		return this.prescId;
	}
	


	public final int getTestId() {
		return this.prescIdProperty().get();
		
		
	}
	


	public final void setTestId(final int prescId) {
		this.prescIdProperty().set(prescId);
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
	


	public final SimpleIntegerProperty withdrawlAmountProperty() {
		return this.withdrawlAmount;
	}
	


	public final int getWithdrawlAmount() {
		return this.withdrawlAmountProperty().get();
	}
	


	public final void setWithdrawlAmount(final int withdrawlAmount) {
		this.withdrawlAmountProperty().set(withdrawlAmount);
	}
	public SimpleObjectProperty<Medicine> getMed() {
		return med;
	}
	
	public Medicine getMedicine() {
		return med.get();
	}


}
