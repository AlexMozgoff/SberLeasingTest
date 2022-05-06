package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$x;

public class SearchResultPage {

    public SberLeasingMainPage openSearchResultWithLink(String URL) {
        $x(String.format("//a[@href='https://%s/']", URL)).click();

        Selenide.switchTo().window(1);
        $x("//a/img[@alt='Логотип АО «Сбербанк Лизинг»']").shouldBe(Condition.visible);

        closeCookieWindow();

        return new SberLeasingMainPage();
    }

    private void closeCookieWindow() {
        $x("//div[contains(@class, 'cookie-warning__group')]//button").click();
    }
}
