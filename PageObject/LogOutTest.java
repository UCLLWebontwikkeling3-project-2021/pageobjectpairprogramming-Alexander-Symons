package PageObject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Alexander Symons
 */

public class LogOutTest {

    private WebDriver driver;

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
    public void test_Logged_In_User_Can_Log_Out_By_Clicking_The_Logout_Button() {
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.setUserid("joran");
        home.setPassword("j");
        home.logIn();
        home.logOut();
        Assert.assertEquals("Home", home.getTitle());
    }

    @Test
    public void test_After_Logging_Out_The_User_Gets_A_Succes_Message() {
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.setUserid("joran");
        home.setPassword("j");
        home.logIn();
        home.logOut();
        Assert.assertEquals("You have logged out", home.getSucces());
    }

    @Test
    public void test_If_Not_Logged_In_User_Logs_Out_A_Not_Authorized_Message_Pops_Up() {
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        driver.get(home.getPath() + "Controller?command=LogOut");
        Assert.assertEquals("You are not authorized to go to this page of the website!", home.getError());
    }
}
