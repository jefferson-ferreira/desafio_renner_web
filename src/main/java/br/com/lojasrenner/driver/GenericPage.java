package br.com.lojasrenner.driver;

import java.time.Duration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import br.com.lojasrenner.parameterization.ParametersUtils;

public class GenericPage {
    protected WebDriver driver;

    private static ParametersUtils parametersUtils = ConfigFactory.create(ParametersUtils.class);

    @BeforeEach
    public void initialize() {
        // Open browser
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        this.driver = new ChromeDriver();
   
        // Maximize browser
        this.driver.manage().window().maximize();

        // Navigate to application link
        this.driver.get(parametersUtils.url());

        // Set default wait time
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static Boolean awaitElementBePresent(WebElement path, Integer timeWait) {

		Integer n = 0;

		while (!path.isDisplayed()) {

			System.out.println(n);
			n ++;

			Duration.ofSeconds(20);

			if(n > timeWait)
				return false;

		}

		return true;
	}

    @AfterEach
    public void finalize() {
        //close browser
        driver.quit();
    }
}
