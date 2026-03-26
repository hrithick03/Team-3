package com.test;

import com.pages.LoginPage;
import com.pages.CustomerInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class CustomerInfoTest {
    WebDriver driver;
    LoginPage loginPage;
    CustomerInfoPage customerInfoPage;

    String baseUrl = "https://demowebshop.tricentis.com/";
    String userEmail = "gosu@gmail.com";
    String userPass = "hrishi.08"; // replace with actual password

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);

        loginPage = new LoginPage(driver);

        // Login first
        loginPage.clickLoginLink();
        loginPage.enterEmail(userEmail);
        loginPage.enterPassword(userPass);
        loginPage.clickLoginButton();

        // Navigate to Customer Info by clicking username link
        customerInfoPage = new CustomerInfoPage(driver);
        customerInfoPage.clickAccountLink();
    }

    @Test
    public void verifyCustomerInfo() {
        Assert.assertEquals(customerInfoPage.getFirstName(), "gopal", "First name mismatch!");
        Assert.assertEquals(customerInfoPage.getLastName(), "gosu", "Last name mismatch!");
        Assert.assertEquals(customerInfoPage.getEmail(), "gosu@gmail.com", "Email mismatch!");
        Assert.assertEquals(customerInfoPage.getGender(), "Male", "Gender mismatch!");
    }
 
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
