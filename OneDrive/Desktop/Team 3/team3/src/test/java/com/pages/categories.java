package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class categories {

    WebDriver driver;
    loginpage loginPage;

    // Constructor
    public categories(WebDriver driver) {
        this.driver = driver;
        loginPage = new loginpage(driver);
    }

    // 🔹 Category Locators

    // Jewelry category
    By jewelry = By.linkText("Jewelry");

    // Sort dropdown
    By sortBy = By.id("products-orderby");

    // Display per page
    By display = By.id("products-pagesize");

    // View as grid/list
    By view = By.id("products-viewmode");


    // 🔹 Login Method (calling loginpage)

    public void loginToApplication(String email, String password) {

        loginPage.clickLoginLink();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }


    // 🔹 Category Methods

    // Click Jewelry
    public void clickJewelry() {
        driver.findElement(jewelry).click();
    }

    // Name A-Z
    public void sortNameAZ() {
        Select select = new Select(driver.findElement(sortBy));
        select.selectByVisibleText("Name: A to Z");
    }

    // Price Low to High
    public void sortPriceLowHigh() {
        Select select = new Select(driver.findElement(sortBy));
        select.selectByVisibleText("Price: Low to High");
    }

    // Display per page
    public void displayPerPage(String value) {
        Select select = new Select(driver.findElement(display));
        select.selectByVisibleText(value);
    }

    // View Grid
    public void viewGrid() {
        Select select = new Select(driver.findElement(view));
        select.selectByVisibleText("Grid");
    }

    // View List
    public void viewList() {
        Select select = new Select(driver.findElement(view));
        select.selectByVisibleText("List");
    }

}