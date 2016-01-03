package SW.Controler;
import SW.*;
import SW.Model.UserModel;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import SW.GUi.Main;

public class NormalUser extends UserController 
{

  public void upgrade(String credit) throws ClassNotFoundException, SQLException 
  {
      myUserModel.updateUser(credit,Main.U.id);
  }

   
  public void signUp(String name,String email,String password) {
        try {
            myUserModel.addNewUser(name, email, password,"n","f");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NormalUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NormalUser.class.getName()).log(Level.SEVERE, null, ex);
        }
  }

}