package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class OrderAndReturnPage extends BasePage{
    public static String orderAndReturnButton = "//a[contains(text(),'Orders and Returns')]";
    public static String orderAndReturnPageTitle = "//span[contains(text(),'Orders and Returns')]";
    public static String orderIdField = "//input[@id='oar-order-id']";
    public static String billingLastNameField = "//input[@id='oar-billing-lastname']";
    public static String findOrderId = "//select[@id='quick-search-type-id']";
    public static String findOrderIdEmail = "//option[contains(text(),'Email')]";
    public static String findOrderIdZipCode = "//option[contains(text(),'ZIP Code')]";
    public static String emailField = "//input[@id='oar_email']";
    public static String emailFieldText = "//*[@id='oar_email']/label/span";
    public static String zipCodeField = "//input[@id='oar_zip']";
    public static String continueButton = "//span[contains(text(),'Continue')]";
    public static String errorMessage = "//div[contains(text(),'You entered incorrect data. Please try again.')]";
    public static String requiredOrderIdMessage = "//div[@id='oar-order-id-error']";
    public static String requiredBillingLastNameMessage = "//div[@id='oar-billing-lastname-error']";
    public static String requiredEmailMessage = "//div[@id='oar_email-error']";

    public static void accessOrderReturnPage(String title){
        try {
            scrollToElement(By.xpath(orderAndReturnButton));
            click(By.xpath(orderAndReturnButton));
            String pageTitleReturn = getText(By.xpath(orderAndReturnPageTitle));
            Assert.assertEquals(title,pageTitleReturn);
        } catch (Exception e) {
            System.err.println("Error while accessing Order Return page");
        }
    }
    public static void fillOrderInformationFields(String orderId,String billingLastName,String email,String zipCode){
        try {
            write(By.xpath(orderIdField),orderId);
            write(By.xpath(billingLastNameField),billingLastName);
            click(By.xpath(findOrderId));
            selectEmailOrZipCode(email,zipCode);
        } catch (Exception e) {
            System.err.println("Error while while filling Order Information Fields");
        }
    }
    public static void selectEmailOrZipCode(String email,String zipCode){
        try {
            if ((email == null || email.isEmpty()) && (zipCode == null || zipCode.isEmpty())) {
                throw new Exception("Please provide a value for either the email or ZIP code field.");
            } else if (email != null && !email.isEmpty() && zipCode != null && !zipCode.isEmpty()) {
                throw new Exception("Please provide only one value for either the email or ZIP code field.");
            } else if (email != null && !email.isEmpty()) {
                click(By.xpath(findOrderIdEmail));
                write(By.xpath(emailField), email);
            } else if (zipCode != null && !zipCode.isEmpty()) {
                click(By.xpath(findOrderIdZipCode));
                write(By.xpath(zipCodeField), zipCode);
            }
        } catch (Exception e) {
            System.err.println("Error filling in order information: " + e.getMessage());
        }
    }
    public static void clickOnContinueButton(){
        try {
            click(By.xpath(continueButton));
        } catch (Exception e) {
            System.err.println("Error while while clicking continue button");
        }
    }
    public static void validateMyOrdersPage(String id){
        try {
            String returnId = getText(By.xpath("//span[contains(text(),'Order # " + id + "')]"));
            Assert.assertEquals(returnId,"Order # " + id);
            System.out.println("");
        } catch (Exception e) {
            System.err.println("Error while accessing Order My Orders page");
        }
    }
    public static void incorretDataErrorMessage(String message){
        try {
            String returnMessage = getText(By.xpath(errorMessage));
            Assert.assertEquals(message,returnMessage);
        } catch (Exception e) {
            System.err.println("Error while trying to validate error message");
        }
    }
    public static void requiredFieldsMessage(String message){
        try {
            String returnRequiredOrderIdMessage = getText(By.xpath(requiredOrderIdMessage));
            String returnRequiredBillingLastNameMessage = getText(By.xpath(requiredBillingLastNameMessage));
            String returnRequiredEmailMessage = getText(By.xpath(requiredEmailMessage));
            Assert.assertEquals(message,returnRequiredOrderIdMessage);
            Assert.assertEquals(message,returnRequiredBillingLastNameMessage);
            Assert.assertEquals(message,returnRequiredEmailMessage);
        } catch (Exception e) {
            System.err.println("Error while trying to validate required message fields");
        }
    }
}
