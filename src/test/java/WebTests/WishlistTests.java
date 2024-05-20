package WebTests;

import Base.PoundLand;
import ObjectRepository.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WishlistTests extends PoundLand {

    SignInpage signInpage;
    ProductPage productPage;
    WishlistPage wishlistPage;
    FavouritesPage favouritesPage;
    MyAccountPopUps myAccountPopUps;
    @BeforeMethod
    public void initilazePage(){
        signInpage = new SignInpage(driver);
        productPage = new ProductPage(driver);
        wishlistPage = new WishlistPage(driver);
        favouritesPage = new FavouritesPage(driver);
        myAccountPopUps = new MyAccountPopUps(driver);
    }
    @Test(dataProvider = "testdata", dataProviderClass = ReadExcelData.class)
    public void signIn(String email,String password){
        signInpage.login(email, password);
    }

    @Test(dependsOnMethods = "signIn")
    public void selectProduct() throws InterruptedException {
        productPage.products();
        productPage.selectSubItem(productPage.subitem);
        productPage.scroll();
        wishlistPage.selectwishlistProducts();
        wishlistPage.getTextWishlistedItems();
        myAccountPopUps.goToMyFavourites();

    }
    @Test(dependsOnMethods = "selectProduct")
    public void Favourite() throws InterruptedException {
        favouritesPage.getAllWishlistedItems();
        Assert.assertEquals(favouritesPage.actualProductNames,wishlistPage.expectedProductNames);
        //favouritesPage.removeitems();
    }
    @Test(dependsOnMethods = "Favourite")
    public void logOff(){
        myAccountPopUps.goToLogOff();
    }
}