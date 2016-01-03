package SW.Controler;
import SW.*;
import SW.Model.PlaceModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class PlaceController {

    public PlaceController() 
    {
    }
    

    public Vector  myGPSController;
    private PlaceModel model=new PlaceModel();

  public void getNearestPlaces() 
  {
      
  }
  
  public int get_id(String name) throws ClassNotFoundException
  {
      if(model.getPlace(name)==null) {
          return -1;
      }
      else {
          return model.getPlace(name).id;
      }
  }

  public void ratePlace(int placeId,double rate) throws ClassNotFoundException, SQLException 
  {
      model.updatePlace(placeId, placeId);
      
  }

  public void saveCheckIn() {
  }

  public void addNewPlace(String Name,String description,int longitude,int latitude) throws ClassNotFoundException {
      
      model.savePlace(Name, description, longitude, latitude);

  }

}