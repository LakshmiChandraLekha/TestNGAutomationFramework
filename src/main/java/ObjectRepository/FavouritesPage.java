package ObjectRepository;

import Utilites.PerformActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FavouritesPage {

    private PerformActions performActions;
    public String productNames;
    public List<String> actualProductNames;
    public FavouritesPage(WebDriver driver){
        performActions = new PerformActions(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//p[@class='productName']")
    private List<WebElement> listOfProductNames;
    @FindBy(css ="btn-remove action delete removeWish")
    private List<WebElement> remove;


    public void getAllWishlistedItems() throws InterruptedException {
        actualProductNames = new ArrayList<>();
        for(int i=0; i<listOfProductNames.size(); i++)
        {
            productNames = listOfProductNames.get(i).getText();
            actualProductNames.add(productNames);
            Thread.sleep(5000);
        }
        Collections.sort(actualProductNames);
        System.out.println("productNamesInFavoutitePage " +actualProductNames);
    }

    public void removeitems(){
        for(int i=0; i<remove.size(); i++){
            performActions.clickOnElement(remove.get(i));
        }
    }

}
