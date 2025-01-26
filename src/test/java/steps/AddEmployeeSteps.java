package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        clickOnElement(dashboardPage.pimOption);
    }
    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        clickOnElement(dashboardPage.addEmployeeOption);
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String firstName, String middleName, String lastName) {
        sendText(firstName, addEmployeePage.firstNameField);
        sendText(middleName, addEmployeePage.middleNameField);
        sendText(lastName, addEmployeePage.lastNameField);
    }
    @When("user clicks save button")
    public void user_clicks_save_button() {
        clickOnElement(addEmployeePage.saveButton);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        Assert.assertTrue(addEmployeePage.employeeDetailsPage.isDisplayed());
        System.out.println("Employee added");
    }

    @When("admin user adds employees and id numbers")
    public void admin_user_adds_employees_and_id_numbers() throws IOException {
        List<Map<String, String>> newEmployee = ExcelReader.read();
        for (Map<String, String> employee : newEmployee) {

            sendText(employee.get("firstName"), addEmployeePage.firstNameField );
            sendText(employee.get("middleName"), addEmployeePage.middleNameField );
            sendText(employee.get("lastName"), addEmployeePage.lastNameField );
            sendText(employee.get("employeeId"), addEmployeePage.employeeIdField);

            clickOnElement(addEmployeePage.saveButton);
            clickOnElement(dashboardPage.addEmployeeOption);
        }
    }

    @When("user enters invalid first name and last name")
    public void user_enters_invalid_first_name_and_last_name() {
        sendText("", addEmployeePage.firstNameField);
        sendText("", addEmployeePage.lastNameField);
    }

    @Then("empty field error message is displayed")
    public void empty_field_error_message_is_displayed() {
        String expected = "Required";

        String actualFirstNameErrorMessage = addEmployeePage.firstNameErrorMessage.getText();
        String actualLastNameErrorMessage = addEmployeePage.lastNameErrorMessage.getText();
        Assert.assertEquals(expected, actualFirstNameErrorMessage);
        System.out.println("Empty first name field error message");
        Assert.assertEquals(expected, actualLastNameErrorMessage);
        System.out.println("Empty last name field error message");
    }

}
