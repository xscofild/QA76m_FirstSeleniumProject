package com.ait.tests.locators.icarro;

import com.ait.tests.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/*
    CSS Selector — самый популярный и удобный способ поиска элементов.

    Почему его любят:
    - короче, чем XPath
    - читается проще
    - работает быстрее
*/
public class _04_CssSelectorLocatorsTests extends BaseTest {

    @BeforeMethod
    public void openIcarro() {
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
    }

    @Test
    public void findElementByCssSelector() {

        // Поиск по тегу (h1)
        WebElement h1 = driver.findElement(By.cssSelector("h1"));
        assertTrue(h1.getText().trim().length() > 0);

        // #city → поиск по id
        // # в CSS означает id
        WebElement city = driver.findElement(By.cssSelector("#city"));
        assertEquals(city.getAttribute("id"), "city");

        // .telephone → поиск по class
        // . в CSS означает class
        WebElement telephone = driver.findElement(By.cssSelector(".telephone"));
        assertTrue(telephone.getText().trim().length() > 0);

        /*
            [href='/search']
            Поиск по атрибуту и точному значению
         */
        WebElement elementByHref = driver.findElement(By.cssSelector("[href='/search']"));
        assertTrue(elementByHref.isDisplayed());

        /*
            *=  означает "содержит"
            [href*='car'] → значение href содержит "car"
         */
        WebElement linkContainingCar = driver.findElement(By.cssSelector("[href*='car']"));
        assertTrue(linkContainingCar.isDisplayed());

        /*
            ^= означает "начинается с"
            [href^='/let']
         */
        WebElement linkStartingWithLet = driver.findElement(By.cssSelector("[href^='/let']"));
        assertTrue(linkStartingWithLet.isDisplayed());

        /*
            $= означает "заканчивается на"
            [href$='work']
         */
        WebElement linkEndingWithWork = driver.findElement(By.cssSelector("[href$='work']"));
        assertTrue(linkEndingWithWork.isDisplayed());

        /*
            Комбинированный CSS:
            a.navigation-link[href='/login']

            a → тег
            .navigation-link → класс
            [href='/login'] → атрибут
         */
        WebElement loginLink =
                driver.findElement(By.cssSelector("a.navigation-link[href='/login']"));
        assertTrue(loginLink.isDisplayed());

        /*
            .logo > img

            > означает прямой потомок
            То есть img должен быть внутри .logo
            и быть именно дочерним элементом
         */
        WebElement logoImage =
                driver.findElement(By.cssSelector(".logo > img"));

        assertNotNull(logoImage.getAttribute("src"));
    }
}