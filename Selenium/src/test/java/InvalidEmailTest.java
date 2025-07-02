import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import static org.junit.Assert.assertTrue;

public class InvalidEmailTest {
  private WebDriver driver;
  private InvalidEmailPage invalidEmailPage;

  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(955, 1068));
    invalidEmailPage = new InvalidEmailPage(driver);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testInvalidEmail() {
    invalidEmailPage.navigateToSignIn();
    invalidEmailPage.clickCreateAccountLink();
    invalidEmailPage.fillSignUpForm("first", "last", "mail.com", "123456789", "123456789");
    invalidEmailPage.submitForm();
    assertTrue(invalidEmailPage.isValidationMessageDisplayed());
  }
}