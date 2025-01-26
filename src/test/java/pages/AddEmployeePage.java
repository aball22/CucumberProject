package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {



    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@id='firstName']/following-sibling::span[@class='validation-error']")
    public WebElement firstNameErrorMessage;

    @FindBy(xpath = "//input[@id='firstName']/following-sibling::span[@class='validation-error']")
    public WebElement lastNameErrorMessage;

    @FindBy(id = "middleName")
    public WebElement middleNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "personal_txtEmployeeId")
    public WebElement employeeId;

    @FindBy(id = "employeeId")
    public WebElement employeeIdField;

    @FindBy(id = "pdMainContainer")
    public WebElement employeeDetailsPage;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }
}
