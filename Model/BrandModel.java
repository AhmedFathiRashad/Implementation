package SW.Model;
import SW.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class BrandModel {

  
  public void saveBrand(String Name,int OwnerId) throws ClassNotFoundException 
  {
      Class.forName("com.mysql.jdbc.Driver");
	
        Connection con=null;
	Statement st=null;
	String q="insert into brands(ownerID,Name)"
                +" VALUES ( '"+ OwnerId+"','"+Name+"')";
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/i-locate","root","");
		
		PreparedStatement preparedStmt = con.prepareStatement(q);
		preparedStmt.execute();
	      con.close();
              
	} catch (SQLException e) {
		System.out.println("Connection Established Successfull and the DATABASE NAME IS:");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  public void deleteBrand() {
  }

  public void updateBrand() {
  }

  public void getBrand() {
  }

}