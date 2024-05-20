package ObjectRepository;

import Utilites.PerformActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInpage {

    public WebDriver driver;
    private PerformActions performActions;

    public SignInpage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        performActions = new PerformActions(driver);
    }
      @FindBy(xpath = "//button[starts-with(@id,'onetrust-accept')]")
          private WebElement acceptCookies;
       @FindBy(xpath = "//div[@data-testid='om-overlays-close']")
       private WebElement declinePopup;
      @FindBy(css = "a[class=top-nav__link]")
       private WebElement signInLink;
      @FindBy(css = "#email")
      private WebElement emailInputBox;
      @FindBy(name = "login[password]")
      private WebElement passwordInputBox;
      @FindBy(id = "send3")
      private WebElement signInButton;
      @FindBy(xpath = "//title")
      public WebElement signInTitle;


      public void login(String email, String password){
          performActions.clickOnElement(acceptCookies);
          try {
              Thread.sleep(3000);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
          performActions.clickOnElement(declinePopup);
          performActions.clickOnElement(signInLink);
          performActions.typeValue(emailInputBox, email);
          performActions.typeValue(passwordInputBox, password);
          performActions.clickOnElement(signInButton);
      }
      public String getSignInTitleText(){
          return signInTitle.getText();
      }

          
}
