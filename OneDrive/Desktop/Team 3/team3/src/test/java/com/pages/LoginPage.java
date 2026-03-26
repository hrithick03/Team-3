package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 🔹 Locators
    private By loginLink = By.linkText("Log in");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.cssSelector("input.button-1.login-button");
    private By accountHeader = By.className("account");
    private By logoutLink = By.linkText("Log out");

    // 🔹 Actions (Methods)
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getLoggedInUser() {
        return driver.findElement(accountHeader).getText();
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }
}
