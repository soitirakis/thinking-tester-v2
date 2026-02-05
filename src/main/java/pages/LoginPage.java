package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testData.classes.User;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //elements / locators
    private By header = By.xpath("//h1");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By submitButton = By.id("submit");
    private By errorMessage = By.id("error");
    private By signupButton = By.id("signup");

    //actions
    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
    public String getError() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(errorMessage).getText();
    }
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
    public void authenticate(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmitButton();
    }
    public void authenticate(User user) {
        enterEmail(user.getUsername());
        enterPassword(user.getPassword());
        clickSubmitButton();
    }
    public void clickSignUp(){
        driver.findElement(signupButton).click();
    }

}
