package page.modals;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Data
public class PersonalPageSendMsgModal {

    private WebDriver driver;

    public PersonalPageSendMsgModal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@data-type=\"to\"]//input")
    private WebElement inputTo;

    @FindBy(name = "Subject")
    private WebElement inputSubject;

    @FindBy(css = "[aria-multiline=\"true\"]")
    private WebElement editMsg;

    @FindBy(xpath = "//span[text()='Отправить']")
    private WebElement btnSendMessage;

    @FindBy(xpath = "//a[text()='Письмо отправлено']")
    private WebElement tvMessageSend;
}
