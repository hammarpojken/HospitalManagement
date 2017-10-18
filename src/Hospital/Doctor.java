package Hospital;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doctor extends Person {
	
	public Doctor(String firstName, String lastName, String role) {
		super(firstName, lastName, role);
	}
	
	public void showResultCard() {
		
		
	}
	
//	public void getjournal() {
//		
//			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "backstab1870");
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery("select fname, lname, adress, phone FROM projecthospita.patient WHERE fname = '" + p.getFirstName() + "';");
//	}
	

}
