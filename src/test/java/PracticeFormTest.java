import drivers.DriverManager;
import entities.PracticeFormEntity;
import entities.TextBoxEntity;
import enums.Endpoints;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import utils.ConfigReader;
import utils.RandomUtils;

public class PracticeFormTest extends BaseTest {
    @Test
    public void practiceFormTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL")+ Endpoints.PRACTICEFORM.getEndpoint());


       PracticeFormEntity practiceFormEntity = randomUtils.generateRandomPracticeFormEntities();
       practiceFormPage.fillUpPracticeForm(practiceFormEntity);
      //  practiceFormPage.selectDateMonthYear("30 Jun 2020");
        Thread.sleep(7000);

    }
}
