package com.test;

import com.pages.LoginPage;
import com.pages.AddAddressPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;

public class AddAddressTest {
    WebDriver driver;
    LoginPage loginPage;
    AddAddressPage addAddressPage;

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

        // Navigate directly to Add Address page
        driver.get(baseUrl + "customer/addressadd");
        addAddressPage = new AddAddressPage(driver);
    }

    @Test
    public void testAddAddress() {
        addAddressPage.addAddress(
            "Harry", 
            "Osborn", 
            "SpiderHater@gmail.Web", 
            "Oscorp", 
            "India", 
            "Tamil Nadu", 
            "Salem", 
            "123 Green Street", 
            "Near Park", 
            "636001", 
            "9876543210", 
            "123456"
        );
        // You can add assertions here to verify success message or presence of new address
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
