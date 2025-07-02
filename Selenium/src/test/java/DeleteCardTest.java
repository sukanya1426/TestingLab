import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import static org.junit.Assert.assertFalse;

public class DeleteCardTest {
  private WebDriver driver;
  private DeleteCardPage deleteCardPage;

  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(955, 1068));
    deleteCardPage = new DeleteCardPage(driver);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testDeleteCard() {
    deleteCardPage.navigateToSignIn();
    deleteCardPage.clickCreateAccountLink();
    deleteCardPage.fillSignUpForm("ismail", "ll", "ismail48@gmail.com", "12345678", "12345678");
    deleteCardPage.submitForm();
    deleteCardPage.clickAddBoardButton();
    deleteCardPage.enterBoardName("board12");
    deleteCardPage.submitForm();
    deleteCardPage.clickInnerContainer();
    deleteCardPage.enterListName("list12");
    deleteCardPage.submitForm();
    deleteCardPage.clickAddCardLink();
    deleteCardPage.enterCardName("card10");
    deleteCardPage.submitForm();
    deleteCardPage.clickCardContent();
    deleteCardPage.clickDeleteCardButton();
    assertFalse("Card should not be present after deletion", deleteCardPage.isCardPresent("card10"));
  }
}