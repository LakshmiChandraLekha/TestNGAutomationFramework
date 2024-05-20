package WebTests;

import Base.PoundLand;
import ObjectRepository.CartPage;
import ObjectRepository.MyAccountPopUps;
import ObjectRepository.SignInpage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ObjectRepository.ProductPage;

public class AddCartTests extends PoundLand{
    SignInpage signinpage;
    ProductPage productpage;
    CartPage cartPage;
    MyAccountPopUps myAccountPopUps;

    @BeforeMethod
    public void initilazePage(){

        signinpage = new SignInpage(driver);
        productpage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        myAccountPopUps = new MyAccountPopUps(driver);
    }


    @Test(dataProvider = "testdata", dataProviderClass = ReadExcelData.class)
    public void signIn(String email,String password)  {
        signinpage.login(email,password);

    }
    @Test(dependsOnMethods = "signIn")
    public void addProducts() throws InterruptedException {
        productpage.products();
        productpage.selectSubItem(productpage.subitem);
        productpage.scroll();
        productpage.selectAddedProducts();
        productpage.getTextAllAddedProducts();
        productpage.goToBasketIcon();
    }
    @Test(dependsOnMethods ="addProducts")
    public void cart(){
        cartPage.getAllAddedItems();
        Assert.assertEquals(cartPage.actualProductNames,productpage.expectedProductNames);
    }
    @Test(dependsOnMethods = "cart")
    public void logOff(){
        myAccountPopUps.goToLogOff();
    }




}


