package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SuggestionsPage {

    public SelenideElement carName = $("h1");

    public String getCarModel() {
        return carName.text().split("\n")[0];
    }
}
