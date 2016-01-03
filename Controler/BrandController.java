/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SW.Controler;
import SW.*;
import SW.Model.BrandModel;
import SW.Model.PlaceModel;
import SW.Model.UserModel;
/**
 *
 * @author Ahmed
 */
public class BrandController {
    private BrandModel model=new BrandModel();
    
    public void createBrand(String Name,int OwnerId) throws ClassNotFoundException 
    {
        model.saveBrand(Name, OwnerId);
    }

  public void createATip(String text, PlaceModel place) {
  }

  public void followBrand(UserModel user) {
  }
    
}
