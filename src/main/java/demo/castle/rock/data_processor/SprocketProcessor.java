package demo.castle.rock.data_processor;
import demo.castle.rock.data_store.DataStore;
import demo.castle.rock.model.Sprocket;

public class SprocketProcessor {

  static DataStore dataStore = new DataStore();

  public boolean validateSprocketInventory(Sprocket sprocket) {
    if(sprocket.getAmount() < 1
            && dataStore.getSprocketQuantityFromDataStore() < sprocket.getAmount()){
      return false;
    } else {
      return true;
    }
  }
}