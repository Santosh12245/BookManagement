package BookFullstack;

import java.util.*;

public class BookStore {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String  password = "vssut@123";
		String userid = "santosh123";
		
		System.out.println("Enter USERID");
		String USERID = sc.next();
		System.out.println("Enter Password");
		String PASSWORD = sc.next();
		
		
		
		if(password.equals(PASSWORD) && userid.equals(USERID)) {
			boolean condition = true ;
			
			while(condition) {
			System.out.println("****************  BOOK MENU ********************");
			System.out.println("1. Press 1 for Show all Book");
			System.out.println("2. Press 2 for Get Details");
			System.out.println("3. Press 3 for Buy Book");
			System.out.println("4. Press 4 for Exit");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1: DatabaseConnection.ShowBook();
			break;
			case 2: DatabaseConnection.GetDetails();
			break;
			case 3: DatabaseConnection.BuyBook();
			break;
			case 4: condition = false ;
			System.out.println("*****  Thank You For Shopping  ****");
			break ;
			default: System.err.println("Invalid Option");
			}
//			
}
		}else {
			System.out.println("XXXXXXXX   USER_ID and PASSWORD Not Match     XXXXXXX");
		}
		
	}

}
