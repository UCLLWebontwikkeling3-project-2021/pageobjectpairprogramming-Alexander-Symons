package PageObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
/**
 * @author Nina Kumps
 * @version Alexander Symons
 */

public class AddContactTest {
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

        driver.get(path + "Controller?command=Home");
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_log_in() {
        HomePage loginPage = PageFactory.initElements(driver, HomePage.class);
        loginPage.login("joran", "j");
        assertEquals("Home", loginPage.getTitle());
    }

    @Test
    public void test_user_can_add_contact() {
        HomePage logInPage = PageFactory.initElements(driver, HomePage.class);
        logInPage.login("joran", "j");

        AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

        addContactPage.setFirstNameField("Mark");
        addContactPage.setLastNamefield("Walberg");
        addContactPage.setDateField("11-11-2020");
        addContactPage.setHourField("08:55");
        addContactPage.setPhoneNumberField("0412456512");
        addContactPage.setEmailField("mark@ucll.be");

        addContactPage.submitValid();
        assertEquals("Contacts", addContactPage.getTitle());
        assertTrue(addContactPage.containsFirstName("Mark"));
        assertTrue(addContactPage.containsLastName("Mark"));
        assertTrue(addContactPage.containsDate("2020-11-11"));
        assertTrue(addContactPage.containsPhoneNumber("0412456512"));
        assertTrue(addContactPage.containsUserWithEmail("mark@ucll.be"));
    }

    @Test
    public void test_user_fills_in_empty_firstname() {
        HomePage logInPage = PageFactory.initElements(driver, HomePage.class);
        logInPage.login("joran", "j");

        AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

        addContactPage.setFirstNameField("");
        addContactPage.setLastNamefield("Walberg");
        addContactPage.setDateField("11-11-2020");
        addContactPage.setHourField("08:55");
        addContactPage.setPhoneNumberField("0412456512");
        addContactPage.setEmailField("mark@ucll.be");
        addContactPage.submitValid();

        assertEquals("Add Contact", addContactPage.getTitle());
        assertEquals("Invalid first name", addContactPage.getError());
    }

    @Test
    public void test_user_fills_in_empty_lastname() {
        HomePage logInPage = PageFactory.initElements(driver, HomePage.class);
        logInPage.login("joran", "j");

        AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

        addContactPage.setFirstNameField("Mark");
        addContactPage.setLastNamefield("");
        addContactPage.setDateField("11-11-2020");
        addContactPage.setHourField("08:55");
        addContactPage.setPhoneNumberField("0412456512");
        addContactPage.setEmailField("mark@ucll.be");
        addContactPage.submitValid();

        assertEquals("Add Contact", addContactPage.getTitle());
        assertEquals("Invalid last name", addContactPage.getError());
    }

    @Test
    public void test_user_fills_in_empty_date() {
        HomePage logInPage = PageFactory.initElements(driver, HomePage.class);
        logInPage.login("joran", "j");

        AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

        addContactPage.setFirstNameField("Mark");
        addContactPage.setLastNamefield("Walberg");
        addContactPage.setDateField("");
        addContactPage.setHourField("08:55");
        addContactPage.setPhoneNumberField("0412456512");
        addContactPage.setEmailField("mark@ucll.be");
        addContactPage.submitValid();

        assertEquals("Add Contact", addContactPage.getTitle());
        assertEquals("Invalid date", addContactPage.getError());
    }

    @Test
    public void test_user_fills_in_empty_hour() {
        HomePage logInPage = PageFactory.initElements(driver, HomePage.class);
        logInPage.login("joran", "j");

        AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

        addContactPage.setFirstNameField("Mark");
        addContactPage.setLastNamefield("Walberg");
        addContactPage.setDateField("11-11-2020");
        addContactPage.setHourField("");
        addContactPage.setPhoneNumberField("0412456512");
        addContactPage.setEmailField("mark@ucll.be");
        addContactPage.submitValid();

        assertEquals("Add Contact", addContactPage.getTitle());
        assertEquals("Invalid hour", addContactPage.getError());
    }

    @Test
    public void test_user_fills_in_empty_phonenumber() {
        HomePage logInPage = PageFactory.initElements(driver, HomePage.class);
        logInPage.login("joran", "j");

        AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

        addContactPage.setFirstNameField("Mark");
        addContactPage.setLastNamefield("Walberg");
        addContactPage.setDateField("11-11-2020");
        addContactPage.setHourField("08:55");
        addContactPage.setPhoneNumberField("");
        addContactPage.setEmailField("mark@ucll.be");
        addContactPage.submitValid();

        assertEquals("Add Contact", addContactPage.getTitle());
        assertEquals("Invalid phone number", addContactPage.getError());
    }

    @Test
    public void test_user_fills_in_empty_email() {
        HomePage logInPage = PageFactory.initElements(driver, HomePage.class);
        logInPage.login("joran", "j");

        AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

        addContactPage.setFirstNameField("Mark");
        addContactPage.setLastNamefield("Walberg");
        addContactPage.setDateField("11-11-2020");
        addContactPage.setHourField("08:55");
        addContactPage.setPhoneNumberField("0412456512");
        addContactPage.setEmailField("");
        addContactPage.submitValid();

        assertEquals("Add Contact", addContactPage.getTitle());
        assertEquals("Invalid email", addContactPage.getError());
    }
}