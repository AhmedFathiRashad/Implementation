package SW.Controler;
import SW.*;
import SW.GUi.Homepage1;
import SW.GUi.Homepage2;
import SW.GUi.LogeInErorr;
import SW.Model.UserModel;
import SW.Model.FriendModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import SW.GUi.Main;
public class UserController {

    /**
     *
     */
    public static  UserModel l=new UserModel();
    public UserModel  myUserModel=new UserModel() ;
    public UserModel user=new UserModel();
    public FriendModel friend;
        //public Vector<UserController>  myUserController=new Vector();
    //public Vector  myUserController;

  public void login(String email,String password) throws ClassNotFoundException 
  {
      if( myUserModel.getUser(email,password)==null)
      {
          LogeInErorr.main(null);
      }
      else 
      {
           friend=new FriendModel(myUserModel.getUser(email, password).id);
           Main.U=myUserModel.getUser(email,password);
          if("p".equals(myUserModel.getUser(email,password).getType()))
          {
              //System.out.println(myUserModel.getUser(email,password).getType());
              Homepage1.main(null);
          }
          
          else 
          {
              Homepage2.main(null);
          }
      }
  }

  public void forgetPassword(String email) 
  {
     
  }

  public void sendFriendRequest(int FriendId,int userid) throws ClassNotFoundException 
  {
      
      friend.addFriend(FriendId,userid);
  }

  public void acceptFriendRequest() 
  {
  }

  public void getCurrentActiveUser() 
  {
      
  }
  
  public UserModel search(String email)
  {
     
      return null;
  }

}