#Author: Milton Denys

@OrdersAndReturns
Feature: Orders and Returns page

  Scenario: Verify that the guest user is able to access the Orders and Returns"

    Given I access order and return page and validate the page title "Orders and Returns"
    When I fill the fields Order ID "", Billing Last Name "", Find Order ID "" and Email ""
