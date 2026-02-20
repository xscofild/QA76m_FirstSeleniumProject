package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTest {

    WebDriver driver; // общий драйвер для всего класса

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(); // запуск браузера
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10"); // открытие тестовой страницы

        // управление окном браузера
        // driver.manage().window().maximize();   максимизация окна
        // driver.manage().window().fullscreen();  полноэкранный режим
        driver.manage().window().setSize(new Dimension(1920, 1080)); // установка размера вручную

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // implicit wait — глобальное ожидание поиска элемента до 10 секунд
        // explicit wait — ожидание конкретного элемента до определенного состояния (видимость, кликабельность и т.д.)

        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); ожидание загрузки страницы до 10 секунд
    }

    @Test
    public void findElementByTagNameTest() {

        // findElement — ищет первый найденный элемент
        WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println("H1 text: " + h1.getText());

        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println("H2 text: " + h2.getText());

        WebElement firstLink = driver.findElement(By.tagName("a"));
        System.out.println("First <a>: " + firstLink.getText());

        WebElement firstLabel = driver.findElement(By.tagName("label"));
        System.out.println("First <label>: " + firstLabel.getText());

        // findElements — возвращает список всех найденных элементов
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links: " + links.size());

        List<WebElement> labels = driver.findElements(By.tagName("label"));
        System.out.println("Total labels: " + labels.size());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit(); // завершение сессии WebDriver
    }
}