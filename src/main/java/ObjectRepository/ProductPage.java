package ObjectRepository;

import Utilites.PerformActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPage {


    private PerformActions performActions;
    public  String productNames;
    public List<String> expectedProductNames;
    public ProductPage(WebDriver driver){
        performActions = new PerformActions(driver);
        PageFactory.initElements(driver, this);
    }

    public String subitem = "Outdoor Dining";
    @FindBy(xpath = "//a[@class='main_menu__link' and text()='Garden']")
    private WebElement garden;
    @FindBy(xpath = "//li[contains(@class,'menu__inner-item--level1')]/a")
    private List<WebElement> allsubitems;
    @FindBy(xpath = "//a[@class='product-item-link']")
    private WebElement listOfProducts;
    @FindBy(css = ".input-joined")
    private List<WebElement> listOfaddedProducts;
    @FindBy(xpath = "//a[@class='product-item-link']")
    private List<WebElement> getTextalladdeditems;
    @FindBy(xpath = "//*[name()='g' and @id='Icon-/-Basket']")
    private WebElement BasketIcon;


    public void products(){

        performActions.mouseOver(garden);
    }
    public void selectSubItem(String subitem){
        for(int i=0; i<allsubitems.size(); i++){
            if(allsubitems.get(i).getText().equals(subitem)){
               performActions.clickOnElement(allsubitems.get(i));
                break;
            }
        }
    }

    public void scroll(){
        performActions.moveToElement(listOfProducts);
    }

    public void selectAddedProducts()
    {
        int count =0;
        for(WebElement product:listOfaddedProducts)
        {
            performActions.clickOnElement(product);
            count++;
            if(count ==3)
            {
                break;
            }
        }

    }

    public void getTextAllAddedProducts () throws InterruptedException {
        int count =0;
        expectedProductNames = new ArrayList<>();
        for(int i=0; i<getTextalladdeditems.size(); i++)
        {
            productNames = getTextalladdeditems.get(i).getText();
            expectedProductNames.add(productNames);
            Thread.sleep(5000);
            count++;
            if(count ==3)
            {
                break;
            }
        }
        Collections.sort(expectedProductNames);
        System.out.println("productNamesInProductpage " + expectedProductNames);
    }

    public void goToBasketIcon(){
        performActions.clickOnBasketIcon(BasketIcon);
    }


}


