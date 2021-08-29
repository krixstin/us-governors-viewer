package jdbc.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.dto.UsGov;

public class UsGovDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static String dburl = "jdbc:mysql://localhost:3306/us_governors";
	private static String user = "connectuser";
	private static String password = "connect123!@#";
	
	public List<UsGov> getUsGovs(){
		List list = new ArrayList();
		int govCount = 0;
		try { 
			//Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql= "SELECT * from senate order by state_code";
		try {
			Connection conn = DriverManager.getConnection(dburl, user, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					String name = rs.getString("name");
					String first = rs.getString("first_name");
					String last = rs.getString("last_name");
					String state = rs.getString("state_name_slug");
					String phone = rs.getString("phone");
					
					UsGov gov = new UsGov(name, first, last, state, phone);
					list.add(gov);
					govCount +=1;
				}
				System.out.println("total governers: "+govCount+'\n');
				for (int i=0; i< list.size(); i++) {
					System.out.println(list.get(i));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//get governor's info by STATE_CODE
	public String getInfo(String state){
		List list = new ArrayList();
		try { 
			//Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql= "SELECT name, phone, party, gender, ethnicity, biography, contact_page, photo_url, state_name from senate where state_code = ?";
		try {
			Connection conn = DriverManager.getConnection(dburl, user, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, state);
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String party = rs.getString("party");
					String gender = rs.getString("gender");
					String ethnicity = rs.getString("ethnicity");
					String biography = rs.getString("biography");
					String contact_page = rs.getString("contact_page");
					String photo_url = rs.getString("photo_url");
					String state_name = rs.getString("state_name");
					list.add(name);
					list.add(phone);
					list.add(party);
					list.add(gender);
					list.add(ethnicity);					
					list.add(biography);					
					list.add(contact_page);
					list.add(photo_url);
					list.add(state_name);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "\n<"+list.get(8) +" Governor>"+
				"\nName: " + list.get(0) + 
				"\nPhone: "+ list.get(1) +
				"\nParty: "+ list.get(2)+
				"\nGender: "+ list.get(3)+
				"\nEthnicity: "+ list.get(4)+
				"\nBio: "+ list.get(5) +
				"\nContact: "+ list.get(6);
//				"\nPhoto: "+ list.get(7);
	}

	public void getStates() {
		List list = new ArrayList();
		try { 
			//Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql= "SELECT * from senate order by state_name";
		try {
			Connection conn = DriverManager.getConnection(dburl, user, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					String state_name = rs.getString("state_name");
					String code = rs.getString("state_code");
					List pair = new ArrayList();
					pair.add(state_name);
					pair.add(code);
					list.add(pair);
				}
				for (int i=0; i< list.size(); i++) {
					System.out.println(list.get(i));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}