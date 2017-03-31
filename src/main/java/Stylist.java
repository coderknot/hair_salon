import org.sql2o.*;
import java.time.LocalDate;


public class Stylist {

  private int id;
  private String name;
  private String hireDate;

  public Stylist(String name) {
    this.name = name;
    this.hireDate = LocalDate.now().toString();
  }

  public String getName() {
    return "";
  }

}
