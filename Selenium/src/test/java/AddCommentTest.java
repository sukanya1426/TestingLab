import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import static org.junit.Assert.assertTrue;

public class AddCommentTest {
  private WebDriver driver;
  private AddCommentPage addCommentPage;

  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(955, 1068));
    addCommentPage = new AddCommentPage(driver);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testAddComment() {
    addCommentPage.navigateToSignIn();
    addCommentPage.clickCreateAccountLink();
    addCommentPage.fillSignUpForm("salsa", "bila", "salsa223@gmail.com", "12345678", "12345678");
    addCommentPage.submitForm();
    addCommentPage.clickInnerContainer();
    addCommentPage.clickViewContainer();
    addCommentPage.clickAddBoardButton();
    addCommentPage.enterBoardName("board10");
    addCommentPage.submitForm();
    addCommentPage.clickInnerContainer();
    addCommentPage.enterListName("list10");
    addCommentPage.submitForm();
    addCommentPage.clickAddCardLink();
    addCommentPage.enterCardName("card1");
    addCommentPage.submitForm();
    addCommentPage.clickCardContent();
    addCommentPage.enterComment("comment1");
    addCommentPage.submitForm();
    assertTrue("Comment should be present after submission", addCommentPage.isCommentPresent("comment1"));
    addCommentPage.clickCloseButton();
  }
}