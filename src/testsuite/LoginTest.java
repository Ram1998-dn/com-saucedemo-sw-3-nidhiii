package testsuite;

import utilities.Utility;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        // Enter “standard_user” for the username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");

        // Enter “secret_sauce” for the password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");

        // Click on the ‘Login’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        // Verify the text “Products”
        assertVerifyText("Products", By.xpath("//span[@class='title']"));
    }


    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        // Enter “standard_user” for the username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");

        // Enter “secret_sauce” for the password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");

        // Click on the ‘Login’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        // Verify that six products are displayed on page
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        int actualtotalItemsSize = products.size();
        System.out.println("Total product are : " + actualtotalItemsSize);
        Assert.assertEquals(6, actualtotalItemsSize);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
