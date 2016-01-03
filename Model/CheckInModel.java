package SW.Model;
import SW.GUi.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class CheckInModel {
    
    

  public CheckInModel(){}
  
  public void saveCheckIn(int user ,int place,String Comment) throws ClassNotFoundException 
  {
      Class.forName("com.mysql.jdbc.Driver");
	
        Connection con=null;
	Statement st=null;
	//System.out.println(name +" "+password+" "+type+ " "+email+" ");
        //String t ="f";
        //String n="n";
	String q="insert into checkin(UserID,PlaceID,Text)"
                +" VALUES ( '"+user+"','"+place+"','"+Comment+"')";
	try {
		//System.out.println("Ed");
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

  public void getCheckIn() {
  }

  public void updateCheckIn() {
  }

}