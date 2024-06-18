package com.demoqa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BasicLocators {

    @Test(description = "Find by ID")
    void findByIdTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Azamat Davletbekov\\IdeaProjects\\DemoQAwinter24\\src\\main\\resources\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/category/11");
        System.out.println("\t Список всех кафе Бишкека\n");
        List<WebElement> cafeList = driver.findElements(By.xpath("//div[@class='panel-heading']"));
        cafeList.forEach(cafe -> System.out.println(cafe.getText() + "\n-----------------------------------"));

        cafeList.stream().filter(cafe -> cafe.getText().equals("KFC Орто-Сай\n" +
                "ул. Юнусалиева, 185")).findFirst().ifPresent(cafe -> {
            WebElement menu = driver.findElement(By.xpath("//*[@id=\"WWMainPage\"]/div[2]/div[2]/div/div[2]/div[2]/a"));
            menu.click();

            everyPosition(driver, "//*[@id=\"WWMainPage\"]/div[1]", "Комбо\n");
            everyPosition(driver, "//*[@id=\"WWMainPage\"]/div[2]", "Баскет\n");
            everyPosition(driver, "//*[@id=\"WWMainPage\"]/div[3]", "Бургеры\n");
            everyPosition(driver, "//*[@id=\"WWMainPage\"]/div[4]", "Сэндвичи\n");
            everyPosition(driver, "//*[@id=\"WWMainPage\"]/div[5]", "Курочка\n");
            everyPosition(driver, "//*[@id=\"WWMainPage\"]/div[6]", "Снэки\n");
            everyPosition(driver, "//*[@id=\"WWMainPage\"]/div[7]", "Соусы\n");
            everyPosition(driver, "//*[@id=\"WWMainPage\"]/div[8]", "Холодные напитки\n");
            everyPosition(driver, "//*[@id=\"WWMainPage\"]/div[9]", "Горячие напитки\n");
            everyPosition(driver, "//*[@id=\"WWMainPage\"]/div[10]", "Допы\n");
            everyPosition(driver, "//*[@id=\"WWMainPage\"]/div[11]", "Десерты\n");
        });
driver.close();
        driver.quit();
    }

    private void everyPosition(WebDriver driver, String xpath, String sectionName) {
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        elements.forEach(element -> System.out.println(sectionName + "\n" + element.getText() + "\n\n------------------------------"));
    }
}
