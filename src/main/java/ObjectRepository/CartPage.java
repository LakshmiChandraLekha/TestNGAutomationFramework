package ObjectRepository;

import Utilites.PerformActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartPage {
    PerformActions performActions;
    public String productNames;
    public List<String> actualProductNames;
    public CartPage(WebDriver driver){
        performActions = new PerformActions(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='product-item-details']/strong/a")
    private List<WebElement> listOfProductNames;

    public void getAllAddedItems(){
        actualProductNames = new ArrayList<>();
        for(int i=0; i<listOfProductNames.size(); i++)
        {
            productNames = listOfProductNames.get(i).getText();
            actualProductNames.add(productNames);
        }
        Collections.sort(actualProductNames);
        System.out.println("productNamesInCartPage " +actualProductNames);
    }


}
