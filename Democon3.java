package jdbc1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Democon3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc;){
			try {
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","ROOT");
				PreparedStatement ps1 = con.prepareStatement("insert into Product49 values(?,?,?,?)");
				PreparedStatement ps2 =con.prepareStatement("select * from Product49");
				PreparedStatement ps3 =con.prepareStatement("select * from Product49 where code=?");
				PreparedStatement ps4 =con.prepareStatement("update Product49 set price =?, qty=qty+7 where code= ?");
				PreparedStatement ps5 =con.prepareStatement("delete from Product49 where code =?");
				while (true) {
					System.out.println("===Choice===");
					System.out.println("1. AddProduct\n"+"2.ViewAllProduct\n"+"3.ViewProductByCode\n"+"4.UpadteProductByCode\n"+"5.DeleteProductByCode\n"+"6.exit");
					System.out.println("Enter a choice");
					switch (Integer.parseInt(sc.nextLine())) {
					case 1:
						System.out.println("Enter the code:");
						String code = sc.nextLine();
						System.out.println("Enter the name:");
						String name = sc.nextLine();
						System.out.println("Enter the price:");
						float price = Float.parseFloat(sc.nextLine());
						System.out.println("Enter the qty:");
						int qty = Integer.parseInt(sc.nextLine());
						
						ps1.setString(1, code);
						ps1.setString(2, name);
						ps1.setFloat(3, price);
						ps1.setInt(4, qty);
						
						int k = ps1.executeUpdate();
						if (k>0) {
							System.out.println("Product insert Successfully---");
						}
						break;
					case 2:
						ResultSet rs = ps2.executeQuery();
						while (rs.next()) {
							System.out.println(rs.getString(1)+"\t"+ rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t");
						}
						break;
					case 3:
						System.out.println("Enter a Prodcode:");
						String cd = sc.nextLine();
						ps3.setString(1, cd);
						ResultSet rsl = ps3.executeQuery();
						if (rsl.next()) {
							System.out.println(rsl.getString(1)+"\t"+rsl.getString(2)+"\t"+rsl.getString(3)+"\t"+rsl.getString(4));
						}
						else {
							System.out.println("Invalid prodcode");
						}
						break;
					case 4:
						System.out.println("Enter a prodcode:");
						String cd2 = sc.nextLine();
						ps3.setString(1, cd2);
						ResultSet rs3 = ps3.executeQuery();
						
						if (rs3.next()) {
							System.out.println("old price:" + rs3.getFloat(3));
							System.out.println("Enter a new price:");
							float nprice = Float.parseFloat(sc.nextLine());
							System.out.println("available qty:" + rs3.getInt(4));
							System.out.println("Enter a qty:");
							int nqty = Integer.parseInt(sc.nextLine());
							
							ps4.setFloat(1, nprice);
							ps4.setInt(2, nqty);
							ps4.setString(2, cd2);
							
							int z = ps4.executeUpdate();
							if (z>0) {
								System.out.println("Product Details Update . . .");
							}
							else {
								System.out.println("Invalid Prodcode . . . ");
							}
						}
						break;
					case 5:
						System.out.println("Enter the Prodcode:");
						String cd3 = sc.nextLine();
						ps3.setString(1, cd3);
						ResultSet rs4 = ps3.executeQuery();
						if (rs4.next()){
							ps5.setString(1, cd3);
							int y = ps5.executeUpdate();
							if (y>0) {
								System.out.println("Product details deleted Successfully . . .");
								
							}
							else {
								System.out.println("Invalid Prodcode");
							}
						}
							break;
					case 6:
						System.out.println("Operation on the Product Table Stopped ");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid choice . . .");
								
						}
								
							
						}
						
					}catch(Exception e) {
						e.printStackTrace();
					}

	}

	}}