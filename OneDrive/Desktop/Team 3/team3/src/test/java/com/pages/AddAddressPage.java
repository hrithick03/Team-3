package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddAddressPage {
    WebDriver driver;

    // Constructor
    public AddAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    // 🔹 Locators
    private By firstNameField = By.id("Address_FirstName");
    private By lastNameField = By.id("Address_LastName");
    private By emailField = By.id("Address_Email");
    private By companyField = By.id("Address_Company");
    private By countryDropdown = By.id("Address_CountryId");
    private By stateField = By.id("Address_StateProvinceId");
    private By cityField = By.id("Address_City");
    private By address1Field = By.id("Address_Address1");
    private By address2Field = By.id("Address_Address2");
    private By zipField = By.id("Address_ZipPostalCode");
    private By phoneField = By.id("Address_PhoneNumber");
    private By faxField = By.id("Address_FaxNumber");
    private By saveButton = By.cssSelector("input.button-1.save-address-button");

    // 🔹 Actions
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterCompany(String company) {
        driver.findElement(companyField).sendKeys(company);
    }

    public void selectCountry(String country) {
        Select select = new Select(driver.findElement(countryDropdown));
        select.selectByVisibleText(country);
    }

    public void enterState(String state) {
        driver.findElement(stateField).sendKeys(state);
    }

    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void enterAddress1(String address1) {
        driver.findElement(address1Field).sendKeys(address1);
    }

    public void enterAddress2(String address2) {
        driver.findElement(address2Field).sendKeys(address2);
    }

    public void enterZip(String zip) {
        driver.findElement(zipField).sendKeys(zip);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void enterFax(String fax) {
        driver.findElement(faxField).sendKeys(fax);
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }

    // Combined action
    public void addAddress(String firstName, String lastName, String email, String company,
                           String country, String state, String city, String address1,
                           String address2, String zip, String phone, String fax) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterCompany(company);
        selectCountry(country);
        enterState(state);
        enterCity(city);
        enterAddress1(address1);
        enterAddress2(address2);
        enterZip(zip);
        enterPhone(phone);
        enterFax(fax);
        clickSave();
    }
}
