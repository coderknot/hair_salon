import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

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
}
