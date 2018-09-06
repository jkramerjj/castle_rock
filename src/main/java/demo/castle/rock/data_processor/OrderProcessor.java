package demo.castle.rock.data_processor;
import demo.castle.rock.data_store.DataStore;
import demo.castle.rock.model.Order;

import javax.swing.text.html.parser.Entity;

public class OrderProcessor {
  static DataStore dataStore = new DataStore();
  Entity OrderCall; //Assume this makes the Order calls

  public boolean placeOrder(Order order) {
    //Here the order gets placed.
    //Possibly we would have another OrderCak call or an API call
    //This design would allow us the abstraction to place in a new Order Processor if needed.

    try {
      OrderCall.placeOrder(order);
    } catch (Exception e) {
      return false;
    }

    if(dataStore.removeSpecificSprocketAmountFromDataStore(order.getQuantity())){
      return true;
    } else {
      return false;
    }
  }
}