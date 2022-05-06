package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class CarSelectionAllParamsTest extends BaseTest {

    @Test(description = "Select a car using selection page with filling all parameters on it")
    public void carSelectionAllParamsTest() {
        SearchPage searchPage = new SearchPage();
        searchPage.open();

        SearchResultPage searchResultPage = searchPage.search("Сберлизинг");

        SberLeasingMainPage sberLeasingMainPage = searchResultPage.openSearchResultWithLink("www.SberLeasing.ru");

        CarSelectionPage carSelectionPage = sberLeasingMainPage.openCarSelectionPage();

        CarParametersPage carParametersPage = carSelectionPage.openParametersPage();
        carParametersPage.selectCity("Москва");
        carParametersPage.selectCarBrand("Volkswagen");
        carParametersPage.selectCarModel("Polo");
        carParametersPage.selectCarDrive("передний");
        carParametersPage.selectCarTransmission("механика");
        carParametersPage.selectCarBodyType("лифтбек");
        carParametersPage.selectCarFuelType("бензин");
        carParametersPage.selectCarColor("белый");

        SelectionResultsPage selectionResultsPage = carParametersPage.submit();
        List<String> results = selectionResultsPage.getResultCarModels();

        SuggestionsPage suggestionsPage = selectionResultsPage.showSuggestions();
        String carModel = suggestionsPage.getCarModel();

        for (String result : results) {
            Assert.assertEquals(carModel, result);
        }
    }
}
