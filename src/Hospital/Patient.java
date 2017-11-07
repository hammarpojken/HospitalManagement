package Hospital;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Patient {
	 
	private final long ssn;
    private final SimpleStringProperty fname;
    private final SimpleStringProperty lname;
    private final SimpleLongProperty phone;
    private final SimpleStringProperty username;
    private final SimpleStringProperty password;
    private final SimpleStringProperty adress;
    private final SimpleIntegerProperty zipcode;
    private final SimpleStringProperty role;
    private final SimpleLongProperty doctorid;
    private final SimpleStringProperty gender;
    private final SimpleBooleanProperty status_patient;
    private final SimpleStringProperty checkin_date;
    private final SimpleStringProperty checkout_date;
    private final SimpleIntegerProperty room;
    private final SimpleStringProperty blood_type;
    
   
   
   

    public Patient(long SSN, String fName, String lName, Long phone, String userName, String passWord, 
    		String adress, int zipCode, String role, Long doctorId, String gender, int status_Patient, String checkin_Date,
    		String checkout_Date, int room, String blood_Type) {
    	
    	boolean b = false;
    	if (status_Patient == 0) {
    		
    		this.status_patient = new SimpleBooleanProperty(b);
    	} else {
    		b = true;
    		this.status_patient = new SimpleBooleanProperty(b);
    		
    	}
    	
    	
    	this.ssn = SSN;
        this.fname = new SimpleStringProperty(fName);
        this.lname = new SimpleStringProperty(lName);
        this.phone = new SimpleLongProperty(phone);
        this.username = new SimpleStringProperty(userName);
        this.password = new SimpleStringProperty(passWord);
        this.adress = new SimpleStringProperty(adress);
        this.zipcode = new SimpleIntegerProperty(zipCode);
        this.role = new SimpleStringProperty(role);
        this.doctorid = new SimpleLongProperty(doctorId);
        this.gender = new SimpleStringProperty(gender);
        this.checkin_date = new SimpleStringProperty(checkin_Date);
        this.checkout_date = new SimpleStringProperty(checkout_Date);
        this.room = new SimpleIntegerProperty(room);
        this.blood_type = new SimpleStringProperty(blood_Type);
        
    }

	public long getSsn() {
		return ssn;
	}





	public SimpleStringProperty getFname() {
		return fname;
	}





	public SimpleStringProperty getLname() {
		return lname;
	}





	public SimpleLongProperty getPhone() {
		return phone;
	}





	public SimpleStringProperty getUsername() {
		return username;
	}





	public SimpleStringProperty getPassword() {
		return password;
	}





	public SimpleStringProperty getAdress() {
		return adress;
	}





	public SimpleIntegerProperty getZipcode() {
		return zipcode;
	}





	public SimpleStringProperty getRole() {
		return role;
	}





	public SimpleLongProperty getDoctorid() {
		return doctorid;
	}





	public SimpleStringProperty getGender() {
		return gender;
	}





	public SimpleBooleanProperty getStatus_patient() {
		return status_patient;
	}





	public SimpleStringProperty getCheckin_date() {
		return checkin_date;
	}





	public SimpleStringProperty getCheckout_date() {
		return checkout_date;
	}





	public SimpleIntegerProperty getRoom() {
		return room;
	}





	public SimpleStringProperty getBlood_type() {
		return blood_type;
	}

    
    
}