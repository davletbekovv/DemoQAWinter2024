package com.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class NambaFoodOrder {

    WebDriver driver;

    @BeforeMethod
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Azamat Davletbekov\\IdeaProjects\\DemoQAwinter24\\src\\main\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

//    @AfterMethod
//    void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @Test
    void NambaFoodOrderTest() {

        driver.get("https://nambafood.kg/python-bar-coffee");


        WebElement addDishButton = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'bay_item')]\n"));
        addDishButton.click();


        try {
            Thread.sleep(2000); // Replace with WebDriverWait for better practice
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement basketLink = driver.findElement(By.xpath("//a[@href='/python-bar-coffee/make-order' and contains(@class, 'basket') and contains(@class, 'tk-basket')]"));
        basketLink.click();


        driver.get("https://nambafood.kg/python-bar-coffee/checkout");

        WebElement fullName = driver.findElement(By.id("food_order_client_name"));
        fullName.sendKeys("Айганбек Мээримбеков");

        WebElement address = driver.findElement(By.id("food_order_address"));
        address.sendKeys("Абдумомунова 222");

        WebElement doorFloor = driver.findElement(By.id("food_order_door_code"));
        doorFloor.sendKeys("1, 21");

        WebElement phone = driver.findElement(By.id("food_order_phone"));
        phone.sendKeys("0550334566");

        WebElement addInfo = driver.findElement(By.id("food_order_additional_info"));
        addInfo.sendKeys("Телефон может взять жена по имени Мээрим пожалуйста скажите что это заказал Залкарбек ее муж, заранее спасибо");

        WebElement change = driver.findElement(By.id("food_order_money_change"));
        change.sendKeys("2000");

        WebElement submitButton = driver.findElement(By.id("payment_cash"));
        submitButton.click();
    }
}
