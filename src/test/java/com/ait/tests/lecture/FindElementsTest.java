package com.ait.tests.lecture;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTest {

    WebDriver driver; // общий драйвер для всего класса

    @BeforeMethod //20.02.26
    public void setUp() {
        driver = new ChromeDriver(); // запуск браузера
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10"); // открытие тестовой страницы

        // управление окном браузера
        // driver.manage().window().maximize();   максимизация окна
        // driver.manage().window().fullscreen();  полноэкранный режим
        driver.manage().window().setSize(new Dimension(1920, 1080)); // установка размера вручную

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // implicit wait — глобальное ожидание поиска элемента до 10 секунд
        // explicit wait — ожидание конкретного элемента до определенного состояния (видимость, кликабельность и т.д.)

        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); ожидание загрузки страницы до 10 секунд
    }

    @Test //20.02.26
    public void findElementByTagNameTest() {

        // findElement — ищет первый найденный элемент
        WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println("H1 text: " + h1.getText());

        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println("H2 text: " + h2.getText());

        WebElement firstLink = driver.findElement(By.tagName("a"));
        System.out.println("First <a>: " + firstLink.getText());

        WebElement firstLabel = driver.findElement(By.tagName("label"));
        System.out.println("First <label>: " + firstLabel.getText());

        // findElements — возвращает список всех найденных элементов
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links: " + links.size());

        List<WebElement> labels = driver.findElements(By.tagName("label"));
        System.out.println("Total labels: " + labels.size());
    }

    @Test // 23.02.26 - 1
    public void findElementById() {
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getAttribute("id"));

    }

    @Test // 23.02.26 - 2
    public void findElementByClassName() {
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println("Telephone: " + telephone.getText());

        WebElement description = driver.findElement(By.className("description"));
        System.out.println("Description: " + description.getText());

    }

    @Test // 23.02.26 - 3
    public void findElementByLinkText() {
        WebElement letCarWork = driver.findElement(By.linkText("Let car work"));
        System.out.println("Link text: " + letCarWork.getText());
    }

    @Test // 23.02.26 - 4
    public void findElementByPartialLinkText() {
        WebElement work = driver.findElement(By.partialLinkText("work"));
        System.out.println("Partial link text: " + work.getText());
    }

    @Test // 23.02.26 - 5
    public void findElementByCssSelector() {

        // tag name 'h1' → css 'h1'
        WebElement h1 = driver.findElement(By.cssSelector("h1"));
        System.out.println("H1: " + h1.getText());

        // id 'city' → css '#city'
        WebElement city = driver.findElement(By.cssSelector("#city"));
        System.out.println("City id: " + city.getAttribute("id"));

        // class 'telephone' → css '.telephone'
        WebElement telephone = driver.findElement(By.cssSelector(".telephone"));
        System.out.println("Telephone: " + telephone.getText());

        // first link → css 'a'
        WebElement firstLink = driver.findElement(By.cssSelector("a"));
        System.out.println("First link: " + firstLink.getText());

        // [attribute='parameter'] - поиск элемента по атрибуту и его значению
        WebElement element = driver.findElement(By.cssSelector("[href='/search']"));
        System.out.println("Element with href='/search': " + element.getText());

        WebElement element1 = driver.findElement(By.cssSelector("[for='city']"));
        System.out.println("Element with for='city': " + element1.getText());

        // contains -> *   [href*='car']
        WebElement linkContainingCar = driver.findElement(By.cssSelector("[href*='car']"));
        System.out.println("Contains 'car': " + linkContainingCar.getText());

        // start -> ^   [href^='/let']
        WebElement linkStartingWithLet = driver.findElement(By.cssSelector("[href^='/let']"));
        System.out.println("Starts with '/let': " + linkStartingWithLet.getText());

        // end -> $   [href$='work']
        WebElement linkEndingWithWork = driver.findElement(By.cssSelector("[href$='work']"));
        System.out.println("Ends with 'work': " + linkEndingWithWork.getText());

        // composite cssSelector (tag + class + attribute)
        WebElement loginLink = driver.findElement(By.cssSelector("a.navigation-link[href='/login']"));
        System.out.println("Login link: " + loginLink.getText());

        // composite cssSelector (tag + class)
        WebElement socialNetworksBlock = driver.findElement(By.cssSelector("div.social-networks"));
        System.out.println("Social networks block found" + socialNetworksBlock.getText());

        // one step below (direct child)
        WebElement logoImage = driver.findElement(By.cssSelector(".logo > img"));
        System.out.println("Logo image found" + logoImage.getAttribute("src"));

        // <tag> or <id> or <class>:nth-child(n)
        WebElement firstSearchContainer = driver.findElement(By.cssSelector(".search-container:nth-child(1)"));
        System.out.println(firstSearchContainer.getText());

    }

    //xpath - 24.02.26 - 1
    @Test
    public void findElementByXpath() {
        // //some_tag
        // ищем элемент по тегу
        // // → поиск по всей странице
        // some_tag → имя HTML-тега
        driver.findElement(By.xpath("//h1"));


        // //some_tag[@attr='value']
        // поиск по тегу + атрибуту
        // @ → обращение к атрибуту
        // [ ] → условие
        // используется для точного поиска конкретного элемента
        driver.findElement(By.xpath("//input[@id='city']"));


        // //*[@attr='value']
        // поиск только по атрибуту (любой тег)
        // * → любой тег
        // удобно, если тег неизвестен
        driver.findElement(By.xpath("//*[@id='city']"));


        // //some_tag[1]
        // выбор первого элемента по тегу
        // индексация в XPath начинается с 1
        driver.findElement(By.xpath("//a[1]"));


        // //some_tag[text()='Title']
        // точное совпадение текста
        // text() → текст внутри элемента
        // используется, когда нужно строгое сравнение
        driver.findElement(By.xpath("//a[text()='Let car work']"));


        // //*[starts-with(@attr,'value')]
        // значение атрибута начинается с указанной строки
        // используется для динамических ссылок или id
        driver.findElement(By.xpath("//*[starts-with(@href,'/let')]"));


        // //*[contains(text(),'some text')]
        // частичное совпадение текста
        // удобно, если текст длинный или меняется
        driver.findElement(By.xpath("//*[contains(text(),'best services')]"));


        // //*[text()='some text']
        // точное совпадение текста
        // работает только при полном совпадении строки
        driver.findElement(By.xpath("//*[text()='Find your car now!']"));


        // tag.class[attr='value']
        // CSS: тег + класс + атрибут
        // короче и читаемее, чем XPath
        driver.findElement(By.cssSelector("a.navigation-link[href='/login']"));


        // //some_tag[@attr='value'][@attr2='value2']
        // несколько условий одновременно (AND)
        // элемент должен соответствовать всем условиям
        driver.findElement(By.xpath("//a[@class='navigation-link'][@href='/login']"));


        // //*[contains(@class,'logo')]/img
        // поиск дочернего элемента
        // /img → прямой потомок
        // используется для вложенных элементов
        driver.findElement(By.xpath("//*[contains(@class,'logo')]/img"));

        // //*[contains(@class,'parent')]//*[contains(@class,'child')]
        // поиск вложенного элемента
        // первая часть → родительский элемент
        // // → поиск на любом уровне вложенности
        // вторая часть → дочерний элемент
        driver.findElement(By.xpath("//*[contains(@class,'feedback-card')]//*[contains(@class,'feedback-date')]"));


    }
    // cssSelector  -> div > a      xPath -> //div/a
    // >  (CSS)  → прямой потомок
    // /  (XPath) → прямой потомок


    // cssSelector  -> div a        xPath -> //div//a
    // пробел (CSS) → любой уровень вложенности
    // // (XPath)   → любой уровень вложенности

    // ===== XPath cheat sheet =====
    // //  → поиск по всей странице
    // @   → обращение к атрибуту
    // [ ] → условие (фильтр)
    // text() → точное совпадение текста
    // contains() → частичное совпадение
    // starts-with() → значение начинается с
    // несколько [ ] → логическое AND
    // /   → прямой потомок
    // //  → любой уровень вложенности


    @AfterMethod(enabled = true) //23.02.26
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}