import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CreateBoard {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By viewContainer = By.cssSelector(".view-container");
    private By addNewBoardButton = By.id("add_new_board");
    private By boardNameInput = By.id("board_name");
    private By submitButton = By.cssSelector("button");
    private By innerContainer = By.cssSelector(".inner");
    private By listNameInput = By.id("list_name");

    // Constructor
    public CreateBoard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Page actions
    public void navigateTo(String url) {
        driver.get(url);
    }

    public void setWindowSize(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public void clickViewContainer() {
        wait.until(ExpectedConditions.elementToBeClickable(viewContainer)).click();
    }

    public void clickAddNewBoard() {
        wait.until(ExpectedConditions.elementToBeClickable(addNewBoardButton)).click();
    }

    public void enterBoardName(String boardName) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(boardNameInput));
        input.click();
        input.sendKeys(boardName);
    }

    public void submitBoardCreation() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void clickInnerContainer() {
        wait.until(ExpectedConditions.elementToBeClickable(innerContainer)).click();
    }

    public void enterListName(String listName) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(listNameInput));
        input.sendKeys(listName);
    }

    public void submitListCreation() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    // Combined action for creating a board and list
    public void createBoardAndList(String boardName, String listName) {
        clickViewContainer();
        clickAddNewBoard();
        enterBoardName(boardName);
        submitBoardCreation();
        clickInnerContainer();
        enterListName(listName);
        submitListCreation();
    }
}