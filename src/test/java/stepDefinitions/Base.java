package stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.CustomersPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import java.util.Properties;


public class Base {

    public WebDriver driver;
    public LoginPage lp;
    public CustomersPage cp ;
    public SearchCustomerPage scp ;
    public static Logger logger;
    public Properties configProp;

}
