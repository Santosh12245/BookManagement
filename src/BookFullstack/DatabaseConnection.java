package BookFullstack;

import java.sql.Connection;
import java.sql.*; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.* ;

public class DatabaseConnection {

    
     public static void ShowBook() {
    	 try{  
    		 Class.forName("com.mysql.cj.jdbc.Driver");  
    		 Connection con=DriverManager.getConnection(  
    		 "jdbc:mysql://localhost:3306/iserveu","root","0000");  
    		   
    		 Statement stmt=con.createStatement();  
    		 ResultSet rs=stmt.executeQuery("select BookName from Book");  
    		 while(rs.next())  
    		 System.out.println(rs.getString(1));  
    		 }catch(Exception e){ System.out.println(e);} 
     }
    
     public static void GetDetails() {
    	 try{  
    		 Class.forName("com.mysql.cj.jdbc.Driver");  
    		 Connection con=DriverManager.getConnection(  
    		 "jdbc:mysql://localhost:3306/iserveu","root","0000");  
    		   
    		 Statement stmt=con.createStatement();  
    		 ResultSet rs=stmt.executeQuery("select * from Book");  
    		 System.out.println("BooKID       BookName         Quantity     MRP   ");
    		 System.out.println("-------      --------        --------     ----   ");
    		 while(rs.next())  
    		 System.out.println(rs.getString(1)+ "     "+ rs.getString(2)+"               "+ rs.getInt(3) + "  "+rs.getInt(4));  
    		 }catch(Exception e){ System.out.println(e);} 
    	 
     }
       
     public static void BuyBook() {
    	 Scanner sc = new Scanner(System.in);
    	 System.out.println("Enter Book Name");
    	 String Bookname = sc.nextLine();
    	 System.out.println("Enter Quantity");
    	 int Quantity = sc.nextInt();

    	 String updateQuery = "UPDATE Book SET Quantity = Quantity - ? WHERE LOWER(BookName) = LOWER(?)";

    	 try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iserveu", "root", "0000");
    	      PreparedStatement pstmtUpdate = con.prepareStatement(updateQuery)) {

    	     pstmtUpdate.setInt(1,  Quantity); // Set the first parameter for Quantity
    	     pstmtUpdate.setString(2, Bookname); // Set the second parameter for Bookname

    	     int rowsUpdated = pstmtUpdate.executeUpdate();

    	     if (rowsUpdated > 0) {
    	         System.out.println("Quantity updated successfully!");
    	     } else {
    	         System.out.println("No book found with the given name.");
    	     }
    	     
//   
//
    	     String mrpQuery = "SELECT MRP FROM Book WHERE BookName = ?";
    	     try (PreparedStatement pstmtMRP = con.prepareStatement(mrpQuery)) {
    	         pstmtMRP.setString(1, Bookname);
    	         ResultSet rs = pstmtMRP.executeQuery();

    	         if (rs.next()) {
    	             double mrp = rs.getDouble("MRP");
    	             double totalPrice = Quantity * mrp;

    	             System.out.println("------- Invoice -------");
    	             System.out.println("Book Name: " + Bookname);
    	             System.out.println("Quantity Bought: " + Quantity);
    	             System.out.println("MRP per Book: ₹" + mrp);
    	             System.out.println("Total Price: ₹" + totalPrice);
    	             System.out.println("-----------------------");
    	         } else {
    	             System.out.println("Book not found in the database.");
    	         }
    	     }
    	 } catch (Exception e) {
    	     System.out.println(e);
    	 }

     }
    

	public static void main(String args[]) {

		 
	}

}
