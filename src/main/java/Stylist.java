import org.sql2o.*;
import java.time.LocalDate;
import java.util.List;

public class Stylist {

  private int id;
  private String name;
  private String hireDate;

  public Stylist(String name) {
    this.name = name;
    this.hireDate = LocalDate.now().toString();
  }

  public String getName() {
    return this.name;
  }

  public String getHireDate() {
    return this.hireDate;
  }

  public boolean equals(Object otherStylist) {
    if(!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getName().equals(newStylist.getName())
        && this.getHireDate().equals(newStylist.getHireDate());
    }
  }

  public static List<Stylist> all() {
    return null;
  }

}
