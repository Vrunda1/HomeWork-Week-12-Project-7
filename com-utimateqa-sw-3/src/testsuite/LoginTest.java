package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl=" https://courses.ultimateqa.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the ‘Sign In’ link
        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));

        //Verify the text ‘Welcome Back!
        String actualResult = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String expectedResult = "Welcome Back!";
        Assert.assertEquals(expectedResult,actualResult);

    }
    @Test
    public void verifyTheErrorMessage(){
        //Click on ‘sign’ button
        clickOnElement(By.linkText("Sign In"));

        //Enter  username incorrect
        sendTextToElement(By.name("user[email]"),"123456@gmail.com");

        //Enter password
        sendTextToElement(By.id("user[password]"),"abcdefg");

        ////Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));

        //Verify the error message
        String actualResult=getTextFromElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String expectedMessage= "Invalid email or password.";

        Assert.assertEquals("Unable to log in",actualResult,expectedMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

    }



