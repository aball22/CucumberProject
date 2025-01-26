package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    @When("user enters valid username and password")
    public void userEntersValidUsernameAndPassword() {
        sendText(ConfigReader.read("username"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() {
        clickOnElement(loginPage.loginButton);
    }

    @Then("user sees dashboard page")
    public void userSeesDashboardPage() {
        Assert.assertTrue("Login unsuccessful, dashboard is NOT displayed", dashboardPage.dashboardWelcomeMessage.isDisplayed());
        System.out.println("Login successful, dashboard available");
    }

    @When("user does not enter username")
    public void userDoesNotEnterUsername() {
        loginPage.usernameField.sendKeys("");
    }

    @Then("empty username error message is displayed")
    public void emptyUsernameErrorMessageIsDisplayed() {
        String loginErrorText = loginPage.loginErrorMessage.getText();
        Assert.assertEquals("Username cannot be empty", loginErrorText);
        System.out.println("Error message displayed");
    }

    @When("user enters username")
    public void userEntersUsername() {
        sendText(ConfigReader.read("username"), loginPage.usernameField);
    }

    @And("user does not enter password")
    public void userDoesNotEnterPassword() {
        loginPage.passwordField.sendKeys("");
    }

    @Then("empty password error message is displayed")
    public void emptyPasswordErrorMessageIsDisplayed() {
        String loginErrorText = loginPage.loginErrorMessage.getText();
        Assert.assertEquals("Password is Empty", loginErrorText);
        System.out.println("Error message displayed");
    }

    @When("user enters invalid username and password")
    public void userEntersInvalidUsernameAndPassword() {
        loginPage.usernameField.sendKeys("admins");
        loginPage.passwordField.sendKeys("Humanshrm123");
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        String loginErrorText = loginPage.loginErrorMessage.getText();
        Assert.assertEquals("Invalid credentials", loginErrorText);
        System.out.println("Error message displayed");
    }
}
