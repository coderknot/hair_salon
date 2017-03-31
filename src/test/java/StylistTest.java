import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.time.LocalDate;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Megan");
    assertTrue(testStylist instanceof Stylist);
  }

  @Test
  public void getName_getsStylistName_name() {
    Stylist testStylist = new Stylist("Megan");
    assertEquals("Megan", testStylist.getName());
  }

  @Test
  public void getHireDate_getsStylistHireDate_hireDate() {
    Stylist testStylist = new Stylist("Megan");
    String currentDate = LocalDate.now().toString();
    assertEquals(currentDate, testStylist.getHireDate());
  }
}
