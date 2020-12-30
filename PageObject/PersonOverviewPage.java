package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * @author Lukas De Ruysscher
 * @version Alexander Symons
 */

public class PersonOverviewPage extends Page {

    public PersonOverviewPage(WebDriver driver) {
        super(driver);
        this.driver.get(getPath() + "Controller?command=Overview");
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

    public boolean containsUserWithFirstname(String firstname) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(firstname)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsUserWithLastname(String lastname) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(lastname)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsErrorMessage(String message) {
        WebElement errorMessage = driver.findElement(By.cssSelector("p"));
        return (message.equals(errorMessage.getText()));
    }

    public String getError(){
        WebElement error = driver.findElement(By.cssSelector(".alert-danger ul li"));
        return error.getText();
    }
}