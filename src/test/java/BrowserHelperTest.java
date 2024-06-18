import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class BrowserHelperTest extends BaseTest{
@Test
    void test123() throws InterruptedException {

    browserHelper.open(ConfigReader.getValue("baseURL"));
//    driver.findElement(By.xpath("//span[text()='Alerts']")).click();
    Thread.sleep(2000);
//    browserHelper.goBack();
//    Thread.sleep(2000);
//    browserHelper.goForward();
//    Thread.sleep(2000);
//    browserHelper.refresh();
//    Thread.sleep(2000);
    driver.findElement(By.id("tabButton")).click();
    Thread.sleep(1000);
    browserHelper.switchToWindow(0);
    Thread.sleep(3000);
    driver.findElement(By.id("tabButton")).click();
    Thread.sleep(1000);
    browserHelper.switchToWindow(0);
    Thread.sleep(1000);
    driver.findElement(By.id("tabButton")).click();
    Thread.sleep(1000);
    browserHelper.switchToWindow(0);
    Thread.sleep(1000);
    driver.findElement(By.id("tabButton")).click();
    Thread.sleep(1000);
    browserHelper.switchToWindow(1);
    Thread.sleep(3000);

    browserHelper.switchToParentWithChildrenClose();
    Thread.sleep(6000);
}

}
