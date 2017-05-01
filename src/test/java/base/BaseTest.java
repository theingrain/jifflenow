package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Abc on 4/28/2017.
 */
public class BaseTest {
    protected static WebDriver driver;
    private DesiredCapabilities capabilities;

    @BeforeSuite
    public void setUp() throws IOException {
        capabilities = DesiredCapabilities.chrome();
        disableSavePasswordPrompt();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.get("https://calendar.google.com/calendar/render?tab=mc&pli=1#settings-general_11");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private BaseTest disableSavePasswordPrompt() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return this;
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}

