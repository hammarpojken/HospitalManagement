package Hospital;

public class PatientUser extends Person {
	
	private long ssn;

	public PatientUser(String fname, String lname, String role, long SSN) {
		super(fname, lname, role);
		this.ssn = SSN;
	}

}
