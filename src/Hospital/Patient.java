package Hospital;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Patient {
	 
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
  //  private final SimpleLongProperty SSN;
    private final SimpleStringProperty adress;
    private final SimpleIntegerProperty phone;
    private final SimpleStringProperty disease;
    private final SimpleStringProperty medicine;
    private final SimpleStringProperty test;

    public Patient(String fName, String lName, String adress, int phone, String disease, String medicine, String test) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
   //     this.SSN = new SimpleLongProperty(SSN);
        this.adress = new SimpleStringProperty(adress);
        this.phone = new SimpleIntegerProperty(phone);
        this.disease = new SimpleStringProperty(disease);
        this.medicine = new SimpleStringProperty(medicine);
        this.test = new SimpleStringProperty(test);
        
        // Ska patient innehålla disease,test,medicine??
        
        
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
    
    public String getDisease() {
    	return disease.get();
    }
    
    public String getMedicine() {
    	return medicine.get();
    }
    
    public String getTest() {
    	return test.get();
    }
    
}