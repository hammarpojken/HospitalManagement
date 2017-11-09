package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hospital.Doctor;
import Hospital.Medicine;
import Hospital.Patient;
import Hospital.PatientUser;
import Hospital.Prescription;
import Hospital.ResultCard;
import Hospital.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class dbhandler {
	
	
	
	//--------------------------------------- LOGIN METHODS--------------------------------------------
	
	public static ResultSet getUser(String proffession, String userName, String passWord) throws SQLException {
		ResultSet rs;
		
		try {
			
			Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			
			if (proffession == "Staff") {
				 rs = st.executeQuery("select * FROM mydb.staff WHERE staff.username = '" + userName + "' AND staff.password = " + passWord + ";");
				 //con.close();
				 return rs;
				}
			
			else if (proffession == "Patient") {
				rs = st.executeQuery("select * FROM mydb.patient WHERE patient.username = '" + userName + "' AND patient.password = " + passWord + ";");
				con.close();
				return rs;
			}
			
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
			return rs = null;
			
		}
		
		return rs = null;
	}
	
	//-----------------------------------DOCTOR METHODS----------------------------------------------------------
	public static ObservableList<Patient> getPatients(){
		ObservableList<Patient> data = FXCollections.observableArrayList();
		Connection con;
		ResultSet rs;
	try {
		con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");
		Statement st = con.createStatement();
		 rs = st.executeQuery("SELECT * FROM mydb.patient;");
		 
		 while(rs.next()){
			 data.add(new Patient(
					 rs.getLong("ssn"),
					 rs.getString("fname"),
					 rs.getString("lname"),
					 rs.getLong("phone"),
					 rs.getString("username"),
					 rs.getString("password"),
					 rs.getString("adress"),
					 rs.getInt("zipcode"),
					 rs.getString("role"),
					 rs.getLong("doctorid"),
					 rs.getString("gender"),
					 rs.getInt("status_patient"),
					 rs.getDate("checkin_date"),
					 rs.getTime("checkin_date"),
					 rs.getDate("checkout_date"),
					 rs.getTime("checkout_date"),
					 rs.getInt("room"),
					 rs.getString("blood_type")));
			 
			 
		 }
		 

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
//	} finally {
//		try {
//		//	con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	return data;
	
	}
	
	public static ResultSet getResultCard(long ssn) {
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * FROM projecthospita.resultcard WHERE resultcard.patientssn = " + ssn);
			 if(rs.next() == true) {
				 
				 return rs;
			 }
			 
				  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	

	}
	
	public static ResultSet getPatientInfo(long ssn) {
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select projecthospita.patient.*, projecthospita.staff.fname AS doctorfname, projecthospita.staff.lname AS doctorlname"
					+ " from projecthospita.patient left join projecthospita.staff on patient.doctorid = staff.staffid WHERE patient.ssn = " + ssn );
			 if(rs.next() == true) {
				 
				 return rs;
			 }
			 
				  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}
	
	public static void setResultCard(String disease, String medicine, String test, String remark, long ssn) {
		System.out.println("hej");
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			
			st.executeUpdate("INSERT INTO projecthospita.resultcard (patientssn, disease, medicine, test, remark) VALUES (" + ssn + ",'" + disease + "','" + medicine + "','" + test + "','" + remark +"')");
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void updateResultCard(String disease, String medicine, String test, String remark, long ssn) {
		System.out.println("hej");
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			
			if (resultcardExist(ssn)) {
				st.executeUpdate("UPDATE projecthospita.resultcard SET patientssn = " + ssn + ", disease = '" + disease
						+ "', medicine = '" + medicine + "', test = '" + test + "', remark = '" + remark + "' WHERE patientssn = "+ ssn);
			}
			
		}
			catch (SQLException e) {
				e.printStackTrace();
			}

	}
	public static void updatePatient(String fname, String lname, String adress, long phone, long ssn) {
		System.out.println("hej");
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
				
			st.executeUpdate("UPDATE projecthospita.patient SET fname = '" + fname + "', lname = '" + lname + "', adress = '" + adress 
					+ "', phone = " + phone + ", ssn = " + ssn + " WHERE patient.ssn = " + ssn);
		}
			catch (SQLException e) {
				e.printStackTrace();
	
			}

	}
	public static boolean resultcardExist(long ssn) {
		
		Connection con;
		ResultSet rs;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/projecthospita?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
				
			rs = st.executeQuery("SELECT * FROM projecthospita.resultcard WHERE patientssn = " + ssn);
			if (rs.next()) {
				return true;
			}
		
		}
		
			catch (SQLException e) {
				
				e.printStackTrace();
				return false;
				
	
			}
		
		return false;
		
	}
	public static void assignDoctor(long ssn, long docid) {
		
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
				
			st.executeUpdate("UPDATE mydb.patient SET doctorid = " + docid + " WHERE patient.ssn = " + ssn);
		}
			catch (SQLException e) {
				e.printStackTrace();
	
			}
		
	}
	public static List<String> getDoctors() {
		
		Connection con;
		ResultSet rs;
		List<String> choices = new ArrayList<>();
		
		
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			rs = st.executeQuery("select * FROM mydb.staff WHERE role = 'doctor'");
			
			if(rs.next() == true) {
				rs.beforeFirst();
				
				while(rs.next()) {
					choices.add(rs.getString("fname") + " " + rs.getString("lname") + " " + rs.getLong("staffid"));
				}
				
			} else {
				choices = null;
			}
										
				
				  
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
		}
		return choices;
	}
	
	public static String getDoctor(long docid) {
		
		Connection con;
		ResultSet rs;
		String docname = "No assigned doctor";
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");
			Statement st = con.createStatement();
			
				
			rs = st.executeQuery("SELECT fname, lname FROM mydb.staff WHERE staff.staffid = " + docid);
			if (rs.next()) {
				return rs.getString("fname") + " " + rs.getString("lname");
			}
			
			
		
		}catch (SQLException e) {
			e.printStackTrace();	
	
			}
		return docname;
		
	}
		
	
	public static void updateJournal (String fname, String lname, String adress, long phone, long ssn, String disease, String medicine, String test, String remark) {
		
		dbhandler.updatePatient(fname, lname, adress, phone, ssn);
	
		dbhandler.updateResultCard(disease, medicine, test, remark, ssn);
		
		
	}
	
	// --------------------------------------------------------JOURNAL METHODS-----------------------------------------------------------------------------------
	
		public static String getCity(int zip) {
		
			
		Connection con;
		ResultSet rs;
		String result = "N/A";
			
			try {
				con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");
				Statement st = con.createStatement();
				rs = st.executeQuery("SELECT name FROM mydb.city WHERE city.idcity =" + zip);
				
				if(rs.next()) {
					result = rs.getString("name");
	
				}
				con.close();
				
				} catch (SQLException e) {
					
				} finally {
				
					
				}
				
				return result;
				
			} 		
		
		public static ObservableList<Medicine> getMedicine(long ssn){
			ObservableList<Medicine> presc = FXCollections.observableArrayList();
			Connection con;
			ResultSet rs;
			
			try {
				con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");
				Statement st = con.createStatement();
				 rs = st.executeQuery("SELECT * FROM mydb.medicine WHERE medicine.idmedicine IN (SELECT prescription.medicine FROM prescription WHERE prescription.patientid = " + ssn + ")" );
				 
				 while(rs.next()){
					 presc.add(new Medicine(
									 rs.getInt("idmedicine"),
									 rs.getString("name"),
									 rs.getString("type"),
									 rs.getString("volume"),
									 rs.getDouble("price")));
					 
				}
				 con.close();
		
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(); 
				}
			
				return presc;
				}
				
		public static ObservableList<Test> getTest(long ssn){
			ObservableList<Test> testlist = FXCollections.observableArrayList();
			Connection con;
			ResultSet rs;
			
			try {
				con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");
				Statement st = con.createStatement();
				 rs = st.executeQuery("SELECT * FROM mydb.tests WHERE tests.patientid = " + ssn);
				 
				 while(rs.next()){
					 testlist.add(new Test(
							 rs.getInt("idtests"),
							 rs.getLong("patientid"),
							 rs.getString("type")));
				}
				 con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(); 
				}
				return testlist;
}
		
		public static List<ResultCard> getResultCardInfo(long ssn){
			List<ResultCard> rc = new ArrayList<ResultCard>();
			Connection con;
			ResultSet rs;
				
			try {
				con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");
				Statement st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM mydb.resultcard WHERE resultcard.patientid =" + ssn);
				
				while(rs.next()) {
					rc.add(new ResultCard(
							rs.getInt("idresultcard"),
							rs.getLong("patientid"),
							rs.getString("diagnose"),
							rs.getString("remark")));
				

				}
				con.close();
				
				} catch (SQLException e) {
					
				} finally {
					
				}
				System.out.println(rc.size());
				return rc;
				
		}
		public static ObservableList<String> getRooms(){
			ObservableList<String> rc = FXCollections.observableArrayList();
			Connection con;
			ResultSet rs;
			
			try {
				con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root", "root");
				Statement st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM mydb.room");
				
				while(rs.next()) {
					String temp;
					temp = rs.getInt("idroom") + " " + "-" + " "+ rs.getString("type") + "  " + rs.getInt("available_slots") + "/" + rs.getInt("size");
					rc.add(temp);
				}
				
			}catch (SQLException k) {
				return rc = null;
				
			}
			return rc;
			
		}
		
		
}		
