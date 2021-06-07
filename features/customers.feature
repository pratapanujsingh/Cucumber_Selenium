Feature: Customers
Background:  Below steps are common
  Given Chrome browser is launched
  When Open url "https://admin-demo.nopcommerce.com/login"
  And user enters Email "admin@yourstore.com" and password  as "admin"
  And Click on enter
  Then User can view Dashboard

  ##Scenario: Add new customers
    #Given Chrome browser is launched
    #When Open url "https://admin-demo.nopcommerce.com/login"
    #And user enters Email "admin@yourstore.com" and password  as "admin"
    #And Click on enter
    #Then User can view Dashboard
    #When User clicks on customers menu
    #And click on customers menu item
    #And click on add new button
    #Then user can view add new customer Page
    #When user enters customers info
    #And click on save button
    #Then user can view confirmation message "The new customer has been add successfully"
    #And close browser

    Scenario: Search Customer by Email ID

      When User clicks on customers menu
      And click on customers menu item
      And enter customer Email
      When click on search button
      Then user should found email
      And close browser




