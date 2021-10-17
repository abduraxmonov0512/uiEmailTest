import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import utils.PropertyLoader;

public class Tests extends BaseTest {


    @Test
    public void testSendMessage() throws Exception {

        //Open page
        driver.get(PropertyLoader.returnConfigValue("url"));
        boolean logoPresent = homePage.getMailRuLogo().isDisplayed();
        Assert.assertTrue(logoPresent);

        //Login
        homePage.getInputLogin().isDisplayed();
        homePage.getInputLogin().sendKeys(PropertyLoader.returnConfigValue("login"));
        homePage.getBtnEnterPwd().click();
        homePage.getInputPwd().isDisplayed();
        homePage.getInputPwd().sendKeys(PropertyLoader.returnConfigValue("password"));
        homePage.getBtnLogin().click();
        String accName = personalPage.getAccLabel().getText();
        Assert.assertEquals(accName, PropertyLoader.returnConfigValue("login") + "@mail.ru");

        //send message
        personalPage.getBtnWriteMessage().click();
        boolean inputPresent = personalPageSendMsgModal.getInputTo().isDisplayed();
        Assert.assertTrue(inputPresent);

        personalPageSendMsgModal.getInputTo().sendKeys(PropertyLoader.returnConfigValue("login") + "@mail.ru");
        personalPageSendMsgModal.getInputSubject().sendKeys("Test message");
        personalPageSendMsgModal.getEditMsg().sendKeys("test");
        personalPageSendMsgModal.getBtnSendMessage().click();

        boolean tvMessageSends = personalPageSendMsgModal.getTvMessageSend().isDisplayed();
        Assert.assertTrue(tvMessageSends);

    }
}
