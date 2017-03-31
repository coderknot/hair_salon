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
  public void getStylistId_getsStylistIdOfClient_true() {
    Client testClient = new Client("Chris", "(555) 555-5555", "test@gmail.com", 1);
    assertTrue(testClient.getStylistId() > 0);
  }

}
