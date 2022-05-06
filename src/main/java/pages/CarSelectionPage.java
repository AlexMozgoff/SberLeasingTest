package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CarSelectionPage {

    public SelenideElement selectCarByParameters = $("a.sbl-btn_accent");

    public CarParametersPage openParametersPage() {
        selectCarByParameters.click();

        return new CarParametersPage();
    }
}
