package Homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsByTagNameTests {

    /*
        Домашнее задание:
        Сайт: https://demowebshop.tricentis.com/
        Реализовать тест, в котором:
            1. Окно браузера развернуто.
            2. Добавлен implicit wait.
            3. Через findElement найден один элемент и выведен его text.
            4. Через findElements найден список элементов.
            5. Выведены size и text элементов.
            6. Использовано до 10 различных tagName.
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementsByTagNameTest() {

        // findElement (один элемент)
        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println("Single h2 text: " + h2.getText());

        // findElements (списки)
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Links count: " + links.size());

        int printed = 0;

        for (WebElement el : links) {
            String text = el.getText();
            if (!text.isEmpty()) {
                printed++;
                System.out.println("Link text " + printed + ": " + text);
                if (printed == 3) break;
            }
        }

        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println("Input count: " + inputs.size());

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("Button count: " + buttons.size());

        List<WebElement> forms = driver.findElements(By.tagName("form"));
        System.out.println("Form count: " + forms.size());

        List<WebElement> divs = driver.findElements(By.tagName("div"));
        System.out.println("Div count: " + divs.size());

        List<WebElement> navs = driver.findElements(By.tagName("nav"));
        System.out.println("Nav count: " + navs.size());

        List<WebElement> spans = driver.findElements(By.tagName("span"));
        System.out.println("Span count: " + spans.size());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}