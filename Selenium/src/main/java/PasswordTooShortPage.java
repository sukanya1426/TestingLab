import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PasswordTooShortPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By createAccountLink = By.linkText("Create new account");
    private By firstNameField = By.id("user_first_name");
    private By lastNameField = By.id("user_last_name");
    private By emailField = By.id("user_email");
    private By passwordField = By.id("user_password");
    private By passwordConfirmationField = By.id("user_password_confirmation");
    private By submitButton = By.cssSelector("button");
    private By toastMessage = By.xpath("//*[contains(text(), 'should be at least 5 character(s)')]");

    public PasswordTooShortPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToSignIn() {
        driver.get("http://localhost:4000/sign_in");
    }

    public void clickCreateAccountLink() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountLink)).click();
    }

    public void fillSignUpForm(String firstName, String lastName, String email, String password, String passwordConfirmation) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(passwordConfirmationField).sendKeys(passwordConfirmation);
    }

    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public boolean isToastMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage));
            return true; // Toast message is present
        } catch (Exception e) {
            return false; // Toast message is not present
        }
    }
}