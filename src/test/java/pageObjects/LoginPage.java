package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    @CacheLookup
    private WebElement txtEmail;

    public void setUserName(String uname) {
        txtEmail.clear();
        txtEmail.sendKeys(uname);
    }

    @FindBy(id = "Password")
    @CacheLookup
    private WebElement txtPassword;

    public void setPassword(String pwd) {
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    @FindBy(xpath = "//button[text() = 'Log in']")
    @CacheLookup
    private WebElement btnLogin;

    public void clickLogin() {
        btnLogin.click();
    }

    @FindBy(xpath = "//a[text() = 'Logout']")
    @CacheLookup
    WebElement lnkLogout;
    ;

    public void clickLogout() {
        lnkLogout.click();
    }


}
