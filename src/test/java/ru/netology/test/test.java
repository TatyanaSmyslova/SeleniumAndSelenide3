package ru.netology.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
    private static WebDriver driver;

    @BeforeAll
    static void setUpAll(){
        System.setProperty("webdriver.chrome.driver", "driver/win/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    void test1(){
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id='name'] input")).sendKeys("Смыслова Татьяна");
        driver.findElement(By.cssSelector("span[data-test-id='phone'] input")).sendKeys("+79649971830");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button_view_extra")).click();
        String text = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

    @AfterEach
    void tearDown(){
        driver.quit();
        driver = null;
    }
}