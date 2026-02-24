package com.ait.tests.locators.icarro;

import com.ait.tests.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/*
    Этот класс показывает работу с локаторами для ссылок:

    1) linkText — поиск по ТОЧНОМУ тексту ссылки
    2) partialLinkText — поиск по ЧАСТИ текста ссылки
*/
public class _02_LinkTextLocatorsTests extends BaseTest {

    /*
        Перед каждым тестом открываем страницу.
        Браузер создаётся в BaseTest.
     */
    @BeforeMethod
    public void openIcarro() {
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
    }

    /*
        linkText ищет ссылку <a> по полному совпадению текста.

        Важно:
        Текст должен совпадать полностью.
        Если изменится хотя бы один символ — тест упадёт.
     */
    @Test
    public void findElementByLinkText() {

        // ищем ссылку с текстом "Let car work"
        WebElement letCarWork = driver.findElement(By.linkText("Let car work"));

        // проверяем, что текст действительно совпадает
        assertEquals(letCarWork.getText().trim(), "Let car work");

        // проверяем, что ссылка отображается на странице
        assertTrue(letCarWork.isDisplayed());
    }

    /*
        partialLinkText ищет ссылку по части текста.

        Удобно, если:
        - текст длинный
        - текст может немного меняться
        - нужен гибкий поиск
     */
    @Test
    public void findElementByPartialLinkText() {

        // ищем любую ссылку, в тексте которой есть слово "work"
        WebElement work = driver.findElement(By.partialLinkText("work"));

        /*
            contains("work") проверяет,
            что в тексте действительно есть слово "work"
         */
        assertTrue(work.getText().toLowerCase().contains("work"));

        // проверяем, что ссылка видна
        assertTrue(work.isDisplayed());
    }
}