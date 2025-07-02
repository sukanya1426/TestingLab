import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import static org.junit.Assert.assertEquals;

public class UpdateListTest {
  private WebDriver driver;
  private UpdateListPage updateListPage;

  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(955, 1068));
    updateListPage = new UpdateListPage(driver);
    updateListPage.navigateToSignIn();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void updateList() {
    updateListPage.clickLoginButton();
    updateListPage.clickAddBoardButton();
    updateListPage.enterBoardName("board2000");
    updateListPage.submitForm();
    updateListPage.clickInnerContainer();
    updateListPage.enterListName("list20000");
    updateListPage.submitForm();
    assertEquals("List name should be 'list20000' after creation", "list20000", updateListPage.getListName());
    updateListPage.clickListTitle();
    updateListPage.enterListName("list3000");
    updateListPage.submitForm();
    assertEquals("List name should be 'list3000list20000' after update", "list3000list20000", updateListPage.getListName());
  }
}