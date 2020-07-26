package ca.sheridancollege.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ca.sheridancollege.beans.Dog;
import ca.sheridancollege.beans.Show;

public class DAO {

	

	public static void addDog(Dog userinput) {
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = null;
	            conn = DriverManager.getConnection
	            		("jdbc:mysql://localhost/dogshow", "root", "root");
	            
			String q = "INSERT INTO dogs VALUES(" + userinput.getNumber() + ", '" + userinput.getDogname() + "', '" + userinput.getOwnername()
					+ "', '" + userinput.getBreed() + "', '" + userinput.getGroup() + "', '" + userinput.getGender() 
					+ "', '" + userinput.getDogclass() +"')";

			java.sql.Statement st = conn.createStatement();
			
			((java.sql.Statement) st).executeUpdate(q);
			
			System.out.println("Connection Success");
			conn.close();
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
	}
	
	
	
	public static void addDogs(Dog dummydogs) {
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = null;
	            conn = DriverManager.getConnection
	            		("jdbc:mysql://localhost/dogshow", "root", "root");
	            
			String q = "INSERT INTO dogs VALUES(" + dummydogs.getNumber() + ", '" + dummydogs.getDogname() + "', '" + dummydogs.getOwnername()
					+ "', '" + dummydogs.getBreed() + "', '" + dummydogs.getGroup() + "', '" + dummydogs.getGender() 
					+ "', '" + dummydogs.getDogclass() +"')";

			java.sql.Statement st = conn.createStatement();
			
			((java.sql.Statement) st).executeUpdate(q);
			
			System.out.println("Connection Success");
			conn.close();
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
	}
	
	
	
