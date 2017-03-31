import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    assertTrue(testClient instanceof Client);
  }

  @Test
  public void getName_getsClientName_name() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    assertEquals("Chris", testClient.getName());
  }

  @Test
  public void getPhone_getsClientPhone_phone() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    assertEquals("(555) 555-5555", testClient.getPhone());
  }

  @Test
  public void getEmail_getsClientEmail_email() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    assertEquals("test@gmail.com", testClient.getEmail());
  }

  @Test
  public void getStylistId_getsClientStylistID_true() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    assertTrue(testClient.getStylistId() > 0);
  }

  @Test
  public void equals_ClientObjectAreTheSame_true() {
    Client testClient1 = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
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

}
