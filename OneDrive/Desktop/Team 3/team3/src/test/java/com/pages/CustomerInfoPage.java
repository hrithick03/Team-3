package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerInfoPage {
    WebDriver driver;

    // Constructor
    public CustomerInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    // 🔹 Locators
    private By accountLink = By.xpath("//a[@class='account']"); // top username link
    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By genderMaleRadio = By.id("gender-male");
    private By genderFemaleRadio = By.id("gender-female");

    // 🔹 Actions
    public void clickAccountLink() {
        driver.findElement(accountLink).click();
    }

    public String getFirstName() {
        return driver.findElement(firstNameField).getAttribute("value");
    }

    public String getLastName() {
        return driver.findElement(lastNameField).getAttribute("value");
    }

    public String getEmail() {
        return driver.findElement(emailField).getAttribute("value");
    }

    public String getGender() {
        if (driver.findElement(genderMaleRadio).isSelected()) {
            return "Male";
        } else if (driver.findElement(genderFemaleRadio).isSelected()) {
            return "Female";
        }
        return "Not Selected";
    }
}
