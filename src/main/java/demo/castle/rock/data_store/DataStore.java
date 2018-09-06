package demo.castle.rock.data_store;
import demo.castle.rock.model.Customer;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class DataStore {

    private String response;
    private List<Customer> customerList = new ArrayList<Customer>();
    Entity DBCall; //Assume this makes the DB calls

    public boolean removeSpecificSprocketAmountFromDataStore(int amount){
        try {
            this.response = DBCall.removeSprocketAmount(amount);
        } catch (Exception e){
            this.response = null;
        }

        if(this.response != "200"){
            return false;
        } else {
            return true;
        }
    }

    public Boolean addToDataStore(Customer customer){
        //Here a call is made to udpdate whatever datastore is chosen. It could be written here for
        //AWS to Google Cloud to POSTGRE for an update
        try {
            this.response = DBCall.addNewCustomer(customer);
        } catch (Exception e){
            this.response = null;
        }

        if(this.response != "200"){
            return false;
        } else {
            return true;
        }
    }

    public int getSprocketQuantityFromDataStore(){

        //Here a call is made to verify sprocket quantity in whatever datastore is chosen. It could be written here for
        //AWS to Google Cloud to POSTGRE for an update
        try {
            this.dataStoreVerifiedAmount = DBCall.validateSprocketQuantity();
        } catch (Exception e){
            //Must handle the error here, did not find time to do it for this exercise.
        }

        return this.dataStoreVerifiedAmount;
    }

    public Boolean updateCustomerEmailToDataStore(String email, Long id){
        //Here a call is made to udpdate whatever datastore is chosen. It could be written here for
        //AWS to Google Cloud to POSTGRE for an update

        //Here the call will update the DB by matching the passed in ID with what is in the DB.
        //If they match, then do the update, otherwise expect a non 200 returned

        try {
            this.response = DBCall.updateEmail(email, id);
        } catch (Exception e){
            this.response = null;
        }

        if(this.response != "200"){
            return false;
        } else {
            return true;
        }
    }

    public List<Customer> querySingleOrderHistoryOverDateRange(Customer customer){
        //Here a call is made to udpdate whatever datastore is chosen. It could be written here for
        //AWS to Google Cloud to POSTGRE for an update
        try {
            this.customerList = DBCall.queryEntireSingleOrderHistoryOverDateRange(customer.getId(),
                    customer.getStartDate(), customer.getEndDate());
        } catch (Exception e){
            //Must handle the error here, did not find time to do it for this exercise.
        }

        return this.customerList;
    }

    public List<Customer> queryAllOrderHistoryOverDateRange(Customer customer){
        //Here a call is made to udpdate whatever datastore is chosen. It could be written here for
        //AWS to Google Cloud to POSTGRE for an update
        try {
            this.customerList = DBCall.queryCustomersWhoOrderTheMostSprocketsOverDateRange(customer.getId(),
                    customer.getStartDate(), customer.getEndDate(), "ascending");
        } catch (Exception e){
            //Must handle the error here, did not find time to do it for this exercise.
        }

        return this.customerList;
    }

    public List<Customer> queryAllCustomerOrderHistoryOverAllTime(Customer customer){
        //Here a call is made to udpdate whatever datastore is chosen. It could be written here for
        //AWS to Google Cloud to POSTGRE for an update
        try {
            this.customerList = DBCall.queryCustomersWhoOrderTheMostSprocketsOverAllTime(customer.getId(), "ascending");
        } catch (Exception e){
            //Must handle the error here, did not find time to do it for this exercise.
        }

        return this.customerList;
    }

    public List<Customer> querySingleOrderHistoryOverAllTime(Customer customer){
        //Here a call is made to udpdate whatever datastore is chosen. It could be written here for
        //AWS to Google Cloud to POSTGRE for an update
        try {
            this.customerList = DBCall.querySingleOrderHistoryOverAllTime(customer.getId());
        } catch (Exception e){
            //Must handle the error here, did not find time to do it for this exercise.
        }

        return this.customerList;
    }
}
