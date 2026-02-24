package com.ait.tests.core;

import org.openqa.selenium.WebDriver;          // главный интерфейс Selenium для управления браузером
import org.openqa.selenium.chrome.ChromeDriver; // реализация WebDriver именно для Google Chrome
import org.testng.annotations.AfterMethod;     // запускается после каждого @Test
import org.testng.annotations.BeforeMethod;    // запускается перед каждым @Test

import java.time.Duration;                     // для задания времени ожиданий

/*
    BaseTest — это "база" для всех тестов.

    Зачем он нужен:
    - чтобы НЕ копировать один и тот же код (ChromeDriver + maximize + waits + quit)
      в каждом тестовом классе.
    - чтобы все тесты запускались одинаково и предсказуемо.

    Как пользоваться:
    - любой тестовый класс делает:  public class MyTest extends BaseTest { ... }
    - driver будет доступен внутри тестов автоматически.
*/
public abstract class BaseTest {

    protected WebDriver driver; // protected → доступен в наследниках (в тест-классах)

    /*
        @BeforeMethod выполняется ПЕРЕД КАЖДЫМ тестом (@Test).

        Здесь мы:
        1) запускаем браузер
        2) приводим его в нормальное состояние (окно, ожидания)
     */
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(); // стартуем Chrome

        driver.manage().window().maximize(); // разворачиваем окно (меньше проблем с кликами и видимостью)

        // implicit wait — если элемент не найден сразу, Selenium будет ждать до 10 секунд
        // (полезно на первых уроках, когда ещё не проходили explicit wait)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /*
        @AfterMethod выполняется ПОСЛЕ КАЖДОГО теста (@Test).

        alwaysRun = true → браузер закроется даже если тест упал с ошибкой.
        Это важно, иначе останутся "зависшие" процессы Chrome и начнётся хаос.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // проверка на null — на случай, если браузер не успел стартануть
        if (driver != null) {
            driver.quit(); // закрывает все окна и завершает сессию WebDriver
        }
    }
}