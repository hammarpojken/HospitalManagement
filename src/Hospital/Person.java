package Hospital;

public abstract class Person {
	private String fName;
	private String lName;
	private String role;
	
	public Person(String fname, String lname, String role) {
		this.fName = fname;
		this.lName = lname;
		this.role = role;
	}
	public void whoAmI() {
		System.out.println("Jag heter " + this.fName);
	}

}
