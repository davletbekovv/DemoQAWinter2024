import enums.Endpoints;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class ProgressBarTest extends BaseTest {

    @Test(description = "Test progress bar reaches 52% and stops")
    public void progressBarTest() throws InterruptedException {

        browserHelper.open("https://demoqa.com/progress-bar");


        webElementActions.click(progressBarPage.startStopButton);

        String valueNow;

        while(true){
            valueNow = progressBarPage.aria_valuenow.getAttribute("aria-valuenow");
            if (valueNow.equals("52")){
                webElementActions.click(progressBarPage.startStopButton);
                break;

            }
        }

Assert.assertEquals(valueNow, "52");

    }
}
