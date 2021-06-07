package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.util.List;

public class SearchCustomerPage {
    public WebDriver driver;


    public SearchCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //waitHelper = new WaitHelper(driver);
    }

    @FindBy(id = "SearchEmail")
    @CacheLookup
    private WebElement txtEmailSearch;

    public void setEmail(String email) {

        //waitHelper.waitForElement(txtEmailSearch, 30);
        //txtEmailSearch.clear();
        txtEmailSearch.sendKeys(email);
    }

    @FindBy(id = "search-customers")
    @CacheLookup
    private WebElement btnSearch;

    public void clickSearch() {
        btnSearch.click();
    }

    @FindBy(id = "customers-grid")
    @CacheLookup
    WebElement table;

    @FindBy(xpath = "//table[@id='customers-grid']/tbody/tr")
    @CacheLookup
    List<WebElement> tableRows;

    @FindBy(xpath = "//table[@id='customers-grid']/tbody/tr/td")
    @CacheLookup
    List<WebElement> tableColumns;

    public int getNoOfRows() {
        return (tableRows.size());
    }

    public int getNoOfColumns() {
        return (tableColumns.size());
    }

    public boolean searchCustomerByEmail(String email) {
        boolean flag = false;
        for (int i = 1; i <= getNoOfRows(); i++) {

            String emailID = driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]")).getText();
            System.out.println(emailID);
            if (emailID.equalsIgnoreCase("admin@yourStore.com")) {
                flag = true;
            }
        }
        return flag;
    }

}









