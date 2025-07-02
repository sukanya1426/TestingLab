import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class UpdateListPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By loginButton = By.cssSelector("button");
    private By addBoardButton = By.id("add_new_board");
    private By boardNameField = By.id("board_name");
    private By innerContainer = By.cssSelector(".inner");
    private By listNameField = By.id("list_name");
    private By submitButton = By.cssSelector("button");
    private By listTitle = By.cssSelector("h4");

    public UpdateListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToSignIn() {
        driver.get("http://localhost:4000/sign_in");
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void clickAddBoardButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addBoardButton)).click();
    }

    public void enterBoardName(String boardName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(boardNameField)).sendKeys(boardName);
    }

    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void clickInnerContainer() {
        wait.until(ExpectedConditions.elementToBeClickable(innerContainer)).click();
    }

    public void enterListName(String listName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(listNameField)).sendKeys(listName);
    }

    public void clickListTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(listTitle)).click();
    }

    public String getListName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(listTitle)).getText();
    }
}