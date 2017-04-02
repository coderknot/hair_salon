import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    testClient.save();
    assertTrue(testClient instanceof Client);
  }

  @Test
  public void getId_getsClientId_true() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    testClient.save();
    assertTrue(testClient.getId() > 0);
  }

  @Test
  public void getName_getsClientName_name() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    testClient.save();
    assertEquals("Chris", testClient.getName());
  }

  @Test
  public void getPhone_getsClientPhone_phone() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    testClient.save();
    assertEquals("(555) 555-5555", testClient.getPhone());
  }

  @Test
  public void getEmail_getsClientEmail_email() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    testClient.save();
    assertEquals("test@gmail.com", testClient.getEmail());
  }

  @Test
  public void getStylistId_getsClientStylistID_true() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    testClient.save();
    assertTrue(testClient.getStylistId() > 0);
  }

  @Test
  public void getStylistName_getsClientStylistName_stylistName() {
    Stylist testStylist = new Stylist("Megan");
    testStylist.save();
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", testStylist.getId());
    testClient.save();
    assertEquals(testStylist.getName(), testClient.getStylistName());
  }

  @Test
  public void equals_ClientObjectAreTheSame_true() {
    Client testClient1 = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    testClient1.save();
    Client testClient2 = testClient1;
    assertTrue(testClient1.equals(testClient2));
  }

  @Test
  public void all_returnsAllSavedClients_true() {
    Client testClient1 = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    testClient1.save();
    Client testClient2 = new Client("Jason", "(555) 555-5556", "test2@gmail.com", 2);
    testClient2.save();
    assertTrue(Client.all().get(0).equals(testClient1));
    assertTrue(Client.all().get(1).equals(testClient2));
  }

  @Test
  public void save_returnsTrueIfClientSaved_true() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    testClient.save();
    assertTrue(Client.all().get(0).equals(testClient));
  }

  @Test
  public void find_returnsClientWithSameId_Client() {
    Client testClient1 = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    testClient1.save();
    Client testClient2 = new Client("Jason", "(555) 555-5556", "test2@gmail.com", 2);
    testClient2.save();
    assertEquals(testClient2, Client.find(testClient2.getId()));
  }

  @Test
  public void updates_updatesClient_true() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    testClient.save();
    testClient.updateName("Jason");
    testClient.updatePhone("(555) 555-5556");
    testClient.updateEmail("test2@gmail.com");
    testClient.updateStylistId(2);
    assertEquals("Jason", Client.find(testClient.getId()).getName());
    assertEquals("(555) 555-5556", Client.find(testClient.getId()).getPhone());
    assertEquals("test2@gmail.com", Client.find(testClient.getId()).getEmail());
    assertEquals(2, Client.find(testClient.getId()).getStylistId());
  }

  @Test
  public void update_updatesClient_true() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    testClient.save();

    String newName = "Jason";
    String newPhone = "(555) 555-5556";
    String newEmail = "test2@gmail.com";
    int newStylistId = 2;

    testClient.update(newName, newPhone, newEmail, newStylistId);

    assertEquals(newName, Client.find(testClient.getId()).getName());
    assertEquals(newPhone, Client.find(testClient.getId()).getPhone());
    assertEquals(newEmail, Client.find(testClient.getId()).getEmail());
    assertEquals(newStylistId, Client.find(testClient.getId()).getStylistId());
  }

  @Test
  public void deletes_deletesClient_true() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    testClient.save();
    int testClientId = testClient.getId();
    testClient.delete();
    assertEquals(null, Client.find(testClientId));
  }

}
