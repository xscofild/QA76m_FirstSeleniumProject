package com.ait.tests.lecture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementInTable {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void findCssSelectorInTable() {
        // get number of rows in the table
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println("Number of rows in the table: " + rows.size());

        System.out.println("-----------------------------");

        // using for loop to get all elements in the table
        System.out.println("All elements in the table:");
        for (int i = 0; i < rows.size(); i++) {
            System.out.println(i + 1 + ". " + rows.get(i).getText());
            System.out.println("-----------------------------");
        }

        System.out.println("-----------------------------");

        System.out.println("Using for each loop to get all elements in the table:");

        // using for each loop to get all elements in the table
        for (WebElement element : rows) {
            System.out.println(element.getText());
        }

        // get row 4 by using css selector
        WebElement row4 = driver.findElement(By.cssSelector("tr:nth-child(4)"));
        System.out.println("Row 4: " + row4.getText());

        System.out.println("-----------------------------");

        // get row 4, last element by using css selector td:last-child
        WebElement row4LastElement = driver.findElement(By.cssSelector("tr:nth-child(5) td:last-child"));
        System.out.println("Row 4, last element: " + row4LastElement.getText());

        System.out.println("-----------------------------");

        // get row 4, first element by using css selector td:nth-child(3)
        WebElement row4FirstElement = driver.findElement(By.cssSelector("tr:nth-child(5) td:nth-child(3)"));
        System.out.println("Row 4, first element: " + row4FirstElement.getText());

    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
