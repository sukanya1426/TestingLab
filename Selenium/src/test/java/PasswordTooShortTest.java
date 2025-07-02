import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import static org.junit.Assert.assertTrue;

public class PasswordTooShortTest {
  private WebDriver driver;
  private PasswordTooShortPage passwordTooShortPage;

  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(955, 1068));
    passwordTooShortPage = new PasswordTooShortPage(driver);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testPasswordTooShort() {
    passwordTooShortPage.navigateToSignIn();
    passwordTooShortPage.clickCreateAccountLink();
    passwordTooShortPage.fillSignUpForm("i dont know", "name", "name@gmail.com", "1", "1");
    passwordTooShortPage.submitForm();
    assertTrue("Toast message 'should be at least 5 character(s)' should be displayed",
            passwordTooShortPage.isToastMessageDisplayed());
  }
}