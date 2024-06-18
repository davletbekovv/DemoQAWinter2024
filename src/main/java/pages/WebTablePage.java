package pages;


import drivers.DriverManager;
import entities.Employee;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class WebTablePage extends BasePage {


    @FindBy(id = "addNewRecordButton")
    public WebElement addNewBtn;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "age")
    public WebElement ageInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "salary")
    public WebElement salaryInput;

    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    @FindBy(id = "delete-record-4")
    public WebElement deleteBtn;

@Step("Add new employee {0}")
    public WebTablePage addNewEmployee(Employee employee) throws Exception {


        webElementActions.click(addNewBtn)
                .sendKeys(firstNameInput, employee.getFirstname())
                .sendKeys(lastNameInput, employee.getLastname())
                .sendKeys(ageInput, String.valueOf(employee.getAge()))
                .sendKeys(emailInput, employee.getEmail())
                .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
                .sendKeys(departmentInput, employee.getDepartment())
                .click(submitBtn);

        if (isEmailExists(employee.getEmail())) {
Thread.sleep(4000);
webElementActions.click(deleteBtn);
Thread.sleep(4000);
            try{
                throw new Exception ("There are no duplicates");
            }catch (Exception e){
            System.err.println("Email already exists: " + employee.getEmail() + " so this user was deleted from list");
            }
        }
        return this;
    }

    private boolean isEmailExists(String email) {
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            if (cells.get(3).getText().equals(email)) {
                return true;
            }
        }
        return false;

    }

    public ArrayList<Employee> getEmployeesFromTable() {
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        ArrayList<Employee> employees = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));

            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty()
                    || salaryText.isEmpty() || department.isEmpty()) {

                continue;
            }

            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim());

            employees.add(new Employee(firstName, lastName, age, email, salary, department));

        }

        return employees;
    }
}
