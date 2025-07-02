import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LoginPage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By emailInput = By.id("user_email");
    private final By passwordInput = By.id("user_password");
    private final By submitButton = By.cssSelector("button");
    private final By nameDisplay = By.cssSelector("span:nth-child(3)");
    private final By errorMessage = By.cssSelector(".error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToLogin() {
        logger.info("Navigating to http://localhost:4000/sign_in");
        driver.get("http://localhost:4000/sign_in");
    }

    public void enterEmail(String email) {
        logger.info("Entering email '{}'", email);
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        input.clear();
        input.sendKeys(email);
        logger.info("Entered email '{}'", email);
    }

    public void enterPassword(String password) {
        logger.info("Entering password");
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        input.clear();
        input.sendKeys(password);
        logger.info("Entered password");
    }

    public void clickSubmitButton() {
        logger.info("Clicking submit button");
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        button.click();
        logger.info("Clicked submit button");
    }

    public String getDisplayedName() {
        logger.info("Retrieving displayed name");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(nameDisplay));
        String text = element.getText();
        logger.info("Retrieved displayed name: '{}'", text);
        return text;
    }

    public String getErrorMessage() {
        logger.info("Retrieving error message");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        String text = element.getText();
        logger.info("Retrieved error message: '{}'", text);
        return text;
    }

    public boolean isPasswordEmpty(){
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(passwordInput));
            String message = element.getAttribute("validationMessage");
            if(message == null) return false;
            return message.equals("Please fill out this field.");
        }catch (TimeoutException e){
            //e.printStackTrace();
            return false;
        }

    }

    public boolean isEmailEmpty(){
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(emailInput));
            String message = element.getAttribute("validationMessage");
            if(message == null) return false;
            return message.equals("Please fill out this field.");
        }catch (TimeoutException e){
        //    e.printStackTrace();
            return false;
        }
    }


}