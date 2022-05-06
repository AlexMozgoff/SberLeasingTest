package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SberLeasingMainPage {

    public SelenideElement leasingOptionsDropdown = $x("//a[@href='/leasing/']");
    public SelenideElement leasingCarOption = $x("//a[@href='/leasing/leasing-legkovykh-avtomobiley/']");

    public CarSelectionPage openCarSelectionPage() {
        leasingOptionsDropdown.hover();
        leasingCarOption.click();

        return new CarSelectionPage();
    }
}
