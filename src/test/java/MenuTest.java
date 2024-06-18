import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class MenuTest extends BaseTest{
    @Test(description = "Verify mobe to elemenet methods is working")
    public void moveTopElementTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL"));
        webElementActions.moveToElement(menuPage.mainItem2);
        Thread.sleep(5000);
    }
}
