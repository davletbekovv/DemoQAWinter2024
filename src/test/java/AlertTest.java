import enums.Endpoints;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;

import org.testng.annotations.Test;
import utils.ConfigReader;

import static enums.Endpoints.ALERT;

public class AlertTest extends BaseTest {
    @Test(groups = {"Smoke", "UI", "1664"}, description = "Alert Test")
    @Description("Verify that alert is present")
    @Owner("Azamat")
    @Tag("Smoke")
    @Severity(SeverityLevel.CRITICAL)
    @Story("GCPINT-8877")
    @Epic("Registration")
    @Link("www.google.com")

    void alertTest() throws InterruptedException {
      browserHelper.open(ConfigReader.getValue("baseURL")+ ALERT.getEndpoint());
        webElementActions.click(alertPage.confirmAlertBtn);

        alertHelper.acceptAlert();
        webElementActions.pause(3);
        webElementActions.click(alertPage.promtBoxbtn);

        webElementActions.pause(5);


    }
//    @Test(groups = {"Regression", "API", "1454"}, description = "Alert Test 1")
//    void alertTest1() throws InterruptedException {
//        driver.get("https://demoqa.com/alerts");
//        webElementActions.click(alertPage.confirmAlertBtn);
//        Thread.sleep(3000);
//        alertHelper.acceptAlert();
//        Thread.sleep(3000);
//
//    }
//    @Test(groups = {"E2E", "SQL", "1574"}, description = "Alert Test 2")
//    void alertTest2() throws InterruptedException {
//        driver.get("https://demoqa.com/alerts");
//        webElementActions.click(alertPage.confirmAlertBtn);
//        Thread.sleep(3000);
//        alertHelper.acceptAlert();
//        Thread.sleep(3000);
//
//    }
}
