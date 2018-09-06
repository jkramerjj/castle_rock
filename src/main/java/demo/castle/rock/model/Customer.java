package demo.castle.rock.model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Customer")
public class Customer {
  private long id;
  private int userStatus;
  private String firstName;
  private String lastName;
  private String email;
  private String username;
  private String password;
  private String phone;
  private String startDate;
  private String endDate;


  public void setId(long id) {
    this.id = id;
  }
  public void setEmail(String email) {
        this.email = email;
    }
  public void setFirstName(String firstName) {this.firstName = firstName;}
  public void setUsername(String username) {
    this.username = username;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public void setUserStatus(int userStatus) {
    this.userStatus = userStatus;
  }
  public void setEndDate(String endDate) {this.endDate = endDate;}
  public void setStartDate(String startDate) {this.startDate = startDate;}

  @XmlElement(name = "lastName")
  public String getLastName() {
        return lastName;
    }

  @XmlElement(name = "firstName")
  public String getFirstName() {return firstName; }

  @XmlElement(name = "username")
  public String getUsername(){return username;}

  @XmlElement(name = "email")
  public String getEmail() {
        return email;
    }

  @XmlElement(name = "phone")
  public String getPhone() {
        return phone;
    }

  @XmlElement(name = "password")
  public String getPassword() {
        return password;
    }

   @XmlElement(name = "userStatus")
  public int getUserStatus() {
        return userStatus;
    }

  @XmlElement(name = "id")
  public long getId() { return id; }

  @XmlElement(name = "startDate")
  public String getStartDate() {
    return startDate;
  }

  @XmlElement(name = "endDate")
  public String getEndDate() {
    return endDate;
  }

}