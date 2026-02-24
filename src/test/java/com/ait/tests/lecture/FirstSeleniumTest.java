package com.ait.tests.lecture;

import org.openqa.selenium.WebDriver;          // интерфейс управления браузером
import org.openqa.selenium.chrome.ChromeDriver; // реализация для Chrome
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Правила именования:
// PascalCase  → FirstSeleniumTest (класс)
// camelCase   → openBrowser() (метод)
// snake_case  → open_browser (редко в Java)
// kebab-case  → open-browser (не используется в Java)

public class FirstSeleniumTest {

    WebDriver driver; // драйвер доступен во всём классе

    // before test - выполняется перед каждым тестом
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(); // запуск браузера
        driver.get("https://google.com"); // без истории
        // driver.navigate().to("https://google.com"); // с историей
        // driver.navigate().back(); -- переход назад
        // driver.navigate().forward(); -- переход вперёд
        // driver.navigate().refresh(); -- обновление страницы
        driver.manage().window().maximize(); // разворачиваем окно на весь экран
    }

    // test - тестовый метод
    @Test
    public void openBrowser() {
        System.out.println("Open Google"); // просто выводим сообщение в консоль
    }

    // after test - выполняется после каждого теста
    @AfterMethod(enabled = false) // отключаем выполнение
    public void tearDown() {
        driver.quit(); // Завершает всю сессию WebDriver
        // driver.close(); // Закрывает текущее окно
    }
}