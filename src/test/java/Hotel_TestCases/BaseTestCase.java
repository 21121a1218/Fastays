package Hotel_TestCases;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTestCase {

    public WebDriver driver;
    public Properties p;

    @BeforeClass
    @Parameters({"os", "browser"})
    void setup(@Optional("windows") String os, @Optional("chrome") String br) 
            throws MalformedURLException, IOException {

        // Load properties file
        FileReader file = new FileReader(".//src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        String env = p.getProperty("execution_env");

        // ===============================
        // REMOTE EXECUTION (SELENIUM GRID)
        // ===============================
        if (env.equalsIgnoreCase("remote")) {

            DesiredCapabilities capabilities = new DesiredCapabilities();

            // OS selection
            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WINDOWS);
            } 
            else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            }  
            else if (os.equalsIgnoreCase("linux")) {
                capabilities.setPlatform(Platform.LINUX);
            }  
            else {
                throw new IllegalArgumentException("Unsupported OS: " + os);
            }

            // Browser selection
            switch (br.toLowerCase()) {

                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;

                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;

                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + br);
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }

        // ===============================
        // LOCAL EXECUTION
        // ===============================
        else if (env.equalsIgnoreCase("local")) {

            switch (br.toLowerCase()) {

                case "chrome":

                    ChromeOptions options = new ChromeOptions();

                    // Headless settings for CI / GitHub Actions
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");

                    driver = new ChromeDriver(options);
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + br);
            }
        }

        // Global settings
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Headless ignores maximize, so set size manually
        driver.manage().window().setSize(new Dimension(1920,1080));

        // Open URL
        driver.get(p.getProperty("HotelURL"));
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            //driver.quit();
        }
    }

    // ===============================
    // RANDOM DATA GENERATORS
    // ===============================

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumeric() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaNumeric() {
        return RandomStringUtils.randomAlphabetic(3) + "@" + RandomStringUtils.randomNumeric(2);
    }
}