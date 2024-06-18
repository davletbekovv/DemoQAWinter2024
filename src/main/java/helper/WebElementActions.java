package helper;


import com.beust.ah.A;
import drivers.DriverManager;
import io.qameta.allure.Step;
import lombok.Builder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebElementActions {

    Actions actions = new Actions(DriverManager.getDriver());

    @BeforeClass (alwaysRun = true)

    public void init(){
        actions = new Actions(DriverManager.getDriver());

    }
@Step("Performing click {1}")
    public WebElementActions click(WebElement element) {
        waitElementToBeClickable(element);
        scrollToElement(element);
        highlightElement(element);
        element.click();
        return this;
    }

    public WebElementActions sendKeys(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        highlightElement(element);
        element.sendKeys(txt);
        return this;
    }
    public WebElementActions sendKeysWithEnter(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        element.sendKeys(txt);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public WebElementActions waitElementToBeClickable(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }
    public WebElementActions waitElementToBeVisible(WebElement element){
        new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }
    public WebElementActions scrollToElement (WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public WebElementActions jsClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
       js.executeScript("arguments[0].click();", element);
        return this;

    }
    public WebElementActions highlightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].style.border='3px solid green'", element);
        return this;


    }

    public WebElementActions jsSendKeys (WebElement element, String txt){
        JavascriptExecutor js = (JavascriptExecutor)  DriverManager.getDriver();
        js.executeScript("arguments[0].value=arguments[1];", element, txt);
                return this;
    }

    public WebElementActions doubleClick (WebElement element){

        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        actions.doubleClick(element).perform();
        return this;
    }

    public WebElementActions rightClick (WebElement element){

        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        actions.contextClick(element).perform();

        return this;
    }
public WebElementActions moveToElement (WebElement element){

    waitElementToBeVisible(element);
    waitElementToBeClickable(element);
    actions.moveToElement(element).perform();

    return this;
}

public void pause (Integer seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
}
}
