package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @author Alexander Symons
 */

public class HomePage extends Page {
    @FindBy(css = "h2")
    private WebElement h2;

    @FindBy(id = "Contacts")
    private WebElement toContactsButton;

    public HomePage(WebDriver driver) {
        super(driver);
        super.driver.get(path + "Controller?command=Home");
    }

    public void logIn(){
        WebElement loginButton = driver.findElement(By.id("logIn"));
        loginButton.click();
    }

    public void login(String userid, String password) {
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.setUserid(userid);
        home.setPassword(password);
        WebElement loginButton = driver.findElement(By.id("logIn"));
        loginButton.click();
    }

    public void logOut(){
        WebElement logoutButton = driver.findElement(By.id("logOut"));
        logoutButton.click();
    }

    public void setUserid(String username){
        WebElement useridField = driver.findElement(By.id("userid"));
        useridField.clear();
        useridField.sendKeys(username);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void setPassword(String password){
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public String getSucces(){
        WebElement succes = driver.findElement(By.cssSelector(".alert-succes ul li"));
        return succes.getText();
    }

    public String getError(){
        WebElement error = driver.findElement(By.cssSelector(".alert-danger ul li"));
        return error.getText();
    }

    public String getH2(){
        return h2.getText();
    }

    public ContactPage toContacts(){
        toContactsButton.click();
        return PageFactory.initElements(driver, ContactPage.class);
    }
}
