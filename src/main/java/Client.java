import org.sql2o.*;

public class Client {

  private String name;
  private int stylist_id;

  public Client(String name, int stylist_id) {
    this.name = name;
    this.stylist_id = stylist_id;
  }

  public String getName() {
    return this.name;
  }

}
