package Utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PerformActions {

    WebDriver driver;
    public PerformActions(WebDriver driver){
        this.driver = driver;
    }



    public void clickOnElement(WebElement element){
        element.click();
    }

    public void typeValue(WebElement element, String data){
        element.sendKeys(data);
    }

    public void mouseOver(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
    }

   public void clickOnBasketIcon(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
   }



}
