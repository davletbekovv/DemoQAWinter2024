package pages;

import drivers.DriverManager;
import helper.DropDownHelper;
import helper.WebElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public WebElementActions webElementActions = new WebElementActions();

    public DropDownHelper dropDownHelper = new DropDownHelper(DriverManager.getDriver());
}
