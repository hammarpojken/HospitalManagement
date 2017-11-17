package Hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Doctor extends Person {
	private long staffId;
	
	public Doctor(long id, String firstName, String lastName, String role) {
		super(firstName, lastName, role);
		this.staffId = id;
	}
	public long getId() {
		return this.staffId;
	}
	@Override
	public String toString() {
		return this.getfname() + " " + this.getlname();
		
	}

	
	
	


	

	
	
		
	
			
		
		
	
		
		
		
		
		

}



