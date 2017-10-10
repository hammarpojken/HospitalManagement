package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class DoctorViewController {
	
	@FXML
	private TableView tv;
	
	@FXML
	public void initialize() {
		getPatients();
		
	}
	public void getPatients(){
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "backstab1870");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select fname, lname FROM projecthospita.patient;");
			
			ArrayList<String> fname = new <String>ArrayList();
			ArrayList lname = new ArrayList();
			while(rs.next()){
				
				fname.add(rs.getString(1));
				lname.add(rs.getString(2));
				
				
			}
			tv.getColumns().add(1, fname);
			tv.getColumns().add(2, lname);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
