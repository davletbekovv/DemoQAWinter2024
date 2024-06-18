import drivers.DriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;


public class WebDriverExceptionDemo {

    WebDriver driver = DriverManager.getDriver();


    @Test()
    void test123() {
        driver.get("https://demoqa.com/webtables");


        SessionId sessionID = ((RemoteWebDriver) driver).getSessionId();


        driver.close();
        driver.quit();


        System.out.println("After quit Session ID is : " + sessionID);
        driver.get("https://demoqa.com/webtables");

    }
}
