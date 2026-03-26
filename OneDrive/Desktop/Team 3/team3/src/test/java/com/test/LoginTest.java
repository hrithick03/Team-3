package com.test;

import com.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class LoginTest { 
    WebDriver driver;
    LoginPage loginPage;

    String baseUrl = "https://demowebshop.tricentis.com/";
    String userEmail = "gosu@gmail.com";
    String userPass = "hrishi.08";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);

        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.clickLoginLink();
        loginPage.enterEmail(userEmail);
        loginPage.enterPassword(userPass);
        loginPage.clickLoginButton();

        String actualUser = loginPage.getLoggedInUser();
        Assert.assertEquals(actualUser, userEmail, "Login failed!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
