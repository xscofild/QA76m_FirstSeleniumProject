package com.ait.tests.homeworks.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HW_12_FindElementsByTagNameTests {

    /*
        Homework (Lesson 12)
        Site: https://demowebshop.tricentis.com/

        Requirements:
        1) Browser window is maximized.
        2) Implicit wait is set.
        3) Use findElement to locate one element and print its text.
        4) Use findElements to locate a list of elements.
        5) Print size and text of found elements.
        6) Use up to 10 different tagName locators.
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementsByTagNameTest() {

        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println("Single h2 text: " + h2.getText());

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
        if (driver != null) driver.quit();
    }
}