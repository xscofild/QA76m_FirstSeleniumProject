package com.ait.tests.locators.icarro;

import com.ait.tests.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/*
    Этот класс проверяет базовые локаторы:
    1) id  — самый надёжный и быстрый способ найти элемент
    2) className — поиск по CSS-классу
*/
public class _01_BasicLocatorsTests extends BaseTest {

    /*
        Перед каждым тестом открываем нужную страницу.
        Браузер уже создан в BaseTest.
     */
    @BeforeMethod
    public void openIcarro() {
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
    }

    /*
        Поиск элемента по ID.

        ID — уникальный атрибут на странице.
        Если он есть — это лучший вариант локатора.
     */
    @Test
    public void findElementById() {

        // ищем поле "city" по id="city"
        WebElement city = driver.findElement(By.id("city"));

        // ищем поле "dates" по id="dates"
        WebElement dates = driver.findElement(By.id("dates"));

        /*
            Проверки (assert):

            assertEquals → сравнивает ожидаемое и фактическое значение
            assertTrue → проверяет, что условие равно true
         */

        // проверяем, что у найденного элемента действительно id="city"
        assertEquals(city.getAttribute("id"), "city");

        // проверяем id второго элемента
        assertEquals(dates.getAttribute("id"), "dates");

        // проверяем, что элементы отображаются на странице
        assertTrue(city.isDisplayed());
        assertTrue(dates.isDisplayed());
    }

    /*
        Поиск по className.

        class — это CSS-класс.
        Важно: если у элемента несколько классов,
        className работает только с одним (без пробелов).
     */
    @Test
    public void findElementByClassName() {

        // ищем блок с телефоном
        WebElement telephone = driver.findElement(By.className("telephone"));

        // ищем блок с описанием
        WebElement description = driver.findElement(By.className("description"));

        /*
            Проверяем, что текст внутри элементов не пустой.
            trim() убирает пробелы по краям.
            length() > 0 значит, что текст есть.
         */
        assertTrue(telephone.getText().trim().length() > 0);
        assertTrue(description.getText().trim().length() > 0);
    }
}