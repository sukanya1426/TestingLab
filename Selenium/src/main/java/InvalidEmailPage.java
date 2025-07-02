import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class InvalidEmailPage {
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
    private By validationMessage = By.xpath("//*[contains(@class, 'toast') or contains(@class, 'notification')][contains(text(), 'please enter an email address')]");

    public InvalidEmailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
//    public boolean isEmailEmpty(){
//        try {
//            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(emailInput));
//            String message = element.getAttribute("validationMessage");
//            if(message == null) return false;
//            return message.equals("Please fill out this field.");
//        }catch (TimeoutException e){
//            e.printStackTrace();
//            return false;
//        }
//    }

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

    public boolean isValidationMessageDisplayed() {
//        try {
//            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(validationMessage));
//            String innerHtml = element.getAttribute("innerHTML");
//            return innerHtml != null && innerHtml.contains("Please enter an email address.");
//        } catch (Exception e) {
//            return false; // Validation message is not present or attribute check failed
//        }
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
            String message = element.getAttribute("validationMessage");
            System.out.println(message);
            if(message == null) return false;
            return message.equals("Please enter an email address.");
        }catch (TimeoutException e){
            e.printStackTrace();
            return false;
        }
    }
}