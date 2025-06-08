package com.example;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SelenideRepositorySearch {

    @BeforeAll
    static void setUp() {
        String browser = System.getProperty("browser", "firefox");
        Configuration.browser = browser;
        Configuration.browserSize = "1920x1080";


        switch (browser) {
            case "firefox" -> WebDriverManager.firefoxdriver().setup();
            //case "edge"    -> WebDriverManager.edgedriver().setup();
            //case "opera"   -> WebDriverManager.operadriver().setup();
            //default        -> WebDriverManager.chromedriver().setup();
        }
    }
        @Test
        void shouldFindSelenideRepositoryAtTheTop() {
            open("https://github.com/");
            $("span.flex-1").click();
            $("#query-builder-test").setValue("selenide").pressEnter();
            $$("[data-testid=results-list]").first().$("a").click();
            $("#repository-container-header").shouldHave(text("selenide / selenide"));


        }

}
