import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AddMemberTest {
    private WebDriver driver;
    private AddMemberPage addMemberPage;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        addMemberPage = new AddMemberPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAddMember() {
        addMemberPage.navigateTo("http://localhost:4000/sign_in");
        addMemberPage.setWindowSize(955, 1068);
        addMemberPage.performFullFlow(
                "aaaa", // firstName
                "aaaaa", // lastName
                "qaq1556904571@qaqa.com", // email
                "qaqaqa", // password
                "qaqaqa", // passwordConfirmation
                "fgdfddf" // boardName
        );

        List<WebElement> elements = driver.findElements(By.cssSelector("li:nth-child(2) > .react-gravatar"));
        assert(elements.size() > 0);
    }
}