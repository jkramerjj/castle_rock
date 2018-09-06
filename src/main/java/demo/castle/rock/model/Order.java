package demo.castle.rock.model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Order")
public class Order {
  private long id;
  private int quantity;
  private String date;
  private Customer customer;

  public void setCustomer(Customer customer){
    this.customer = customer;
  }
  public void setId(long id) {
    this.id = id;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @XmlElement(name = "id")
  public long getId() {
    return id;
  }

  @XmlElement(name = "quantity")
  public int getQuantity() {
    return quantity;
  }

}