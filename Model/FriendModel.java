/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SW.Model;

import SW.GUi.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ahmed
 */
public class FriendModel 
{
    int userid;
    public FriendModel(int num)
    {
        userid=num;
    }
    
    public void addFriend(int FriendId,int userid) throws ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
	
        Connection con=null;
	Statement st=null;
	//System.out.println(FriendId +" "+Main.U.id);
        int num=3;
	String q="insert into friends(Human,Human1)"
                +" VALUES ( '"+num+"','"+num+"')";
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
}
