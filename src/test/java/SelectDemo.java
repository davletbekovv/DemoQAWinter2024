import org.testng.annotations.Test;
import utils.ConfigReader;

public class SelectDemo extends BaseTest{

    @Test
    void test123(){
        browserHelper.open(ConfigReader.getValue("baseURL"));
    }
}
