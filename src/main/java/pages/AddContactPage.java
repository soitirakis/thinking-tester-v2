package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddContactPage extends BasePage {

    public AddContactPage(WebDriver driver) {
        super(driver);
    }

    //elements
    private By errorMessage = By.id("error");
    private By header = By.xpath("//h1");
    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");
    private By birthDateInput = By.id("birthdate");
    private By emailInput = By.id("email");
    private By phoneNumberInput = By.id("phone");
    private By streetOneInput = By.id("street1");
    private By streetTwoInput = By.id("street2");
    private By cityInput = By.id("city");
    private By stateProvinceInput = By.id("stateProvince");
    private By postalCodeInput = By.id("postalCode");
    private By countryInput = By.id("country");
    private By submitButton = By.id("submit");

    //actions
    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
    public String getErrorMessage() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(errorMessage).getText();
    }
    public void addFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }
    public void addLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }
    public void addBirthDate(String birthDate) {
        driver.findElement(birthDateInput).sendKeys(birthDate);
    }
    public void addEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void addPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }
    public void addStreetOne(String streetOne) {
        driver.findElement(streetOneInput).sendKeys(streetOne);
    }
    public void addStreetTwo(String streetTwo) {
        driver.findElement(streetTwoInput).sendKeys(streetTwo);
    }
    public void addCity(String city) {
        driver.findElement(cityInput).sendKeys(city);
    }
    public void addStateProvince(String stateProvince) {
        driver.findElement(stateProvinceInput).sendKeys(stateProvince);
    }
    public void addPostalCode(String postalCode) {
        driver.findElement(postalCodeInput).sendKeys(postalCode);
    }
    public void addCountry(String country) {
        driver.findElement(countryInput).sendKeys(country);
    }
    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public void addNewContact(String firstName, String lastName, String birthDate, String email, String phone, String street1, String street2, String city, String stateProvince, String postalCode, String country) {
        addFirstName(firstName);
        addLastName(lastName);
        addBirthDate(birthDate);
        addEmail(email);
        addPhoneNumber(phone);
        addStreetOne(street1);
        addStreetTwo(street2);
        addCity(city);
        addStateProvince(stateProvince);
        addPostalCode(postalCode);
        addCountry(country);
        clickSubmitButton();
    }

    public void addContactWithMandatoryData(String firstName, String lastName) {
        addFirstName(firstName);
        addLastName(lastName);
        clickSubmitButton();
    }
}
