package steps;

import io.cucumber.java.en.Given;
import pages.OrderAndReturnPage;

public class OrdersAndReturnsSteps {

    @Given("I access order and return page and validate the page title {string}")
    public void accessOrderReturnPage(String title) {
        OrderAndReturnPage.accessOrderReturnPage(title);
    }
    @Given("I fill the fields Order ID {string}, Billing Last Name {string}, Email {string} or ZIP Code {string}")
    public void fillOrderInformationFields(String orderId,String billingLastName,String email, String zipCode) {
        OrderAndReturnPage.fillOrderInformationFields(orderId,billingLastName,email,zipCode);
    }
    @Given("I click on continue button")
    public void clickOnContinueButton() {
        OrderAndReturnPage.clickOnContinueButton();
    }
    @Given("I validate if the user should be able to access my orders page and validate the id {string}")
    public void validateMyOrdersPage(String id) {
        OrderAndReturnPage.validateMyOrdersPage(id);
    }
    @Given("I validate if message {string} is displayed")
    public void incorretDataErrorMessage(String message) {
        OrderAndReturnPage.incorretDataErrorMessage(message);
    }
    @Given("I validate if message {string} is displayed for required fields")
    public void requiredFieldsMessage(String message) {
        OrderAndReturnPage.requiredFieldsMessage(message);
    }
}