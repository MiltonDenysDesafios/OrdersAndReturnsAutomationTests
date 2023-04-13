#Author: Milton Denys

@OrdersAndReturns
Feature: Orders and Returns page

  @OrdersAndReturns_ID13
  Scenario: Verify that the guest user is able to access the Orders and Returns"

    Given I access order and return page and validate the page title "Orders and Returns"
    When I fill the fields Order ID "000004806", Billing Last Name "Bakker", Email "EtheleneDBakker@armyspy.com" or ZIP Code ""
    And I click on continue button
    Then I validate if the user should be able to access my orders page and validate the id "000004806"

  @OrdersAndReturns_ID14
  Scenario: Validate that the fields do not accept unwanted characters for order and return form
    Given I access order and return page and validate the page title "Orders and Returns"
    When I fill the fields Order ID "000004806", Billing Last Name "Bakker12", Email "EtheleneDBakker@armyspy.com" or ZIP Code ""
    And I click on continue button
    Then I validate if message "You entered incorrect data. Please try again." is displayed
    When I fill the fields Order ID "000004806", Billing Last Name "Bakker", Email "EtheleneDBakkerarmyspy.com" or ZIP Code ""
    And I click on continue button
    Then I validate if message "You entered incorrect data. Please try again." is displayed

  @OrdersAndReturns_ID15
  Scenario: Validate required fields for order and return form
    Given I access order and return page and validate the page title "Orders and Returns"
    And I click on continue button
    Then I validate if message "This is a required field." is displayed for required fields

  @OrdersAndReturns_ID16
  Scenario: Invalid Order ID
    Given I access order and return page and validate the page title "Orders and Returns"
    When I fill the fields Order ID "000006478", Billing Last Name "Bakker", Email "EtheleneDBakker@armyspy.com" or ZIP Code ""
    And I click on continue button
    Then I validate if message "You entered incorrect data. Please try again." is displayed

  @OrdersAndReturns_ID17
  Scenario: Validate Find Order By
    Given I access order and return page and validate the page title "Orders and Returns"
    When I fill the fields Order ID "000004806", Billing Last Name "Bakker", Email "EtheleneDBakker@armyspy.com" or ZIP Code ""
    When I fill the fields Order ID "000004806", Billing Last Name "Bakker", Email "" or ZIP Code "72395"
