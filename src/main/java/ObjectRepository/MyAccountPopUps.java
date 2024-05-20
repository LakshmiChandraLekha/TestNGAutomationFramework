package ObjectRepository;

import Utilites.PerformActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPopUps {

    PerformActions performActions;
    public MyAccountPopUps(WebDriver driver){
        performActions = new PerformActions(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='top-nav__link']")
    private WebElement myAccountlink;
    @FindBy(xpath = "//div[@class='fill--whisper page-top']/descendant::a[text()='My Favourites']")
    private WebElement myfavouritelink;
    @FindBy(xpath = "//a[text()='Log out']")
    private WebElement logOutlink;
    public void goToMyFavourites(){
        performActions.clickOnElement(myAccountlink);
        performActions.clickOnElement(myfavouritelink);
    }
    public void goToLogOff(){
        performActions.clickOnElement(myAccountlink);
        performActions.clickOnElement(logOutlink);
    }
}
