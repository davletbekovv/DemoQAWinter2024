package com.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBox {

    WebDriver driver;

    @BeforeMethod
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Azamat Davletbekov\\IdeaProjects\\DemoQAwinter24\\src\\main\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }

//     @AfterMethod
//   void tearDown() {
//        if (driver != null) {
//           driver.close();
//           driver.quit();
//       }
//    }

             @Test
             void textBoxTest() {
                 WebElement fullName = driver.findElement(By.id("userName"));
                 fullName.sendKeys("Azamat Davletbekov");

                 WebElement email = driver.findElement(By.id("userEmail"));
                 email.sendKeys("azamat.davletbekov@gmail.com");

                 WebElement currentAddress = driver.findElement(By.id("currentAddress"));
                 currentAddress.sendKeys("Moskovskaya 121");

                 WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
                 permanentAddress.sendKeys("Kainazarova, 11v, 26 appt.");

                 WebElement submitButton = driver.findElement(By.id("submit"));
                 submitButton.click();
             }
         }

