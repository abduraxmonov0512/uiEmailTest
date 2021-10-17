import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;
import page.PersonalPage;
import page.modals.PersonalPageSendMsgModal;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public abstract class BaseTest {

    public static WebDriver driver;
    protected HomePage homePage;
    protected PersonalPage personalPage;
    protected PersonalPageSendMsgModal personalPageSendMsgModal;


    @BeforeMethod
    public void beforeMethod(){
        driver = new DriverFactory().createInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        createPages();
    }


    @AfterMethod
    public void quiteDriver(){
        driver.quit();
    }

    public void createPages(){
        homePage = new HomePage(driver);
        personalPage = new PersonalPage(driver);
        personalPageSendMsgModal = new PersonalPageSendMsgModal(driver);
    }
}
