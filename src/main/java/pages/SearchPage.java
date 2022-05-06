package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final String URL = "https://yandex.ru/";
    public SelenideElement searchTextbox = $("input#text");
    public SelenideElement searchButton = $("button.button_theme_search");

    public void open() {
        Selenide.open(URL);
    }

    public SearchResultPage search(String searchQuery) {
        searchTextbox.sendKeys(searchQuery);
        searchButton.click();

        return new SearchResultPage();
    }
}
