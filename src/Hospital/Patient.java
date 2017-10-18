package Hospital;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Patient {
	 
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleLongProperty SSN;
    private final SimpleStringProperty adress;
    private final SimpleIntegerProperty phone;
   

    public Patient(String fName, String lName, String adress, int phone, long ssn) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.SSN = new SimpleLongProperty(ssn);
        this.adress = new SimpleStringProperty(adress);
        this.phone = new SimpleIntegerProperty(phone);
       
        
        
    }

    public long getSSN() {
		return SSN.get();
	}

	public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String fName) {
        lastName.set(fName);
    }
    
   // public long getSSN() {
    //	return SSN.get();
   // }
    
    public String getAdress() {
    	return adress.get();
    }
    
    public int getPhone() {
    	return phone.get();
    }
    
   
    
}