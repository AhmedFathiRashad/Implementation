package SW.Controler;
import SW.*;
import SW.Model.MessageModel;
import SW.Model.UserModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class MessageController {
        private MessageModel model=new MessageModel();

  public ArrayList<UserModel> receivedUsers;

    public Vector  myMessageModel;

  public void sendMessage(int sender,int receiver,String message) throws ClassNotFoundException {
      model.addNewMessage(sender, receiver, message);

  }

  public void addReceiver() {
  }

}