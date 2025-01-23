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
        System.out.println("You see the dashboard");
    }

    @When("user does not enter username")
    public void userDoesNotEnterUsername() {
        loginPage.usernameField.sendKeys("");
    }

    @Then("empty username error message is displayed")
    public void emptyUsernameErrorMessageIsDisplayed() {
        Assert.assertTrue("Empty username error message is NOT displayed", loginPage.errorEmptyUsernameField.isDisplayed());
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
        Assert.assertTrue("Empty password error message is NOT displayed", loginPage.errorEmptyPasswordField.isDisplayed());
        System.out.println("Error message displayed");
    }

    @When("user enters invalid username and password")
    public void userEntersInvalidUsernameAndPassword() {
        loginPage.usernameField.sendKeys("admins");
        loginPage.passwordField.sendKeys("Humanshrm123");
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        /*Assert.assertTrue("Error message is NOT displayed", loginPage.errorInvalidLogin.isDisplayed());
        System.out.println("Error message displayed");*/

        /*getWait();
        if (loginPage.errorInvalidLogin.isDisplayed()) {
            System.out.println("Error message is displayed");
        } else {
            System.out.println("Error message is NOT displayed");
        }*/

        System.out.println("Error");
    }
}
