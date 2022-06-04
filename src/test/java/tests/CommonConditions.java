package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;


import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class CommonConditions {
    WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();

    @Before
    public void setup() {
        logger.info("create driver");
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @After
    public void close() {
        driver.quit();
    }
}
