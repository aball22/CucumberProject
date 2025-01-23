package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        clickOnElement(addEmployeePage.pimOption);
    }
    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        clickOnElement(addEmployeePage.addEmployeeOption);
    }
    @When("user enters {string} and {string}")
    public void user_enter_and(String firstName, String lastName) {
        sendText(firstName, addEmployeePage.firstNameField);
        sendText(lastName, addEmployeePage.lastNameField);
        /*clickOnElement(addEmployeePage.saveButton);
        clickOnElement(addEmployeePage.addEmployeeOption);*/
    }
    @When("user clicks save button")
    public void user_clicks_save_button() {
        clickOnElement(addEmployeePage.saveButton);
    }
    @When("a unique id is given")
    public void a_unique_id_is_given() {

        System.out.println(addEmployeePage.employeeId.getText());
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added");
    }

    @When("admin user adds employees and id numbers")
    public void admin_user_adds_employees_and_id_numbers() throws IOException {
        List<Map<String, String>> newEmployee = ExcelReader.read();
        for (Map<String, String> employee : newEmployee) {

            //addEmployeePage.firstNameField.sendKeys(employee.get("firstName"));
            //addEmployeePage.lastNameField.sendKeys(employee.get("lastName"));
            //addEmployeePage.newEmployeeId.sendKeys(employee.get("employeeId"));
            sendText(employee.get("firstName"), addEmployeePage.firstNameField );
            sendText(employee.get("lastName"), addEmployeePage.lastNameField );
            sendText(employee.get("employeeId"), addEmployeePage.newEmployeeId );

            clickOnElement(addEmployeePage.saveButton);
            clickOnElement(addEmployeePage.addEmployeeOption);
        }
    }

    @When("user enters invalid first name and last name")
    public void user_enters_invalid_first_name_and_last_name() {
        sendText("", addEmployeePage.firstNameField);
    }

}
