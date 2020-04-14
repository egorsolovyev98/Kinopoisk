package Driver;

import com.codeborne.selenide.Configuration;

public class DriverFactory {

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_PATH = "src/main/resources/chromedriver.exe";
    private static final String FIREFOX_DRIVER = "webdriver.firefox.driver";
    private static final String FIREFOX_PATH = "src/main/resources/geckodriver.exe";

    public static void setupDriver(DriverType type) {

        switch (type) {
            case CHROME:
                System.setProperty(CHROME_DRIVER, CHROME_PATH);
                Configuration.browser = "chrome";
                break;
            case FIREFOX:
                System.setProperty(FIREFOX_DRIVER, FIREFOX_PATH);
                Configuration.browser = "firefox";
                break;
            default:
                break;
        }
    }
}
