import drivers.DriverManager;
import entities.TextBoxEntity;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.RandomUtils;

public class TextBoxTest extends BaseTest {
    @Test
    public void textBoxTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL"));
        TextBoxEntity textBoxEntity = randomUtils.generateRandomTextBoxEntity();
  textBoxPage.fillUpTextBoxForm(textBoxEntity);
        Thread.sleep(3000);


    }
}
