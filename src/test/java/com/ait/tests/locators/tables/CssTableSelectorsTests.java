package com.ait.tests.locators.tables;

import com.ait.tests.core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/*
    Работа с таблицей через CSS селекторы.

    Основная идея:
    1) Сначала ограничиваем поиск конкретной таблицей (#customers)
    2) Потом выбираем строки (tr)
    3) Потом конкретные ячейки (td)
*/
public class CssTableSelectorsTests extends BaseTest {

    @BeforeMethod
    public void openTablePage() {
        driver.get("https://www.w3schools.com/css/css_table.asp");
    }

    @Test
    public void tableRowsAndSpecificCells() {

        /*
            #customers tr

            #customers → таблица с id="customers"
            tr → все строки внутри неё

            Важно:
            Мы НЕ ищем просто "tr",
            иначе найдём строки со всей страницы.
         */
        List<WebElement> rows =
                driver.findElements(By.cssSelector("#customers tr"));

        // В таблице должна быть минимум 1 строка заголовков + 1 строка данных
        assertTrue(rows.size() > 1, "Expected header + at least 1 data row");


        /*
            rows.get(0) — первая строка.
            Это строка заголовков (Company | Contact | Country)
         */
        WebElement headerRow = rows.get(0);

        assertTrue(
                headerRow.getText().toLowerCase().contains("company")
        );


        /*
            nth-child(5)

            В таблице:
            1-я строка → заголовок
            2-я строка → первая компания
            3-я → вторая
            4-я → третья
            5-я → четвёртая компания

            Поэтому 5 — это 4-я data строка.
         */
        WebElement row4 =
                driver.findElement(By.cssSelector("#customers tr:nth-child(5)"));

        assertTrue(row4.getText().trim().length() > 0);


        /*
            td:last-child
            Берём последнюю ячейку строки
            (в этой таблице — это Country)
         */
        WebElement row4LastCell =
                driver.findElement(
                        By.cssSelector("#customers tr:nth-child(5) td:last-child")
                );

        assertTrue(row4LastCell.getText().trim().length() > 0);


        /*
            td:nth-child(3)

            3-я колонка:
            1 → Company
            2 → Contact
            3 → Country
         */
        WebElement row4ThirdCell =
                driver.findElement(
                        By.cssSelector("#customers tr:nth-child(5) td:nth-child(3)")
                );

        assertTrue(row4ThirdCell.getText().trim().length() > 0);
    }
}