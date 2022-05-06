package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SelectionResultsPage {

    public SelenideElement firstResult = $x("//a[contains(@class, 'car-card__item-title')]");

    public List<String> getResultCarModels() {
        return $$x("//a[contains(@class, 'car-card__item-title')]/div/div").texts();
    }

    public SuggestionsPage showSuggestions() {
        firstResult.click();

        return new SuggestionsPage();
    }
}
