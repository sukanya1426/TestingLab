import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AddMemberPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By createAccountLink = By.linkText("Create new account");
    private By firstNameInput = By.id("user_first_name");
    private By lastNameInput = By.id("user_last_name");
    private By emailInput = By.id("user_email");
    private By passwordInput = By.id("user_password");
    private By passwordConfirmationInput = By.id("user_password_confirmation");
    private By submitButton = By.cssSelector("button");
    private By signOutButton = By.cssSelector("#crawler-sign-out > span");
    private By addNewBoardButton = By.id("add_new_board");
    private By boardNameInput = By.id("board_name");
    private By addMemberIcon = By.cssSelector("li > .add-new");
    private By memberEmailInput = By.id("crawljax_member_email");
    private By bodyElement = By.tagName("body");
    private By avatarElements = By.cssSelector(".avatar");

    // Constructor
    public AddMemberPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10-second wait
    }

    // Navigates to the application URL
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Sets the browser window size
    public void setWindowSize(int width, int height) {
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
    }

    // Clicks the "Create new account" link
    public void clickCreateAccountLink() {
        driver.findElement(createAccountLink).click();
    }

    // Fills the sign-up form
    public void fillSignUpForm(String firstName, String lastName, String email, String password, String passwordConfirmation) {
        WebElement firstNameField = driver.findElement(firstNameInput);
        firstNameField.click();
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = driver.findElement(lastNameInput);
        lastNameField.click();
        lastNameField.sendKeys(lastName);

        WebElement emailField = driver.findElement(emailInput);
        emailField.click();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(passwordInput);
        passwordField.click();
        passwordField.sendKeys(password);

        WebElement passwordConfirmationField = driver.findElement(passwordConfirmationInput);
        passwordConfirmationField.click();
        passwordConfirmationField.sendKeys(passwordConfirmation);
    }

    // Submits the sign-up form
    public void submitSignUpForm() {
        WebElement submitBtn = driver.findElement(submitButton);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();
    }

    // Signs out the user
    public LoginPage signOut() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(signOutButton));
        element.click();
        return new LoginPage(driver);
        // Confirm sign-out if required (clicking the button again as per original script)
//        WebElement confirmBtn = driver.findElement(submitButton);
//        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
//        confirmBtn.click();
    }

    // Clicks the "Add New Board" button
    public void clickAddNewBoard() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addNewBoardButton));
        element.click();
    }

    // Enters the board name
    public void enterBoardName(String boardName) {
        WebElement boardNameField = driver.findElement(boardNameInput);
        boardNameField.clear();
        boardNameField.sendKeys(boardName);
    }

    // Submits the board creation form
    public void submitBoardCreation() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        element.click();
    }

    // Clicks the "Add Member" icon and hovers as needed
    public void clickAddMemberIcon() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addMemberIcon));
        element.click();
    }

    // Enters the member email
    public void enterMemberEmail(String email) {
        WebElement emailField = driver.findElement(memberEmailInput);
        emailField.clear();
        emailField.sendKeys(email);
    }

    // Submits the member addition form
    public void submitMemberAddition() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        element.click();
    }


    // Performs the full flow: sign-up, sign-out, create board, add member
    public void performFullFlow(String firstName, String lastName, String email, String password, String passwordConfirmation, String boardName) {
        clickCreateAccountLink();
        fillSignUpForm(firstName, lastName, email, password, passwordConfirmation);
        submitSignUpForm();
        LoginPage loginPage = signOut();
        loginPage.clickSubmitButton();
        clickAddNewBoard();
        enterBoardName(boardName);
        submitBoardCreation();
        clickAddMemberIcon();
        enterMemberEmail(email);
        submitMemberAddition();
    }
}