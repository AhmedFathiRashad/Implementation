package SW.Controler;
import SW.*;
import SW.Model.CheckInModel;
import java.util.Vector;

public class CheckInController {

    public CheckInModel  myCheckInModel;
    //public Vector  myPlaceModel;

  public void doCheckIn(int user,int place,String comment) throws ClassNotFoundException {
      myCheckInModel.saveCheckIn(user, place, comment);
  }

  public void like() {
  }

  public void comment() {
  }

}