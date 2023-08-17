package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Democon1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con= DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","system","ROOT");
			Statement stm=con.createStatement();
			ResultSet rs= stm.executeQuery("select * from PRODUCT1");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"
				+rs.getString(2)+"\t"	
				+rs.getString(3)+"\t"
				+rs.getString(4)+"\t"
				);
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}