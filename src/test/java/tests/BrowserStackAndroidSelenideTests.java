package tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class BrowserStackAndroidSelenideTests extends TestBase {

    @Test
    void searchTest() {
        step("Enter search query", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        });
        step("Verify search results", () -> {
            $$(MobileBy.id("org.wikipedia.alpha:id/search_container")).shouldHave(CollectionCondition.sizeGreaterThan(0));
        });
    }

    @Test
    void myListsEmptyStateTest() {
        step("Click 'My lists' icon", () -> {
            $(MobileBy.AccessibilityId("My lists")).click();
        });
        step("Check empty state text", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/empty_title")).shouldHave(text("No reading lists yet"));
        });
    }
}
