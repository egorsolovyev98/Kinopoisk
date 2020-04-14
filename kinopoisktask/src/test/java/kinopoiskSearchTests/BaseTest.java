package kinopoiskSearchTests;

import Allure.AllureSelenide;
import Driver.DriverFactory;
import Driver.DriverType;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    private final String HomePagePath = "https://www.kinopoisk.ru/";

    @BeforeClass
    public void defineDependencies()
    {
        DriverFactory.setupDriver(DriverType.CHROME);
        Configuration.baseUrl = HomePagePath;
    }

    @BeforeClass
    public void setUpAllure() throws Exception {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
