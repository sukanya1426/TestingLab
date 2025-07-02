import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AddCommentPage {
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
    private By innerContainer = By.cssSelector(".inner");
    private By viewContainer = By.cssSelector(".view-container");
    private By addBoardButton = By.id("add_new_board");
    private By boardNameField = By.id("board_name");
    private By listNameField = By.id("list_name");
    private By addCardLink = By.linkText("Add a new card...");
    private By cardNameField = By.id("card_name");
    private By cardContent = By.cssSelector(".card-content > span");
    private By commentTextArea = By.cssSelector("textarea");
    private By closeButton = By.cssSelector(".fa-close");

    public AddCommentPage(WebDriver driver) {
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

    public void clickInnerContainer() {
        wait.until(ExpectedConditions.elementToBeClickable(innerContainer)).click();
    }

    public void clickViewContainer() {
        wait.until(ExpectedConditions.elementToBeClickable(viewContainer)).click();
    }

    public void clickAddBoardButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addBoardButton)).click();
    }

    public void enterBoardName(String boardName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(boardNameField)).sendKeys(boardName);
    }

    public void enterListName(String listName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(listNameField)).sendKeys(listName);
    }

    public void clickAddCardLink() {
        wait.until(ExpectedConditions.elementToBeClickable(addCardLink)).click();
    }

    public void enterCardName(String cardName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardNameField)).sendKeys(cardName);
    }

    public void clickCardContent() {
        wait.until(ExpectedConditions.elementToBeClickable(cardContent)).click();
    }

    public void enterComment(String comment) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentTextArea)).sendKeys(comment);
    }

    public void clickCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
    }

    public boolean isCommentPresent(String comment) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + comment + "')]")));
            return true; // Comment is present
        } catch (Exception e) {
            return false; // Comment is not present
        }
    }
}