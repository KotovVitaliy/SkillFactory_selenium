import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class SimpleTest {
    public RemoteWebDriver driver;

    private static final String SELENIUM_URL = "http://localhost:4444/wd/hub";

    @BeforeClass
    public void start() throws Exception {
        this.driver = new RemoteWebDriver(
                new URL(SELENIUM_URL),
                new ChromeOptions()
//                new FirefoxOptions()
        );
    }

    @Test
    public void simpleTest() throws Exception {
        this.driver.get("https://google.com");
        // do nothing for 10 seconds
        try {
            Thread.sleep(10000);
        } catch (Exception e) {}
    }

    @AfterClass
    public void closeSeleniumSession() {
        this.driver.close();
        this.driver.quit();
    }
}
