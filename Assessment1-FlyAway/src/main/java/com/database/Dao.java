package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


	public class Dao {
		public Connection con=null;
		public Statement st=null;

		public Dao() throws ClassNotFoundException, SQLException{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","12345");
			System.out.println("connection established with database");
			st=con.createStatement();
		}
public List<String[]> getAvailableFlights(String f, String t, String d) {
			
			List<String[]> flights=new ArrayList<>();
			String query="SELECT * FROM mydb.flights where from='"+f+"' and to='"+t+"' and date='"+d+"'";
			try {
				ResultSet rs=st.executeQuery(query);
				
				if(rs.next()) {
					String[] flight=new String[3];
					flight[0]=rs.getString("name");
					flight[1]=rs.getString("time");
					flight[2]=rs.getString("price");
					flights.add(flight);
					return flights;
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		}

	public HashMap<String, String> checkUser(String email, String password) {
		
		HashMap<String,String> user=null;
		String query="select * from user where email='"+email+"' and password='"+password+"'";
		try {
			ResultSet rs=st.executeQuery(query);
			if(rs.next()) {
				user=new HashMap<>();
				user.put("name", rs.getString("name"));
				user.put("email",rs.getString("email"));
				user.put("phno",rs.getString("phno"));
				user.put("adno",rs.getString("adno"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public boolean insertUser(HashMap<String, String> user) {

		String query="INSERT INTO user (email, password, name, phno, adno) values('"+user.get("email")+"','"+user.get("password")+"','"+user.get("name")+"','"+user.get("phno")+"','"+user.get("adno")+"')";                   
		
		try {
			st.execute(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkAdmin(String email, String password) {
		
		try {
			ResultSet rs=st.executeQuery("select * from admin where email='"+email+"' and password='"+password+"'");
			if(rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changeAdminPassword(String email, String password) {

		try {
			ResultSet rs=st.executeQuery("select * from admin where email='"+email+"'");
			if(!rs.next()) {
				return false;
			}
			st.execute("update admin set password='"+password+"' where email='"+email+"'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public HashMap<String, String> checkFlights(String name, String from, String to, String date) {
		
		HashMap<String,String> flights=null;
		String query1="select * from flights where name='"+name+"', from='"+from+"', to='"+to+"', date='"+date+"'";
		try {
			ResultSet rs=st.executeQuery(query1);
			if(rs.next()) {
				flights=new HashMap<>();
				flights.put("name", rs.getString("name"));
				flights.put("from",rs.getString("from"));
				flights.put("to",rs.getString("to"));
				flights.put("date",rs.getString("date"));
			}
			return flights;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flights;
	}


	public boolean insertFlight(HashMap<String, String> flights) {
		String query1 = "INSERT INTO flights (name, from, to, date) values('"+flights.get("name")+"','"+flights.get("from")+"','"+flights.get("to")+"','"+flights.get("date")+"')";                   

		try {
			//stm.execute();
			st.execute(query1);
			return true;
		} catch (SQLException e) {
			System.out.print("error");
			e.printStackTrace();
		}
		return false;
	}

	}