# 🌱 QA76m_FirstSeleniumProject

Selenium WebDriver fundamentals — a learning project covering all major **locator strategies** and **basic browser interactions**.

> Companion project to the more advanced [QA76m_DemoQA_POM](https://github.com/xscofild/QA76m_DemoQA_POM) (POM architecture) and [QA76_PhonebookGUI](https://github.com/xscofild/QA76_PhonebookGUI) (framework-level).

---

## 🎯 What's Covered

| Topic | Tests |
|---|---|
| **Basic locators** | `id`, `name`, `className`, `tagName` |
| **CSS selectors** | Simple, hierarchical, attribute-based |
| **XPath** | Absolute, relative, axes, functions (`contains()`, `text()`) |
| **Link locators** | `linkText`, `partialLinkText` |
| **Collections** | `findElements()`, iterating lists |
| **CSS Table selectors** | Selecting cells, rows, columns |

---

## 🧰 Tech Stack

- **Java 17**
- **Selenium WebDriver 4.40.0**
- **TestNG 7.12.0**
- **Gradle**

---

## 🏗️ Project Structure

```
src/test/java/com/ait/tests/
├── lesson_12/
│   ├── BaseTest.java               # Shared driver setup
│   └── BasicLocatorsTests.java
├── lesson_13/
│   ├── LinkTextLocatorsTests.java
│   ├── CssSelectorLocatorsTests.java
│   └── TagNameAndCollectionsTests.java
├── lesson_14/
│   ├── XpathLocatorsTests.java
│   └── CssTableSelectorsTests.java
└── homeworks/
    └── demowebshop/
        └── HW_13_FindElementsLocatorsTests.java
```

---

## 🚀 How to Run

```bash
./gradlew test
```

---

## 📝 Notes

This project is intentionally **basic** — it's the foundation before moving to Page Object Model and framework-level architecture. For production-grade examples, see:

- [QA76m_DemoQA_POM](https://github.com/xscofild/QA76m_DemoQA_POM) — Page Object Model with fluent API
- [QA76_PhonebookGUI](https://github.com/xscofild/QA76_PhonebookGUI) — ApplicationManager framework, multi-browser, TestNG groups

---

## 🎓 Author

**Serdar Kerimov** — [github.com/xscofild](https://github.com/xscofild) · [LinkedIn](https://www.linkedin.com/in/serdarkerimov/)
QA Engineer | Java · Selenium · REST Assured · SQL
