package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

/**
 * @author Evert
 */

public class ContactPage extends Page {
    @FindBy(linkText = "Home")
    private WebElement toHomeButton;

    public ContactPage(WebDriver driver) {
        super(driver);
        this.driver.get(path+"Controller?command=Contacts");
    }

    public int countContacts(){
        ArrayList<WebElement> contacts = (ArrayList<WebElement>)  driver.findElements(By.id("myContact"));
        return contacts.size();
    }

    public HomePage toHome(){
        toHomeButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }
}