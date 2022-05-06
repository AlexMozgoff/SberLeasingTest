package pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.NotImplementedException;

import static com.codeborne.selenide.Selenide.$x;

public class CarParametersPage {

    public SelenideElement cityInput = $x("//label[@aria-label='Город']/input");
    public SelenideElement brandInput = $x("//label[@aria-label='Марка']/input");
    public SelenideElement modelInput = $x("//label[@aria-label='Модель']/input");
    public SelenideElement frontDriveCheckbox = $x("(//div[contains(text(), \"Привод\")]/..//label)[1]");
    public SelenideElement fullDriveCheckbox = $x("(//div[contains(text(), \"Привод\")]/..//label)[2]");
    public SelenideElement rearDriveCheckbox = $x("(//div[contains(text(), \"Привод\")]/..//label)[3]");
    public SelenideElement automaticTransmissionCheckbox =
            $x("(//div[contains(text(), \"Коробка передач\")]/..//label)[1]");
    public SelenideElement manualTransmissionCheckbox =
            $x("(//div[contains(text(), \"Коробка передач\")]/..//label)[2]");
    public SelenideElement liftbackBody = $x("//div[contains(text(), 'лифтбек')]");
    public SelenideElement gasolineFuelType = $x("(//div[contains(text(), 'Тип топлива')]/..//label)[2]");
    public SelenideElement colorDropdown = $x(
            "//div[contains(text(), 'Цвет')]/..//label[@class='horizontal-filter-block__selector-current-value']");
    public SelenideElement submitButton =
            $x("//a[contains(@class, 'horizontal-filter-block__find-button')]");

    public void selectCity(String city) {
        cityInput.click();
        cityInput.sendKeys(city);
        $x(String.format("//label[contains(text(), '%s')]", city)).click();
    }

    public void selectCarBrand(String brand) {
        brandInput.click();
        brandInput.sendKeys(brand);
        $x(String.format("//label[contains(text(), '%s')]", brand)).click();
    }

    public void selectCarModel(String model) {
        modelInput.click();
        modelInput.sendKeys(model);
        $x(String.format("//label[contains(text(), '%s')]", model)).click();
    }

    public void selectCarDrive(String drive) {
        switch (drive) {
            case "передний":
            {
                frontDriveCheckbox.click();
                break;
            }
            case "полный": {
                fullDriveCheckbox.click();
                break;
            }
            case "задний": {
                rearDriveCheckbox.click();
                break;
            }
        }
    }

    public void selectCarTransmission(String transmission) {
        switch (transmission) {
            case "автомат": {
                automaticTransmissionCheckbox.click();
                break;
            }
            case "механика": {
                manualTransmissionCheckbox.click();
                break;
            }
        }
    }

    public void selectCarBodyType(String bodyType) {
        switch (bodyType) {
            case "лифтбек": {
                liftbackBody.click();
                break;
            }
            default: throw new NotImplementedException("Not implemented yet");
        }
    }

    public void selectCarFuelType(String fuelType) {
        switch(fuelType) {
            case "бензин": {
                gasolineFuelType.click();
                break;
            }
            default: throw new NotImplementedException("Not implemented yet");
        }
    }

    public void selectCarColor(String color) {
        colorDropdown.click();
        $x(String.format("//label[contains(text(), '%s')]", color)).click();
    }

    public SelectionResultsPage submit() {
        submitButton.click();

        return new SelectionResultsPage();
    }
}
