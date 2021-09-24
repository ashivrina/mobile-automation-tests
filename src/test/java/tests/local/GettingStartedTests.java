package tests.local;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class GettingStartedTests extends LocalTestBase {
    @Test
    void gettingStartedTest() {
        step("Check the first screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia\n" +
                            "…in over 300 languages"));
        });
        step("Click 'Continue'", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check the second screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
            $(MobileBy.id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldHave(text("Dive down the Wikipedia rabbit hole with a constantly updating Explore feed. " +
                            "Customize the feed to your interests – whether it’s learning about historical events " +
                            "On this day, or rolling the dice with Random."));
        });
        step("Click 'Continue'", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check the third screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
            $(MobileBy.id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldHave(text("You can make reading lists from articles you want to read later, even when " +
                            "you’re offline. Login to your Wikipedia account to sync your reading lists. " +
                            "Join Wikipedia"));
        });
        step("Click 'Continue'", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check the fourth screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
            $(MobileBy.id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldHave(text("Help make the app better by letting us know how you use it. Data collected is " +
                            "anonymous. Learn more"));
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).shouldBe(visible);
        });
    }
}
