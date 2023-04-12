package steps;

import io.cucumber.java.en.Given;
import pages.OrderAndReturnPage;

public class OrdersAndReturnsSteps {

    @Given("I access order and return page and validate the page title {string}")
    public void accessOrderReturnPage(String title) {
        OrderAndReturnPage.accessOrderReturnPage(title);
    }
    @Given("I fill the fields Order ID {string}, Billing Last Name {string}, Find Order ID {string} and Email {string}")
    public void fillOrderInformationFields(String orderId,String billingLastName,String findOrderID,String email) {
        OrderAndReturnPage.fillOrderInformationFields(orderId,billingLastName,findOrderID,email);
    }
}
