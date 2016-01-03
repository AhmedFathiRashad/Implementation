package SW.Model;
import SW.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlaceModel {

  public Integer id;

  public String name;

  public Double rate;

  public Integer numberOfCheckIns;

  public String description;
  
  int lon;
  int lat;

    //public Vector  myCheckInController;

    public PlaceModel(Integer id, String name, Double rate, Integer numberOfCheckIns, String description,int lon,int lat) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.numberOfCheckIns = numberOfCheckIns;
        this.description = description;
        this.lon=lon;
        this.lat=lat;
    }
    public PlaceModel(){}
    

  public void savePlace(String Name,String description,int longitude,int latitude) throws ClassNotFoundException 
  {
      Class.forName("com.mysql.jdbc.Driver");
	
        Connection con=null;
	Statement st=null;
	String q="insert into place(Name,description,longitude,latitude)"
                +" VALUES ( '"+Name+"','"+description+"','"+longitude+"','"+latitude+"')";
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

  public PlaceModel getPlace(String placename) throws ClassNotFoundException {
      try {
            Class.forName("com.mysql.jdbc.Driver");
              Connection con=null;
              Statement st=null;
              String q="select * from place";
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/i-locate","root","");
              
                      java.sql.Statement preparedStmt = con.createStatement();
                       java.sql.ResultSet rs = preparedStmt.executeQuery(q);

                   while (rs.next())
                   {
                     int id = rs.getInt("ID");
                     String Name = rs.getString("Name");
                     double rate = rs.getDouble("rate");
                     int Num = rs.getInt("numofcheckin");
                     String desc = rs.getString("description");
                     int lon=rs.getInt("longitude");
                     int lat=rs.getInt("latitude");
                     //System.out.println(id+firstName+password1+emaill+Type);
                     if(placename == null ? Name == null : placename.equals(Name))
                     {
                         return new  PlaceModel(id,Name,rate,Num,desc,lon,lat);
                     }
                    }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }

  return null;
  }

  public void deletePlace() {
  }

  public void updatePlace(int placeId,double rate) throws ClassNotFoundException, SQLException {
      
      Class.forName("com.mysql.jdbc.Driver");
        Connection con=null;
        Statement st=null;
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/i-locate","root","");
	java.sql.Statement preparedStmt = null;
	String q2="UPDATE place SET rate='"+rate+"' Where ID = '" +placeId+"' "; 
	   preparedStmt = con.prepareStatement(q2);
		  preparedStmt.executeUpdate(q2);
                  con.close();
      
  }

}