package jdbc1;
import java.sql.*;
import java.util.*;
public class DemoCon {

	public static void main(String[] args) {
		try {
     	   Scanner sc = new Scanner (System.in);
     	   System.out.println("Enter the prodCode: ");
     	   int pCode = sc.nextInt();
     	   
     	   System.out.println("Enter the prodPrice: ");
     	   int pprice = sc.nextInt();
     	   
     	   System.out.println("Enter the prodName: ");
     	   String pName = sc.next();
     	   
     	   System.out.println("Enter the prodquality: ");
     	   String  pquality = sc.next();
     	   
     	      Connection conn = DriverManager.getConnection
     	    		  ("jdbc:oracle:thin:@localhost:1521:orcl","system","ROOT");
     	      Statement stm = conn.createStatement();
     	      int k = stm.executeUpdate
     	    		  ("insert into product values("+pCode+","+pprice+",'"+pName+"','"+pquality+"')");
     	    		  
     	     if(k>0) {
     	    	 System.out.println("Insert data successful");
     	     }
     	    		  
     	    }catch (Exception e) {
     	    	e.printStackTrace();;
     	    }

	}

}
