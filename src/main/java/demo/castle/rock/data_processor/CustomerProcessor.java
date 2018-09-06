package demo.castle.rock.data_processor;
import demo.castle.rock.data_store.DataStore;
import demo.castle.rock.model.Customer;
import java.util.List;

public class CustomerProcessor {

  static DataStore dataStore = new DataStore();

  public boolean addCustomer(Customer customer) {

    //I would also add checks here to validate the data
    // #1) exists
    // #2) is scrubbed for special chars
    // #3) try to prevent us from the DB getting hacked
    customer.setId(customer.getId());
    customer.setUsername(customer.getUsername());
    customer.setFirstName(customer.getFirstName());
    customer.setLastName(customer.getLastName());
    customer.setEmail(customer.getEmail());
    customer.setPassword("123_NOT_SET");
    customer.setPhone(customer.getPhone());
    customer.setUserStatus(customer.getUserStatus());

    if(dataStore.addToDataStore(customer)){
      return true;
    } else {
      return false;
    }
  }

  public boolean editCustomerEmail(Customer customer){

    //I would also add checks here to validate the data
    // #1) exists
    // #2) is scrubbed for special chars
    // #3) try to prevent the DB from getting hacked
    customer.getEmail();
    customer.getId();

    if(dataStore.updateCustomerEmailToDataStore(customer.getEmail(), customer.getId())){
    } else {
      return false;
    }
    return true;
  }

  public List<Customer> getDatedOrderHistoryForOneCustomer(Customer customer){
    return dataStore.querySingleOrderHistoryOverDateRange(customer);
  }

  public List<Customer> getAllWhoHaveOrderedTheMostSprocketsOverDateRange(Customer customer){
    return dataStore.queryAllOrderHistoryOverDateRange(customer);
  }

  public List<Customer> getAllWhoHaveOrderedTheMostSprocketsOverAllTime(Customer customer){
    return dataStore.queryAllCustomerOrderHistoryOverAllTime(customer);
  }

  public List<Customer> getEntireOrderHistoryForOneCustomer(Customer customer){
         return dataStore.querySingleOrderHistoryOverAllTime(customer);
  }
}