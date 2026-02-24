package homeworks.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindElementsLocatorsTests {

    /*
        Homework (Lesson 13)
        Site: https://demowebshop.tricentis.com/

        Requirements:
        1) Browser window is maximized (or fixed size 1920x1080).
        2) Implicit wait is set.
        3) Use findElement with:
           - id
           - className
           - linkText
           - partialLinkText
           - cssSelector
        4) Print text or some attribute value for each found element.
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
    public void findElementById() {
        WebElement searchInput = driver.findElement(By.id("small-searchterms"));
        System.out.println("Search input id: " + searchInput.getAttribute("id"));

        WebElement newsletterEmail = driver.findElement(By.id("newsletter-email"));
        System.out.println("Newsletter email id: " + newsletterEmail.getAttribute("id"));
    }

    @Test
    public void findElementByClassName() {
        WebElement searchButton = driver.findElement(By.className("search-box-button"));
        System.out.println("Search button value: " + searchButton.getAttribute("value"));

        WebElement headerLinks = driver.findElement(By.className("header-links"));
        System.out.println("Header links text: " + headerLinks.getText());
    }

    @Test
    public void findElementByLinkText() {
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        System.out.println("Register link: " + registerLink.getText());

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        System.out.println("Login link: " + loginLink.getText());
    }

    @Test
    public void findElementByPartialLinkText() {
        WebElement cartLink = driver.findElement(By.partialLinkText("cart"));
        System.out.println("Cart link: " + cartLink.getText());

        WebElement wishListLink = driver.findElement(By.partialLinkText("Wish"));
        System.out.println("Wish list link: " + wishListLink.getText());
    }

    @Test
    public void findElementByCssSelector() {
        WebElement anyH2 = driver.findElement(By.cssSelector("h2"));
        System.out.println("H2: " + anyH2.getText());

        WebElement searchInput = driver.findElement(By.cssSelector("#small-searchterms"));
        System.out.println("Search input id: " + searchInput.getAttribute("id"));

        WebElement searchButton = driver.findElement(By.cssSelector(".search-box-button"));
        System.out.println("Search button value: " + searchButton.getAttribute("value"));

        WebElement registerByHref = driver.findElement(By.cssSelector("[href='/register']"));
        System.out.println("Href '/register': " + registerByHref.getText());

        WebElement hrefContainsLogin = driver.findElement(By.cssSelector("[href*='login']"));
        System.out.println("Contains 'login': " + hrefContainsLogin.getText());

        WebElement hrefStartsBooks = driver.findElement(By.cssSelector("[href^='/books']"));
        System.out.println("Starts with '/books': " + hrefStartsBooks.getText());

        WebElement hrefEndsCart = driver.findElement(By.cssSelector("[href$='cart']"));
        System.out.println("Ends with 'cart': " + hrefEndsCart.getText());

        WebElement loginComposite = driver.findElement(By.cssSelector("a.ico-login[href='/login']"));
        System.out.println("Composite login: " + loginComposite.getText());

        WebElement logoImage = driver.findElement(By.cssSelector(".header-logo > a > img"));
        System.out.println("Logo src: " + logoImage.getAttribute("src"));

        WebElement firstTopMenuItem = driver.findElement(By.cssSelector("ul.top-menu > li:nth-child(1)"));
        System.out.println("Top menu item #1: " + firstTopMenuItem.getText());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}