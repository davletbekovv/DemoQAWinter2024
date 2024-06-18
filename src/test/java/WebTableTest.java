import entities.Employee;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.util.List;

public class WebTableTest extends BaseTest{

    @Test(description = "WebTableTest")
    public void test123() throws Exception {
        browserHelper.open(ConfigReader.getValue("baseURL"));
        webTablePage.addNewEmployee(randomUtils.createMockEmployee());
        Thread.sleep(4000);
        List<Employee> employees = webTablePage.getEmployeesFromTable();
Thread.sleep(4000);
        for (Employee employee: employees){
            System.out.println(employee);
        }
    }
}
