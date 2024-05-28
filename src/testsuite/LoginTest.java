package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email
 * or password.’
 */
public class LoginTest extends BaseTest {

    static String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUpBrowser(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on sign in link
        WebElement signInLink = driver.findElement(By.partialLinkText("Sign"));
        signInLink.click();
        //Verify text on sign in page
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.cssSelector(".page__heading")).getText();
        Assert.assertEquals("Welcome text not displayed", expectedText, actualText);

    }

    @Test
    public void verifyTheErrorMessage() {
        //click on sign in link
        WebElement signInLink = driver.findElement(By.partialLinkText("Sign"));
        signInLink.click();
        //enter email in email field
        driver.findElement(By.id("user[email]")).sendKeys("Prime123@gmail.com");
        //enter password in password field
        driver.findElement(By.id("user[password]")).sendKeys("Prime123");
        //Click on sign in button
        driver.findElement(By.cssSelector(".button.button-primary.g-recaptcha")).click();
        //Verify error message on sing in page
        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = driver.findElement(By.cssSelector(".form-error__list-item")).getText();
        Assert.assertEquals("Error message not match", expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
