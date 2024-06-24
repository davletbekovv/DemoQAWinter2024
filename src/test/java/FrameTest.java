import enums.Endpoints;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import utils.ConfigReader;

public class FrameTest extends BaseTest {
    @Test(groups = {"Regression", "1345"}, description = "Verify that driver can switch to another frame")
    public void frameTest() {
        browserHelper.open(ConfigReader.getValue("baseURL")+ Endpoints.FRAMES.getEndpoint());
        iframeHelper.switchToFrame("frame1");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        iframeHelper.switchToParentFrame();
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }

}
