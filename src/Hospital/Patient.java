package Hospital;

import java.sql.Date;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Patient {
	 
	private final SimpleLongProperty ssn;
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
    		String adress, int zipCode, String role, Long doctorId, String gender, int status_Patient, Date checkin_Date,
    		Date checkout_Date, int room, String blood_Type) {
    	String checkin = "N/A";
    	String checkout = "N/A";
    	boolean b = false;
    	if (status_Patient == 0) {
    		
    		this.status_patient = new SimpleBooleanProperty(b);
    	} else {
    		b = true;
    		this.status_patient = new SimpleBooleanProperty(b);
    		
    	}
    	if(checkin_Date != null) {
    		checkin = checkin_Date.toString();
    	}
    	if (checkout_Date != null) {
    		checkout = checkin_Date.toString();
    		
    	}
 
    	
    	this.ssn = new SimpleLongProperty(SSN);
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
        this.checkin_date = new SimpleStringProperty(checkin);
        this.checkout_date = new SimpleStringProperty(checkout);
        this.room = new SimpleIntegerProperty(room);
        this.blood_type = new SimpleStringProperty(blood_Type);
        
    }

	public long getSsn() {
		return ssn.get();
	}





	public String getFname() {
		return fname.get();
	}





	public String getLname() {
		return lname.get();
	}





	public long getPhone() {
		return phone.get();
	}





	public String getUsername() {
		return username.get();
	}





	public String getPassword() {
		return password.get();
	}





	public String getAdress() {
		return adress.get();
	}





	public int getZipcode() {
		return zipcode.get();
	}





	public String getRole() {
		return role.get();
	}





	public long getDoctorid() {
		return doctorid.get();
	}





	public String getGender() {
		return gender.get();
	}





	public boolean getStatus_patient() {
		return status_patient.get();
	}





	public String getCheckin_date() {
		return checkin_date.get();
	}





	public String getCheckout_date() {
		return checkout_date.get();
	}





	public int getRoom() {
		return room.get();
	}





	public String getBlood_type() {
		return blood_type.get();
	}

    
    
}