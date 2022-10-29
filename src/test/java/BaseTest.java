import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;


public class BaseTest {
    protected static WebDriver driver;
    DesiredCapabilities capabilities;
    ChromeOptions chromeOptions;


    @BeforeScenario
    public void setup() {
        if (StringUtils.isEmpty(System.getenv("key"))) {
            chromeOptions = new ChromeOptions();
            capabilities = DesiredCapabilities.chrome();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            chromeOptions.setExperimentalOption("prefs", prefs);
            chromeOptions.addArguments("--kiosk");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-translate");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--ignore-certificate-errors");
            chromeOptions.addArguments("--allow-insecure-localhost");
            chromeOptions.addArguments("--acceptInsecureCerts");
            chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
            chromeOptions.addArguments("--disable-extensions");
            System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.get("https://open.spotify.com/");
        } else {
            System.out.println("Burhan1925");
        }

    }

    @AfterScenario()
    public void tearDow() {
        driver.quit();
    }

}
