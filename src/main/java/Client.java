import org.sql2o.*;

public class Client {

  private String name;
  private String phone;
  private String email;
  private int stylist_id;

  public Client(String name, String phone, String email, int stylist_id) {
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.stylist_id = stylist_id;
  }

  public String getName() {
    return this.name;
  }

  public String getPhone() {
    return this.phone;
  }

  public String getEmail() {
    return this.email;
  }

  public int getStylistId() {
    return this.stylist_id;
  }

  public boolean equals(Object otherClient) {
    if(!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName())
        && this.getPhone().equals(newClient.getPhone())
        && this.getEmail().equals(newClient.getEmail())
        && this.getStylistId() == newClient.getStylistId();
    }
  }
}
