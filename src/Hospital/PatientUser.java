package Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class PatientUser extends Person {
	
	private long ssn;

	public PatientUser(String fname, String lname, String role, long SSN) {
		super(fname, lname, role);
		this.ssn = SSN;
	}
	public ResultSet getResultCard() {
	Connection con;
	try {
		con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * FROM projecthospita.resultcard WHERE resultcard.Patientssn =" + this.ssn );
		 if(rs.next() == true) {
			 return rs;
		 }
			
			  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;

}
	public long getSSN() {
		return ssn;
		
	}

}
