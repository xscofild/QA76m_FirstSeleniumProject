package com.ait.tests.homeworks.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW_14_FindElementsXpathTests {

    /*
        Homework (Lesson 14)

        Site: https://demowebshop.tricentis.com/

        Task:
        Rewrite CSS locators from Lesson 13
        using XPath instead of cssSelector.
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com/");
    }

    @Test
    public void findElementByXpath() {

        WebElement anyH2 = driver.findElement(By.xpath("//h2"));
        System.out.println("H2: " + anyH2.getText());

        WebElement searchInput = driver.findElement(By.xpath("//*[@id='small-searchterms']"));
        System.out.println("Search input id: " + searchInput.getAttribute("id"));

        WebElement searchButton = driver.findElement(By.xpath("//*[contains(@class,'search-box-button')]"));
        System.out.println("Search button value: " + searchButton.getAttribute("value"));

        WebElement registerByHref = driver.findElement(By.xpath("//*[@href='/register']"));
        System.out.println("Href '/register': " + registerByHref.getText());

        WebElement hrefContainsLogin = driver.findElement(By.xpath("//*[contains(@href,'login')]"));
        System.out.println("Contains 'login': " + hrefContainsLogin.getText());

        WebElement hrefStartsBooks = driver.findElement(By.xpath("//*[starts-with(@href,'/books')]"));
        System.out.println("Starts with '/books': " + hrefStartsBooks.getText());

        WebElement hrefEndsCart = driver.findElement(By.xpath("//*[substring(@href, string-length(@href) - string-length('cart') + 1) = 'cart']"));
        System.out.println("Ends with 'cart': " + hrefEndsCart.getText());

        WebElement loginComposite = driver.findElement(By.xpath("//a[contains(@class,'ico-login') and @href='/login']"));
        System.out.println("Composite login: " + loginComposite.getText());

        WebElement logoImage = driver.findElement(By.xpath("//*[contains(@class,'header-logo')]/a/img"));
        System.out.println("Logo src: " + logoImage.getAttribute("src"));

        WebElement firstTopMenuItem = driver.findElement(By.xpath("//ul[contains(@class,'top-menu')]/li[1]"));
        System.out.println("Top menu item #1: " + firstTopMenuItem.getText());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}