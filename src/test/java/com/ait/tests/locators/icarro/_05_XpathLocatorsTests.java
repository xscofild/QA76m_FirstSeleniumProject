package com.ait.tests.locators.icarro;

import com.ait.tests.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/*
    XPath — более гибкий способ поиска элементов.

    Используется, когда:
    - нужно искать по тексту
    - нет удобных id или class
    - нужна сложная вложенность
*/
public class _05_XpathLocatorsTests extends BaseTest {

    @BeforeMethod
    public void openIcarro() {
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
    }

    @Test
    public void findElementByXpathCheatSheet() {

        /*
            //h1
            // → искать по всей странице
            h1 → тег
         */
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        assertTrue(h1.getText().trim().length() > 0);


        /*
            //input[@id='city']
            @ → обращение к атрибуту
            [ ] → условие
         */
        WebElement cityByTagAndAttr =
                driver.findElement(By.xpath("//input[@id='city']"));
        assertEquals(cityByTagAndAttr.getAttribute("id"), "city");


        /*
            //*[@id='city']
            * → любой тег
         */
        WebElement cityByAnyTagAttr =
                driver.findElement(By.xpath("//*[@id='city']"));
        assertEquals(cityByAnyTagAttr.getAttribute("id"), "city");


        /*
            //a[1]
            [1] → первый найденный элемент
            ВАЖНО: в XPath индексация начинается с 1
         */
        WebElement firstLink =
                driver.findElement(By.xpath("//a[1]"));
        assertTrue(firstLink.isDisplayed());


        /*
            text() → точное совпадение текста
         */
        WebElement letCarWork =
                driver.findElement(By.xpath("//a[text()='Let car work']"));
        assertEquals(letCarWork.getText().trim(), "Let car work");


        /*
            starts-with()
            атрибут начинается с значения
         */
        WebElement hrefStarts =
                driver.findElement(By.xpath("//*[starts-with(@href,'/let')]"));
        assertTrue(hrefStarts.isDisplayed());


        /*
            contains()
            частичное совпадение текста
         */
        WebElement containsText =
                driver.findElement(By.xpath("//*[contains(text(),'best services')]"));
        assertTrue(containsText.isDisplayed());


        /*
            точное совпадение текста
         */
        WebElement exactText =
                driver.findElement(By.xpath("//*[text()='Find your car now!']"));
        assertTrue(exactText.isDisplayed());


        /*
            Несколько условий (логическое AND)
         */
        WebElement loginLink =
                driver.findElement(By.xpath("//a[@class='navigation-link'][@href='/login']"));
        assertTrue(loginLink.isDisplayed());


        /*
            /  → прямой потомок
         */
        WebElement logoImg =
                driver.findElement(By.xpath("//*[contains(@class,'logo')]/img"));
        assertNotNull(logoImg.getAttribute("src"));


        /*
            // → любой уровень вложенности
         */
        WebElement nested =
                driver.findElement(By.xpath("//*[contains(@class,'feedback-card')]//*[contains(@class,'feedback-date')]"));
        assertTrue(nested.isDisplayed());
    }
}