package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {

    /**
     * This method will click on given locator path
     */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    /**
     * This method will compare actual result and expected result
     */
    public void assertVerifyText(String expectedText, By by) {
        Assert.assertEquals(expectedText, driver.findElement(by).getText());
    }


    /**
     * This method is for send input into the field
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

}
