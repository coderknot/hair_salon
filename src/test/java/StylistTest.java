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
    testStylist.save();
    assertTrue(testStylist instanceof Stylist);
  }

  @Test
  public void getId_getId_getsStylistId_true() {
    Stylist testStylist = new Stylist("Megan");
    testStylist.save();
    assertTrue(testStylist.getId() > 0);
  }

  @Test
  public void getName_getsStylistName_name() {
    Stylist testStylist = new Stylist("Megan");
    testStylist.save();
    assertEquals("Megan", testStylist.getName());
  }

  @Test
  public void getHireDate_getsStylistHireDate_hireDate() {
    Stylist testStylist = new Stylist("Megan");
    testStylist.save();
    String currentDate = LocalDate.now().toString();
    assertEquals(currentDate, testStylist.getHireDate());
  }

  @Test
  public void equals_StylistObjectsAreTheSame_true() {
    Stylist testStylist1 = new Stylist("Megan");
    testStylist1.save();
    Stylist testStylist2 = testStylist1;
    assertTrue(testStylist1.equals(testStylist2));
  }

  @Test
  public void all_returnsAllSavedStylists_true() {
    Stylist testStylist1 = new Stylist("Megan");
    testStylist1.save();
    Stylist testStylist2 = new Stylist("Gloria");
    testStylist2.save();
    assertTrue(Stylist.all().get(0).equals(testStylist1));
    assertTrue(Stylist.all().get(1).equals(testStylist2));
  }

  @Test
  public void save_returnsTrueIfStylistSaved_true() {
    Stylist testStylist = new Stylist("Megan");
    testStylist.save();
    assertTrue(Stylist.all().get(0).equals(testStylist));
  }

  @Test
  public void find_returnsStylistWithSameId_Stylist() {
    Stylist testStylist1 = new Stylist("Megan");
    testStylist1.save();
    Stylist testStylist2 = new Stylist("Gloria");
    testStylist2.save();
    assertEquals(testStylist2, Stylist.find(testStylist2.getId()));
  }

  @Test
  public void getClients_getsClientsOfStylist_Clients() {
    Stylist testStylist = new Stylist("Megan");
    testStylist.save();
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", testStylist.getId());
    testClient.save();
    assertTrue(testStylist.getClients().contains(testClient));
  }
}
