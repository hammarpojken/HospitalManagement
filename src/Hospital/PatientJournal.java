package Hospital;

import java.sql.Date;

public class PatientJournal {

private String firstName;
private String lastName;
private int ssn;
private int tlfnumber;
private String adress;
private Date checkInDate;
private Date checkOutDate;
private String assignedDoctor;
private ResultCard resultCard;
private Test [] tests;
private Prescription [] prescriptions;


public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public int getSsn() {
	return ssn;
}

public void setSsn(int ssn) {
	this.ssn = ssn;
}

public int getTlfnumber() {
	return tlfnumber;
}

public void setTlfnumber(int tlfnumber) {
	this.tlfnumber = tlfnumber;
}

public String getAdress() {
	return adress;
}

public void setAdress(String adress) {
	this.adress = adress;
}

public Date getCheckInDate() {
	return checkInDate;
}

public void setCheckInDate(Date checkInDate) {
	this.checkInDate = checkInDate;
}

public Date getCheckOutDate() {
	return checkOutDate;
}

public void setCheckOutDate(Date checkOutDate) {
	this.checkOutDate = checkOutDate;
}

public String getString() {
	return assignedDoctor;
}

public void setString(String assignedDoctor) {
	this.assignedDoctor = assignedDoctor;
}

public ResultCard getResultCard() {
	return resultCard;
}

public void setResultCard(ResultCard resultCard) {
	this.resultCard = resultCard;
}

public Test[] getTests() {
	return tests;
}

public void setTests(Test[] tests) {
	this.tests = tests;
}

public Prescription[] getPrescriptions() {
	return prescriptions;
}

public void setPrescriptions(Prescription[] prescriptions) {
	this.prescriptions = prescriptions;
}



}
