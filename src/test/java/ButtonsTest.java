import drivers.DriverManager;
import enums.Endpoints;
import helper.BrowserHelper;
import helper.WebElementActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class ButtonsTest extends BaseTest{

    @Test(description = "Verify double click button is working properly")
    public void doubleClickTest(){
        browserHelper.open(ConfigReader.getValue("baseURL")+ Endpoints.BUTTONS.getEndpoint());
        webElementActions.doubleClick(buttonsPage.doubleClickBtn);
        Assert.assertEquals(buttonsPage.doubleClickMessage.getText(), "You have done a double click");
    }

    @Test(description = "Verify right click button is working properly" )

    public void rightClickTest(){
        browserHelper.open(ConfigReader.getValue("baseURL")+Endpoints.BUTTONS.getEndpoint());
        webElementActions.rightClick(buttonsPage.rightClickBtn);
        Assert.assertEquals(buttonsPage.rightClickMessage.getText(), "You have done a right click");
    }


}
