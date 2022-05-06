package tests;

import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
