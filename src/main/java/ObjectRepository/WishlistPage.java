package ObjectRepository;

import Utilites.PerformActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WishlistPage {

    private PerformActions performActions;
   public  String productNames;
    public List<String> expectedProductNames;

    public WishlistPage(WebDriver driver){
        performActions = new PerformActions(driver);
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath ="//div[@class='add-to-links']")
    private List<WebElement> listOfProducts;
    @FindBy(xpath = "//a[@class='action towishlist addtowish fav']/ancestor::div[@class='price-tag-block']/following-sibling::div//a")
    private List<WebElement> listOfProductNames;

    public void selectwishlistProducts()
    {
        int count = 0;
        for(WebElement product:listOfProducts)
        {
            performActions.clickOnElement(product);
            count++;
            if(count ==3)
            {
                break;
            }
        }
    }


    public void getTextWishlistedItems() throws InterruptedException {
        expectedProductNames = new ArrayList<>();
        for(int i=0; i<listOfProductNames.size(); i++)
        {
            productNames = listOfProductNames.get(i).getText();
            expectedProductNames.add(productNames);
            Thread.sleep(5000);

        }
        Collections.sort(expectedProductNames);
        System.out.println("productNamesInWishlistPage " +expectedProductNames);

    }




}
