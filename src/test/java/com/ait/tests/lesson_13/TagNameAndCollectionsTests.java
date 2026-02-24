package com.ait.tests.lesson_13;

import com.ait.tests.lesson_12.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/*
    Этот класс показывает разницу между:

    1) findElement()  — возвращает ОДИН элемент
    2) findElements() — возвращает СПИСОК элементов
*/
public class TagNameAndCollectionsTests extends BaseTest {

    // Перед каждым тестом открываем страницу
    @BeforeMethod
    public void openIcarro() {
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
    }

    /*
        tagName — поиск по HTML-тегу.

        Например:
        h1 — заголовок
        a  — ссылка
        label — подпись к input
     */
    @Test
    public void findElementByTagName() {

        // findElement вернёт ПЕРВЫЙ найденный h1
        WebElement h1 = driver.findElement(By.tagName("h1"));

        // findElement вернёт ПЕРВЫЙ найденный h2
        WebElement h2 = driver.findElement(By.tagName("h2"));

        /*
            Если элемент НЕ найден —
            findElement выбросит ошибку и тест упадёт.
         */

        // Проверяем, что внутри есть текст
        assertTrue(h1.getText().trim().length() > 0);
        assertTrue(h2.getText().trim().length() > 0);
    }

    /*
        findElements — возвращает список (List<WebElement>).

        Важно:
        - Если ничего не найдено → вернётся ПУСТОЙ список
        - Ошибки не будет
     */
    @Test
    public void findElementsByTagName() {

        // получаем список всех ссылок <a> на странице
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // получаем список всех label
        List<WebElement> labels = driver.findElements(By.tagName("label"));

        /*
            size() — количество элементов в списке

            Если элементов нет → size() будет 0
         */
        assertTrue(links.size() > 0, "There should be at least 1 link on the page");
        assertTrue(labels.size() > 0, "There should be at least 1 label on the page");
    }
}