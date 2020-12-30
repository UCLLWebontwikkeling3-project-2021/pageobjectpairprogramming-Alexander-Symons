package PageObject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evert
 * @version Alexander Symons
 */

public class ContactsOverviewTest {
    private WebDriver driver;
    private String path = "http://localhost:8081/Opdracht1_war_exploded/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\UCLL\\Webontwikkeling 3\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.managed_default_content_settings.javascript", 2);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test(expected = NoSuchElementException.class)
    public void test_Not_Logged_In_User_Navigates_From_Home_To_Contacts_Throws_Exception()  {
        HomePage page = PageFactory.initElements(driver, HomePage.class);
        page.toContacts();
        Assert.assertEquals("You are not authorized to go to this page of the website!", page.getError());
    }

//    PROBLEEM
//    @Test
//    public void test_Logged_In_User_Can_Navigate_From_Home_To_Contacts() {
//        HomePage page = PageFactory.initElements(driver, HomePage.class);
//        loginUser();
//        page.toContacts();
//        Assert.assertEquals("Contacts", driver.getTitle());
//    }

    @Test
    public void test_Logged_In_User_Can_Navigate_From_Contacts_To_Home() {
        loginUser();
        ContactPage page = PageFactory.initElements(driver,ContactPage.class);
        page.toHome();
        Assert.assertEquals("Home", driver.getTitle());
    }

    @Test
    public void test_User_Without_Contacts_Shows_No_Contacts() {
        loginUserWithoutContacts();
        ContactPage page = PageFactory.initElements(driver,ContactPage.class);
        Assert.assertEquals(0, page.countContacts());
    }


    public void loginUser(){
        HomePage page = PageFactory.initElements(driver, HomePage.class);
        page.login("joran", "j");
    }

    public void loginUserWithoutContacts(){
        HomePage page = PageFactory.initElements(driver, HomePage.class);
        page.login("indra", "i");
    }
}