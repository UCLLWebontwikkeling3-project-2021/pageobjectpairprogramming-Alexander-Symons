package PageObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;

/**
 * @author Lukas De Ruysscher
 * @version Alexander Symons
 */

public class PersonOverviewTest {
    private WebDriver driver;
    private String path = "http://localhost:8080/pageobjectpairprogramming_DJLukeD_war/Controller";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\UCLL\\Webontwikkeling 3\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test

    public void test_User_Not_Logged_In_Shows_Error(){
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertEquals("Home", personOverviewPage.getTitle());
        assertEquals("You are not authorized to go to this page of the website!", personOverviewPage.getError());
    }

    @Test
    public void test_User_Is_Logged_In_But_Has_No_Rights_To_Access_Page(){
        HomePage loginPage = PageFactory.initElements(driver, HomePage.class);
        loginPage.login("joran", "j");
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertEquals("Home", personOverviewPage.getTitle());
        assertEquals("You are not authorized to go to this page of the website!", personOverviewPage.getError());
    }

    @Test
    public void test_User_Is_Admin_And_Shows_Overview(){
        HomePage loginPage = PageFactory.initElements(driver, HomePage.class);
        loginPage.login("admin", "a");
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);

        assertEquals("Overview", personOverviewPage.getTitle());
        assertTrue(personOverviewPage.containsUserWithEmail("joran.van.grunderbeek@gmail.com"));
        assertTrue(personOverviewPage.containsUserWithFirstname("joran"));
        assertTrue(personOverviewPage.containsUserWithLastname("van grunderbeek"));
        assertTrue(personOverviewPage.containsUserWithEmail("admin@gmail.com"));
        assertTrue(personOverviewPage.containsUserWithFirstname("admin"));
        assertTrue(personOverviewPage.containsUserWithLastname("admin"));
    }
}