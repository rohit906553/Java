package jdbc1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class Demo_jdbc1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Scanner sc=new Scanner (System.in);
	System.out.println("enter the procode:");
	String code=sc.nextLine();
	System.out.println("enter the product name:");
	String name=sc.nextLine();
	System.out.println("enter the prodprice:");
	float price=sc.nextFloat();
	System.out.println("enter the prodqty:");
	int qty=sc.nextInt();
	Connection con =DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl","system","ROOT");
	Statement stm= con.createStatement();	
	int k=stm.executeUpdate
			("insert into PRODUCT1 values('"+code+"','"+name+"','"+price+"',"+qty+")");
	if(k>0) {
		System.out.println("insert the data susccesfully:");
	}
	
   }catch(Exception e) {
	   e.printStackTrace();
   }
	}

}
