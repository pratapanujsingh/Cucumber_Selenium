package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.CustomersPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Steps extends Base {

    @Before
    public  void setUp() throws IOException {
        logger = Logger.getLogger("This is myProject");
        PropertyConfigurator.configure("Log4j.properties");

        configProp = new Properties();
        //Read the property file
        FileInputStream configProfile = new FileInputStream("config.properties");
        configProp.load(configProfile);

        String br = configProp.getProperty("browser");
        if(br.equals ("chrome")){
            System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();}

        else if(br.equals ("firefox")){
            System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
            driver.manage().window().maximize();} }

    @Given("Chrome browser is launched")
    public void chrome_browser_is_launched() {
System.out.println("Launching browser");
        //logger.info("******Browser is Launched******");
        lp = new LoginPage(driver);
        cp = new CustomersPage(driver); }

    @When("Open url {string}")
    public void open_url(String url) {
        driver.get(url);
        logger.info("******Opening URL******");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); }

    @And("user enters Email {string} and password  as {string}")
    public void user_enters_email_and_password_as(String email, String password) {
        logger.info("******Providing Email and Password******");
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @And("Click on enter")
    public void click_on_enter() {
        lp.clickLogin();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {

        if (driver.getPageSource().contains("Login was unsuccessful")) {
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }
    }

    @When("User click on log out button")
    public void user_click_on_log_out_button() throws InterruptedException {
        logger.info("******Application is logged out******");
        lp.clickLogout();
        Thread.sleep(3000);
    }

    @And("close browser")
    public void close_browser() {
        logger.info("******Browser is Closed******");
        driver.close();
    }

    //Steps for Additional Scenario

    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        logger.info("******User can view Dashboard******");
        cp.checkDashBoard();
    }

    @When("User clicks on customers menu")
    public void user_clicks_on_customers_menu() {
        logger.info("******Clicks on customer menu******");
        cp.clickCustomerMenu();
    }

    @When("click on customers menu item")
    public void click_on_customers_menu_item() {
        cp.clickCustomer();
    }

    /*@When("click on add new button")
    public void click_on_add_new_button() {

    }
    @Then("user can view add new customer Page")
    public void user_can_view_add_new_customer_page() {

    }
    @When("user enters customers info")
    public void user_enters_customers_info() {
    }
    @When("click on save button")
    public void click_on_save_button() {

    }
    @Then("user can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {

    }*/
    @When("enter customer Email")
    public void enter_customer_email() {
        logger.info("******Search Customer by E-mail******");
        scp = new SearchCustomerPage(driver);
        scp.setEmail("admin@yourStore.com");
    }

    @When("click on search button")
    public void click_on_search_button() {
        logger.info("******Clicks on Search button******");
        scp.clickSearch();
    }

    @Then("user should found email")
    public void user_should_found_email() {
        logger.info("******Expected Result is found******");
        boolean status = scp.searchCustomerByEmail("admin@yourStore.com");
        Assert.assertEquals(true, status);
    }

}
