
import drivers.DriverManager;
import helper.AlertHelper;
import helper.BrowserHelper;
import helper.IframeHelper;
import helper.WebElementActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeSuite;
import pages.*;
import utils.RandomUtils;


public class BaseTest {

    protected WebDriver driver;
    protected TextBoxPage textBoxPage;
    protected PracticeFormPage practiceFormPage;
    protected RandomUtils randomUtils;
    protected AlertPage alertPage;
    protected WebElementActions webElementActions;
    protected AlertHelper alertHelper;
    protected BrowserHelper browserHelper;
    protected ButtonsPage buttonsPage;
    protected MenuPage menuPage;
    protected ProgressBarPage progressBarPage;
    protected WebTablePage webTablePage;
    protected IframeHelper iframeHelper;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        driver = DriverManager.getDriver();
        textBoxPage = new TextBoxPage();
        randomUtils = new RandomUtils();
        practiceFormPage = new PracticeFormPage();
        alertPage = new AlertPage();
        webElementActions = new WebElementActions();
        alertHelper = new AlertHelper(driver);
        browserHelper = new BrowserHelper(driver);
        buttonsPage = new ButtonsPage();
        menuPage = new MenuPage();
        progressBarPage = new ProgressBarPage();
        webTablePage = new WebTablePage();
        iframeHelper = new IframeHelper(driver);

    }

    @BeforeClass(alwaysRun = true)
    public void setUp1() {
        driver = DriverManager.getDriver();
        textBoxPage = new TextBoxPage();
        randomUtils = new RandomUtils();
        practiceFormPage = new PracticeFormPage();
        alertPage = new AlertPage();
        webElementActions = new WebElementActions();
        alertHelper = new AlertHelper(driver);
        browserHelper = new BrowserHelper(driver);
        buttonsPage = new ButtonsPage();
        menuPage = new MenuPage();
        progressBarPage = new ProgressBarPage();
        webTablePage = new WebTablePage();
        iframeHelper = new IframeHelper(driver);

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
