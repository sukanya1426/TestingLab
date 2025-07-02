import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateBoardTest {
  private WebDriver driver;
  private CreateBoard createBoard;

  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    createBoard = new CreateBoard(driver);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void createBoard() {
    createBoard.navigateTo("http://localhost:4000/");
    createBoard.setWindowSize(1124, 1068);
    createBoard.createBoardAndList("board1", "list1");
  }
}