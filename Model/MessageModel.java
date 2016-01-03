package SW.Model;
import SW.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;

public class MessageModel {


  public UserModel sender;

  public ConversationModel conversation;

  public String content;

  public Date time;
    /**
     *
     * @param sender
     * @param receiver
     * @param message
     */ 
  public void addNewMessage(int sender,int receiver,String message) throws ClassNotFoundException 
  {
           Class.forName("com.mysql.jdbc.Driver");
	
        Connection con=null;
	Statement st=null;
	String q="insert into message(SenderID,ReceiverID,Message)"
                +" VALUES ( '"+sender+"','"+receiver+"','"+message+"')";
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

  public void updateMessage() {
  }

}