package demo.castle.rock.model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Sprocket")
public class Sprocket {
  private long id;
  private String name;
  private int amount;

  public void setId(long id) {
    this.id = id;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setAmount(int amount) {
    this.amount = amount;
  }


  @XmlElement(name = "name")
  public String getName() {
    return name;
  }

  @XmlElement(name = "id")
  public long getId() {
    return id;
  }

  @XmlElement(name = "amount")
  public int getAmount() {
    return amount;
  }
}