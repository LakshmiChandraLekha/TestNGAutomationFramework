package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class PoundLand {

   public  WebDriver driver;
   WebDriverFactory webDriverFactory;
@Parameters({"browsertype","url"})
   @BeforeClass
   public void initialize(String browsertype, String url){
        webDriverFactory = new WebDriverFactory(driver);
        driver = webDriverFactory.initializeBrowser(browsertype);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
   }

   @AfterClass
    public void closeBrowser(){
        if(driver != null){
            driver.quit();
        }

    }
}

