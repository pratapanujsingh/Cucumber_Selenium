Feature: Login

  @SmokeTest
  Scenario: Successful  login with valid credentials
    Given Chrome browser is launched
    When Open url "https://admin-demo.nopcommerce.com/login"
    And user enters Email "admin@yourstore.com" and password  as "admin"
    And Click on enter
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on log out button
    Then Page title should be "Your store. Login"
    And close browser

    @regression
  Scenario Outline: Data Driven Login
    Given Chrome browser is launched
    When Open url "https://admin-demo.nopcommerce.com/login"
    And user enters Email "<email>" and password  as "<password>"
    And Click on enter
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on log out button
    Then Page title should be "Your store. Login"
    And close browser

    Examples:
    |email                   |password    |
    |admin@yourstore.com     |admin       |
    |admin@yourstore.com6464 |admin123         |

