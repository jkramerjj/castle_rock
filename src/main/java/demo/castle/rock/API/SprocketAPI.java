package demo.castle.rock.API;
import demo.castle.rock.data_processor.OrderProcessor;
import demo.castle.rock.data_processor.SprocketProcessor;
import demo.castle.rock.model.Customer;
import demo.castle.rock.model.Order;
import demo.castle.rock.model.Sprocket;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/order")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class SprocketAPI {
  static SprocketProcessor sprocketProcessor = new SprocketProcessor();
  static OrderProcessor orderProcessor = new OrderProcessor();

  //Create an order for one or more sprockets, assigned to a single customer
  @Path("/create")
  public Response createSprocketOrder(Sprocket sprocket, Customer customer) {
      boolean results = false;
      if (sprocketProcessor.validateSprocketInventory(sprocket)) {
          //create the order here
          Order order = new Order();
          order.setQuantity(sprocket.getAmount());
          order.setCustomer(customer);
          results = orderProcessor.placeOrder(order);
      }

      if (results) {
          return Response.ok().entity("").build();
      } else {
          return Response.status(400).entity("").build();
      }
  }
}
