package Base;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
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

   public void getScreenshot(Method method) throws IOException {
       TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
       File sourceImage = takesScreenshot.getScreenshotAs(OutputType.FILE);
       File destinationImage = new File(System.getProperty("user.dir") + "/screenshot/"+method.getName()+".png");
       FileUtils.copyFile(sourceImage,destinationImage);
   }

   @AfterMethod
   public void takesScreenshotIfTestFails(ITestResult iTestResult, Method method) throws IOException {
    if(ITestResult.FAILURE == iTestResult.getStatus()){
        getScreenshot(method);
        Allure.addAttachment(method.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
   }

   @AfterClass
    public void closeBrowser(){
        if(driver != null){
            driver.quit();
        }

    }
}

