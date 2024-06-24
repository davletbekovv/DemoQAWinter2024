import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class MenuTest extends BaseTest{
    @Test(groups = {"Regression","4321"} , description = "Menu Test")
    public void moveTopElementTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/menu");
        webElementActions.moveToElement(menuPage.mainItem2);
        Thread.sleep(5000);
    }
}
