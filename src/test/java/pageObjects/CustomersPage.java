package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {
    public WebDriver driver;

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By dashboard = By.xpath("//p[text() = ' Dashboard']");
    By customerManu = By.xpath("//i[@class= 'nav-icon far fa-user']");
    By customer = By.xpath("//p[text() = ' Customers']");
    By AddNew = By.xpath("//a[contains(@href, '/Admin/Customer/Create')]");
    By txtEmail = By.xpath("//*[@id=\"Email\"]");




    public void checkDashBoard() {
        Assert.assertEquals("Dashboard / nopCommerce administration", driver.getTitle());
        Assert.assertTrue(driver.findElement(dashboard).isDisplayed()); }

    public void clickCustomerMenu()  {
        driver.findElement(customerManu).click();
           }

    public void clickCustomer(){
        driver.findElement(customer).click();
    }

    public void clickAddNew(){
        driver.findElement(AddNew).click();
    }


}
