package SW.Controler;
import SW.*;
import SW.Model.UserModel;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PremiumUser extends UserController {
    UserModel model =new UserModel();

  public void verifyCreditCard() 
  {
      
  }

  public void signUp(String name,String email,String password,String Type,String creditCard) throws ClassNotFoundException 
  {
        try {
            model.addNewUser(name, email, password, Type, creditCard);
        } catch (SQLException ex) {
            Logger.getLogger(PremiumUser.class.getName()).log(Level.SEVERE, null, ex);
        }
  }

}