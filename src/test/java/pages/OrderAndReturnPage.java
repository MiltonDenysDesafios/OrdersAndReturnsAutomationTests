package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class OrderAndReturnPage extends BasePage{
    public static String orderAndReturnButton = "//a[contains(text(),'Orders and Returns')]";
    public static String orderAndReturnPageTitle = "//span[contains(text(),'Orders and Returns')]";
    public static String orderIdField = "//input[@id='oar-order-id']";
    public static String billingLastNameField = "//input[@id='oar-billing-lastname']";
    public static String findOrderId = "//select[@id='quick-search-type-id']";
    public static String emailField = "//input[@id='oar_email']";

    public static void accessOrderReturnPage(String title){
        try {
            scrollToElement(By.xpath(orderAndReturnButton));
            click(By.xpath(orderAndReturnButton));
            String pageTitleReturn = getText(By.xpath(orderAndReturnPageTitle));
            Assert.assertEquals(title,pageTitleReturn);
        } catch (Exception e) {
            System.err.println("error on accessOrderReturnPage");
        }
    }
    public static void fillOrderInformationFields(String orderId,String billingLastName,String findOrderID,String email){
        try {
            write(By.xpath(orderIdField),orderId);
            write(By.xpath(billingLastNameField),billingLastName);
            write(By.xpath(findOrderId),findOrderID);
            write(By.xpath(emailField),email);
        } catch (Exception e) {
            System.err.println("error on fillOrderInformationFields");

        }
    }
}
