package drivers;

import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getValue("browser").toLowerCase()) {
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "firefox":
                    // you need to add drivers for firefox anf others
                    break;
                default:
                    throw new IllegalArgumentException("you have provided Wrong Driver name");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
e.printStackTrace();
            System.err.println("Error while closing driver");
        }
    }
}
