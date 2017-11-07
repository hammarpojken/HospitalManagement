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
	

}
