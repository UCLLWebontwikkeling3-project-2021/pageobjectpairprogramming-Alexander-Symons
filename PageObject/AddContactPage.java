package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

/**
 * @author Nina Kumps
 * @version Alexander Symons
 */

public class AddContactPage extends Page{
    public AddContactPage(WebDriver driver) {
        super(driver);
        this.getDriver().get(getPath()+ "Controller?command=NewContact");
    }

    @FindBy(id = "voornaam")
    private WebElement firstNameField;

    @FindBy(id = "familienaam")
    private WebElement lastNamefield;

    @FindBy(id = "date")
    private WebElement dateField;

    @FindBy(id = "uur")
    private WebElement hourField;

    @FindBy(id = "telefoonnummer")
    private WebElement phoneNumberField;

    @FindBy(id = "emailadres")
    private WebElement emailField;

    @FindBy(id = "addContact")
    private WebElement signUpButton;

    public void setFirstNameField(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void setLastNamefield(String lastName) {
        lastNamefield.clear();
        lastNamefield.sendKeys(lastName);
    }

    public void setDateField(String date) {
        dateField.clear();
        dateField.sendKeys(date);
    }

    public void setHourField(String hour) {
        hourField.clear();
        hourField.sendKeys(hour);
    }

    public void setPhoneNumberField(String phoneNumber) {
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void setEmailField(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void submitValid() {
        signUpButton.click();
    }

    public boolean hasErrorMessage(String message) {
        WebElement errorMessage = driver.findElement(By.cssSelector(".alert-danger ul li"));
        return (message.equals(errorMessage.getText()));
    }

    public String getError(){
        WebElement error = driver.findElement(By.cssSelector(".alert-danger ul li"));
        return error.getText();
    }

    public boolean containsFirstName(String firstName) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(firstName)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsLastName(String lastName) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(lastName)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsDate(String date) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(date)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsHour(String hour) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(hour)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(phoneNumber)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsUserWithEmail(String email) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(email)) {
                found = true;
            }
        }
        return found;
    }
}