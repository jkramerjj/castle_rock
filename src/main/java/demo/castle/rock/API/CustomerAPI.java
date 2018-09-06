package demo.castle.rock.API;
import demo.castle.rock.data_processor.CustomerProcessor;
import demo.castle.rock.model.Customer;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customer")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CustomerAPI {

  static CustomerProcessor customerProcessor = new CustomerProcessor();

  //- Add a customer to the system
  @POST
  @Path("/add")
  public Response createCustomer(Customer customer) {

    if(customerProcessor.addCustomer(customer)){
      return Response.ok().entity("").build();
    }
    else{
      //With more time I would build a response class, which could be called when an
      //issue happens
      return Response.status(400).entity("").build();
    }
  }

  //- Edit a customer's email address
  @Path("/email")
  @PUT
  public Response editCustomerEmail(Customer customer) {
    if(customerProcessor.editCustomerEmail(customer)){
      return Response.ok().entity("").build();
    }
    else{
      return Response.status(400).entity("").build();
    }
  }

  //- Query a single customer's order history over all of time
  @GET()
  @Path("/getEntireCustomerOrderHistory")
  public Response getEntireCustomerOrderHistory(Customer customer) {

    List<Customer> customerList = customerProcessor.getEntireOrderHistoryForOneCustomer(customer);

    if(customerList != null){
      return Response.ok().entity(customerList).build();
    }
    else{
      return Response.status(400).entity("").build();
    }
  }

  //- Query a single customer's order history over a date range
  @GET()
  @Path("/getDatedSingleOrderHistory")
  public Response getDatedSingleCustomerOrderHistory(Customer customer) {

    List<Customer> customerList =
            customerProcessor.getDatedOrderHistoryForOneCustomer(customer);

    if(customerList != null){
      return Response.ok().entity(customerList).build();
    }
    else{
      return Response.status(400).entity("").build();
    }
  }

  //- Query which customers have ordered the most sprockets over all of time
  @GET()
  @Path("/getCustomersWhoOrderedTheMostSprocketsOverAllTime")
  public Response getCustomersWhoOrderedTheMostSprocketsOverAllTime(Customer customer) {

    List<Customer> customerList =
            customerProcessor.getAllWhoHaveOrderedTheMostSprocketsOverAllTime(customer);

    if(customerList != null){
      return Response.ok().entity(customerList).build();
    }
    else{
      return Response.status(400).entity("").build();
    }
  }

  //- Query which customers have ordered the most sprockets over a date range
  @GET()
  @Path("/getAllWhoOrderedTheMostSprocketsOverDateRange")
  public Response getAllWhoOrderedTheMostSprocketsOverDateRange(Customer customer) {

    List<Customer> customerList =
            customerProcessor.getAllWhoHaveOrderedTheMostSprocketsOverDateRange(customer);

    if(customerList != null){
      return Response.ok().entity(customerList).build();
    }
    else{
      return Response.status(400).entity("").build();
    }
  }
}
