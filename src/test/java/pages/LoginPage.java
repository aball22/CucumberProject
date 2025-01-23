package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    @FindBy(id = "txtUsername")
    public WebElement usernameField;

    @FindBy(id = "txtPassword")
    public  WebElement passwordField;

    @FindBy(id = "btnLogin")
    public  WebElement loginButton;

    @FindBy(xpath = "//span[text()='Password is Empty']")
    public WebElement errorEmptyPasswordField;

    @FindBy(xpath = "//span[text()='Username cannot be empty']")
    public WebElement errorEmptyUsernameField;

    @FindBy(xpath = "//span[text()='Csrf token validation failed']")
    public WebElement errorInvalidLogin;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

}
