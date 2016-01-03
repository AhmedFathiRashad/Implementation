package SW.Model;
import SW.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserModel {

  public Integer id;

  public String uname;

  public String password;

  public String type;
  
  public String email;
  
  public boolean  active=false;
  
  private String question;
  
  private String answer;
  private String creditcard;

    public UserModel(Integer id, String uname, String password, String type, String email) {
        this.id = id;
        this.uname = uname;
        this.password = password;
        this.type = type;
        this.email = email;
    }

    public UserModel() {
      //  throw new UnsupportedOperationException("Not yet implemented");
    }

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

  

    
  public void addNewUser(String name,String email,String password,String Type,String creditCard) throws ClassNotFoundException, SQLException 
  {
	Class.forName("com.mysql.jdbc.Driver");
	
        Connection con=null;
	Statement st=null;
	System.out.println(name +" "+password+" "+type+ " "+email+" ");
        String t ="f";
        String n="n";
	String q="insert into users(Name, password, email, Type,creditCard)"
                +" VALUES ( '"+ name+"','"+password+"','"+email+"','"+Type+"','"+creditCard+"')";
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
	

  public UserModel getUser(String email,String password) throws ClassNotFoundException 
  {
        try {
            Class.forName("com.mysql.jdbc.Driver");

              Connection con=null;
              Statement st=null;
              String q="select * from users";

               
              
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/i-locate","root","");
              
                      java.sql.Statement preparedStmt = con.createStatement();
                       java.sql.ResultSet rs = preparedStmt.executeQuery(q);

                   while (rs.next())
                   {
                     int id = rs.getInt("id");
                     String firstName = rs.getString("Name");
                     String password1 = rs.getString("password");
                     String emaill = rs.getString("email");
                     String Type = rs.getString("Type");
                     System.out.println(id+firstName+password1+emaill+Type);
                     if((password == null ? password1 == null : password.equals(password1))&&(emaill == null ? email == null : emaill.equals(email)))
                     {
                         return new  UserModel(id, firstName, password, Type, email);
                     }
                    }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }

  return null;
        
  }

  public void deleteUser() 
  {
      
  }

  public void updateUser(String credit,int id) throws ClassNotFoundException, SQLException 
  {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=null;
        Statement st=null;
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/i-locate","root","");
	java.sql.Statement preparedStmt = null;
	String q2="UPDATE users SET creditCard='"+credit+"' Where id = '" +id+"' "; 
	   preparedStmt = con.prepareStatement(q2);
		  preparedStmt.executeUpdate(q2);
                  con.close();
                  
            //Class.forName("com.mysql.jdbc.Driver");
        Connection con1=null;
        Statement st1=null;
	con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/i-locate","root","");
	java.sql.Statement preparedStmt1 = null;
        String p="p";
	String q="UPDATE users SET Type='"+p+"' Where id = '" +id+"' " ; 
	   preparedStmt1 = con1.prepareStatement(q);
		  preparedStmt1.executeUpdate(q);
                  con1.close();
         
  }

  public void Notify() {
  }

}