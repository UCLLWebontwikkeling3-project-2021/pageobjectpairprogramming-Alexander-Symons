package PageObject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Hendrik Rummens
 * @version Alexander Symons
 */

public class LogInTest {
    private WebDriver driver;
    //TODO change the path below if necessary
    private String path = "http://localhost:8081/Opdracht1_war_exploded/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\UCLL\\Webontwikkeling 3\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(path+"?command=Index");
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_login_with_valid_info(){
        //TODO change the user id below to the correct user name of an administrator
        String userid = "admin";
        //TODO change the password below to the correct password that matches with the user id above
        String password = "a";
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.setUserid(userid);
        home.setPassword(password);

        home.logIn();

        //TODO change below the correct title when the admin user will be logged in.
        Assert.assertEquals("Home", home.getH2());
    }

    @Test
    public void test_login_with_invalid_info(){
        String userid = "administrator";
        String password = "wrongPassword";
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.setUserid(userid);
        home.setPassword(password);
        home.logIn();

        Assert.assertEquals("User does not exist", home.getError());
    }

    @Test
    public void test_login_with_invalid_password(){
        String userid = "admin";
        String password = "wrongPassword";
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.setUserid(userid);
        home.setPassword(password);
        home.logIn();

        Assert.assertEquals("No valid userid/password", home.getError());
    }

    @Test
    public void test_login_with_empty_password(){
        String userid = "admin";
        String password = "";
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.setUserid(userid);
        home.setPassword(password);
        home.logIn();

        Assert.assertEquals("User does not exist", home.getError());
    }

    @Test
    public void test_login_with_empty_userId(){
        String userid = "";
        String password = "password";
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.setUserid(userid);
        home.setPassword(password);
        home.logIn();

        Assert.assertEquals("User does not exist", home.getError());
    }
}
