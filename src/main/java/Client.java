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
    return "";
  }
  
  public int getStylistId() {
    return this.stylist_id;
  }

}
