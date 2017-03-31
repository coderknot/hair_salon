import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true() {
    Client testClient = new Client("Chris", 1);
    assertTrue(testClient instanceof Client);
  }

  @Test
  public void getName_getsClientName_Chris() {
    Client testClient = new Client("Chris", 1);
    assertEquals("Chris", testClient.getName());
  }

}
