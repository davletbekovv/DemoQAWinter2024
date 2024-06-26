package pages;

import drivers.DriverManager;
import entities.PracticeFormEntity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PracticeFormPage extends BasePage {

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;


    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
    public WebElement genderMale;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")
    public WebElement genderFemale;
    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")
    public WebElement genderOther;


    @FindBy(id = "userNumber")
    public WebElement numberInput;

    @FindBy(className = "react-datepicker__input-container")
    public WebElement datePickerBtn;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;


    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")
    public WebElement hobbiesSport;
    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label")
    public WebElement hobbiesReading;
    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label")
    public WebElement hobbiesMusic;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "react-select-3-input")
    public WebElement stateInput;

    @FindBy(id = "react-select-4-input")
    public WebElement cityInput;


    @FindBy(id = "submit")
    public WebElement submitBtn;


    public final List<WebElement> hobbiesOptions = List.of(hobbiesSport, hobbiesReading, hobbiesMusic);
    public final List<WebElement> genderOptions = List.of(genderMale, genderFemale, genderOther);
    public final Random random = new Random();

    WebElement randomGender = genderOptions.get(random.nextInt(genderOptions.size()));
    WebElement randomHobbies = hobbiesOptions.get(random.nextInt(hobbiesOptions.size()));

    public PracticeFormPage fillUpPracticeForm(PracticeFormEntity practiceFormEntity) {
        webElementActions.sendKeys(firstNameInput, practiceFormEntity.getFirstName())
                .sendKeys(lastNameInput, practiceFormEntity.getLastName())
                .sendKeys(emailInput, practiceFormEntity.getEmail())
                .click(randomGender)
                .sendKeys(numberInput, practiceFormEntity.getMobilePhone())
                .sendKeysWithEnter(subjectsInput, practiceFormEntity.getSubjects())
                .click(randomHobbies)
                .sendKeys(currentAddressInput, practiceFormEntity.getCurrentAddress())
                .sendKeysWithEnter(stateInput, practiceFormEntity.getState())
                .sendKeysWithEnter(cityInput, practiceFormEntity.getCity())
                .jsClick(submitBtn);

        return this;
    }

    public PracticeFormPage selectDateMonthYear(String dateMonthYear) { //04 Jun 2024

        String[] dateMonthYearParts = dateMonthYear.split(" ");
        String date = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];

        webElementActions.click(datePickerBtn);

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        WebElement monthDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-select")));

        WebElement yearDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__year-select")));

        dropDownHelper.selectByVisibleText(monthDropDown, month)
                .selectByVisibleText(yearDropDown, year);


// //div[contains(@class,'react-datepicker__day') and not (contains(@class,'react-datepicker__day--outside-month')) and text() = '4']
        WebElement day = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(
                        "//div[contains(@class,'react-datepicker__day') and not (contains(@class,'react-datepicker__day--outside-month')) and text() = '" + date + "']"
                )));

        webElementActions.click(day);
        return this;


    }
}