	public static ArrayList<Dog> getDog() {
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = null;
	            conn = DriverManager.getConnection
	            		("jdbc:mysql://localhost/dogshow", "root", "root");
	            
			String q = "SELECT * FROM dogs";
			
			java.sql.Statement st = conn.createStatement();
			
			//st.executeUpdate(q);
			
			ResultSet rs = ((java.sql.Statement) st).executeQuery(q);
			ResultSetMetaData rsmd = rs.getMetaData();			
			
			while(rs.next()) {
				Dog c = new Dog();
				c.setNumber(rs.getString(1));
				c.setDogname(rs.getString(2));
				c.setOwnername(rs.getString(3));
				c.setBreed(rs.getString(4));
				c.setGroup(rs.getString(5));
				c.setGender(rs.getString(6));
				c.setDogclass(rs.getString(7));
				
				dogs.add(c);
			}
	
			System.out.println("Connection Success");
			conn.close();
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
		
		return dogs;
	}
	
	
	
	
	
			
			public static ArrayList<Dog> getSearchResults(HttpServletRequest request){
			ArrayList<Dog> dog = new ArrayList<Dog>();
			
			try {	
				String number = request.getParameter("number");
				String dogname = request.getParameter("dogname");
				String ownername = request.getParameter("ownername");
				String breed = request.getParameter("breed");
				String group = request.getParameter("group");	
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = null;
					
				conn = DriverManager.getConnection("jdbc:mysql://localhost/dogshow", "root", "root");
				
				String q = "SELECT * FROM dogs"; 
						
			
				StringBuilder stringBuilder = new StringBuilder();
				
				stringBuilder.append("SELECT * FROM dogs WHERE ");
				
				if(!number.equals("")){
					if(!stringBuilder.toString().contains("AND ") && (!stringBuilder.toString().contains("Number") && !stringBuilder.toString().contains("dogname") && 
							!stringBuilder.toString().contains("ownername") && !stringBuilder.toString().contains("Breed") && !stringBuilder.toString().contains("type"))) {
						stringBuilder.append("Number= '" + number + "'");
					} else {
						stringBuilder.append(" AND Number= '" + number + "'");
					}
				} 
				
				if(!dogname.equals("")){
					if(!stringBuilder.toString().contains("AND ") && (!stringBuilder.toString().contains("Number") && !stringBuilder.toString().contains("dogname") && 
							!stringBuilder.toString().contains("ownername") && !stringBuilder.toString().contains("Breed") && !stringBuilder.toString().contains("type"))) {
						stringBuilder.append("dogname= '" + dogname + "'");
					} else {
						stringBuilder.append(" AND dogname= '" + dogname + "'");
					}
				} 
				
				if(!ownername.equals("")){
					if(!stringBuilder.toString().contains("AND ") && (!stringBuilder.toString().contains("Number") && !stringBuilder.toString().contains("dogname") && 
							!stringBuilder.toString().contains("ownername") && !stringBuilder.toString().contains("Breed") && !stringBuilder.toString().contains("type"))) {
						stringBuilder.append("ownername= '" + ownername + "'");
					} else {
						stringBuilder.append(" AND ownername= '" + ownername + "'");
					}
				}  
				
				if(!breed.equals("")){
					if(!stringBuilder.toString().contains("AND ") && (!stringBuilder.toString().contains("Number") && !stringBuilder.toString().contains("dogname") && 
							!stringBuilder.toString().contains("ownername") && !stringBuilder.toString().contains("Breed") && !stringBuilder.toString().contains("type"))) {
						stringBuilder.append("Breed= '" + breed + "'");
					} else {
						stringBuilder.append(" AND Breed= '" + breed + "'");
					}
				}
				
				if(!group.equals("")){
					if(!stringBuilder.toString().contains("AND ") && (!stringBuilder.toString().contains("Number") && !stringBuilder.toString().contains("dogname") && 
							!stringBuilder.toString().contains("ownername") && !stringBuilder.toString().contains("Breed") && !stringBuilder.toString().contains("type"))) {
						stringBuilder.append("type= '" + group  + "'");
					} else {
						stringBuilder.append(" AND type= '" + group  + "'");
					}
				} 
				
				if(number.equals("") && dogname.equals("") && ownername.equals("") && breed.equals("") && group.equals("")) {
					stringBuilder.delete(0, stringBuilder.length());
					stringBuilder.append("SELECT * FROM dogs");
				}
				
				
				q = stringBuilder.toString();
				
				System.out.println(q);
				
				Statement st = (Statement) conn.createStatement();
					
				ResultSet rs = ((java.sql.Statement) st).executeQuery(q);
				ResultSetMetaData rsmd = rs.getMetaData();		
				
				while(rs.next()) {
					Dog c = new Dog();
					c.setNumber(rs.getString(1));
					c.setDogname(rs.getString(2));
					c.setOwnername(rs.getString(3));
					c.setBreed(rs.getString(4));
					c.setGroup(rs.getString(5));
					c.setGender(rs.getString(6));
					c.setDogclass(rs.getString(7));
					
					dog.add(c);
				}
				
			System.out.println("Connection Success");
			conn.close();
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
		return dog;
		}
			
		
		
			
				public static ArrayList<Show[]> getShowList(HttpServletRequest request, HttpServletResponse response) {
					ArrayList<Show[]> res = new ArrayList<Show[]>();
					
					ArrayList<Show> one = new ArrayList<Show>();
					ArrayList<Show> two = new ArrayList<Show>();
					ArrayList<Show> three = new ArrayList<Show>();
					ArrayList<Show> four = new ArrayList<Show>();
					ArrayList<Show> five = new ArrayList<Show>();
					ArrayList<Show> six = new ArrayList<Show>();
					ArrayList<Show> seven = new ArrayList<Show>();
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = null;
							
						conn = DriverManager.getConnection("jdbc:mysql://localhost/dogshow", "root", "root");
						
						for(int i = 0; i <= 7; i++) {
								String group = ""; 
								
							    if(i == 1) {
							    	group = "Group 1: Sporting Dogs";
							    } else if(i == 2) {
							    	group = "Group 2: Hounds";
							    } else if(i == 3) {
							    	group = "Group 3: Working Dogs";
							    } else if(i == 4) {
							    	group = "Group 4: Terriers";
							    } else if(i == 5) {
							    	group = "Group 5: Toys";
							    } else if(i == 6) {
							    	group = "Group 6: Non-sporting Dogs";
							    } else if(i == 7) {
							    	group = "Group 7: Herding";
							    }
							    
								String q = "SELECT Count(*) as number, breed as Breed, Count(CASE WHEN gender = 'Male' AND dogclass = 'dogclass Dog' then number ELSE NULL END) as Male_dogclass_Dog,Count(CASE WHEN gender = 'Female' AND dogclass = 'dogclass Dog' then number ELSE NULL END) as Female_dogclass_Dog, Count(CASE WHEN gender = 'Male' AND dogclass = 'Specialty Dog' then number ELSE NULL END) as Male_Specialty_Dog, Count(CASE WHEN gender = 'Female' AND dogclass = 'Specialty Dog' then number ELSE NULL END) as Female_Specialty_Dog FROM dogs WHERE type ='" + group + "' GROUP BY breed;";
								
								
								
								Statement st = conn.createStatement();
									
								ResultSet rs = st.executeQuery(q);
								ResultSetMetaData rsmd = rs.getMetaData();		
								
								if(i == 1) {
									
									while(rs.next()) {
										Show c = new Show();
										c.setGroupName(group);
										c.setBreedCount(rs.getString(1));
										c.setBreed(rs.getString(2));
										c.setMaleCount(rs.getString(3));
										c.setFemaleCount(rs.getString(4));
										c.setMaleSpecialCount(rs.getString(5));
										c.setFemaleSpecialCount(rs.getString(6));
										
										one.add(c);
									}
									
							    } else if(i == 2) {
									
									while(rs.next()) {
										Show c = new Show();
										c.setGroupName(group);
										c.setBreedCount(rs.getString(1));
										c.setBreed(rs.getString(2));
										c.setMaleCount(rs.getString(3));
										c.setFemaleCount(rs.getString(4));
										c.setMaleSpecialCount(rs.getString(5));
										c.setFemaleSpecialCount(rs.getString(6));
										
										two.add(c);
									}
							    } else if(i == 3) {
									
									while(rs.next()) {
										Show c = new Show();
										c.setGroupName(group);
										c.setBreedCount(rs.getString(1));
										c.setBreed(rs.getString(2));
										c.setMaleCount(rs.getString(3));
										c.setFemaleCount(rs.getString(4));
										c.setMaleSpecialCount(rs.getString(5));
										c.setFemaleSpecialCount(rs.getString(6));
										
										three.add(c);
									}
							    } else if(i == 4) {
								
									while(rs.next()) {
										Show c = new Show();
										c.setGroupName(group);
										c.setBreedCount(rs.getString(1));
										c.setBreed(rs.getString(2));
										c.setMaleCount(rs.getString(3));
										c.setFemaleCount(rs.getString(4));
										c.setMaleSpecialCount(rs.getString(5));
										c.setFemaleSpecialCount(rs.getString(6));
										
										four.add(c);
								}
							    } else if(i == 5) {
									
								while(rs.next()) {
									Show c = new Show();
									c.setGroupName(group);
									c.setBreedCount(rs.getString(1));
									c.setBreed(rs.getString(2));
									c.setMaleCount(rs.getString(3));
									c.setFemaleCount(rs.getString(4));
									c.setMaleSpecialCount(rs.getString(5));
									c.setFemaleSpecialCount(rs.getString(6));
									
									five.add(c);
								}
					    } else if(i == 6) {
								
								while(rs.next()) {
									Show c = new Show();
									c.setGroupName(group);
									c.setBreedCount(rs.getString(1));
									c.setBreed(rs.getString(2));
									c.setMaleCount(rs.getString(3));
										c.setFemaleCount(rs.getString(4));
										c.setMaleSpecialCount(rs.getString(5));
										c.setFemaleSpecialCount(rs.getString(6));
										
										six.add(c);
									}
							    } else if(i == 7) {
									
									while(rs.next()) {
										Show c = new Show();
										c.setGroupName(group);
										c.setBreedCount(rs.getString(1));
										c.setBreed(rs.getString(2));
										c.setMaleCount(rs.getString(3));
										c.setFemaleCount(rs.getString(4));
									c.setMaleSpecialCount(rs.getString(5));
										c.setFemaleSpecialCount(rs.getString(6));
										
										seven.add(c);
									}
							    }			
								

								
						}
						System.out.println("Connection Success");
						conn.close();
						
					} catch (Exception e) {
						System.out.println("Connection Failed");
						System.out.println(e);
				
				}
					return res;
		}
}
				
