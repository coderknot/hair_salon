import org.sql2o.*;
import java.util.List;

public class Client {

  private int id;
  private String name;
  private String phone;
  private String email;
  private int stylistId;

  public Client(String name, String phone, String email, int stylistId) {
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.stylistId = stylistId;
  }

  public int getId() {
    return 0;
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
    return this.stylistId;
  }

  public boolean equals(Object otherClient) {
    if(!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getId() == newClient.getId()
        && this.getName().equals(newClient.getName())
        && this.getPhone().equals(newClient.getPhone())
        && this.getEmail().equals(newClient.getEmail())
        && this.getStylistId() == newClient.getStylistId();
    }
  }

  public static List<Client> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients;";
      return con.createQuery(sql)
        .addColumnMapping("stylist_id", "stylistId")
        .executeAndFetch(Client.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name, phone, email, stylist_id) VALUES (:name, :phone, :email, :stylistId);";
      this.id = (int) con.createQuery(sql, true)
        .addColumnMapping("stylist_id", "stylistId")
        .addParameter("name", this.getName())
        .addParameter("phone", this.getPhone())
        .addParameter("email", this.getEmail())
        .addParameter("stylistId", this.getStylistId())
        .executeUpdate()
        .getKey();
    }
  }

}
