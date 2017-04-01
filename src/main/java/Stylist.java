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

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getHireDate() {
    return this.hireDate;
  }

  public static List<Stylist> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists;";
      return con.createQuery(sql)
        .addColumnMapping("hire_date", "hireDate")
        .executeAndFetch(Stylist.class);
    }
  }

  public static Stylist find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE id = :id;";
      Stylist stylist = con.createQuery(sql)
        .addColumnMapping("hire_date", "hireDate")
        .addParameter("id", id)
        .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

  public List<Client> getClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE stylist_id = :id;";
      return con.createQuery(sql)
        .addColumnMapping("stylist_id", "stylistId")
        .addParameter("id", id)
        .executeAndFetch(Client.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists (name, hire_date) VALUES (:name, CAST(:hireDate AS DATE));";
      this.id = (int) con.createQuery(sql, true)
        .addColumnMapping("hire_date", "hireDate")
        .addParameter("name", this.getName())
        .addParameter("hireDate", this.getHireDate())
        .executeUpdate()
        .getKey();
    }
  }

  public void updateName(String name) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE stylists SET name = :name WHERE id = :id;";
      con.createQuery(sql)
        .addParameter("name", name)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public boolean equals(Object otherStylist) {
    if(!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getId() == newStylist.getId()
        && this.getName().equals(newStylist.getName())
        && this.getHireDate().equals(newStylist.getHireDate());
    }
  }

}
