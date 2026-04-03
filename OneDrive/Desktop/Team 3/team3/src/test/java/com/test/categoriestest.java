package com.test;

import com.pages.loginpage;
import com.pages.categories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class categoriestest {

    WebDriver driver;
    loginpage loginPage;
    categories categoryPage;

    String baseUrl = "https://demowebshop.tricentis.com/";
    String userEmail = "gosu@gmail.com";
    String userPass = "hrishi.08";

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);

        loginPage = new loginpage(driver);
        categoryPage = new categories(driver);
    }

    @Test
    public void testCategories() {

        // Login (calling teammate code)
        loginPage.clickLoginLink();
        loginPage.enterEmail(userEmail);
        loginPage.enterPassword(userPass);
        loginPage.clickLoginButton();

        // Categories (your work)
        categoryPage.clickJewelry();
        categoryPage.sortNameAZ();
        categoryPage.sortPriceLowHigh();
        categoryPage.displayPerPage("8");
        categoryPage.viewGrid();
        categoryPage.viewList();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}