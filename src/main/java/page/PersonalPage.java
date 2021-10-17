package page;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class PersonalPage{

    private WebDriver driver;

    public PersonalPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "[data-testid=\"whiteline-account\"]")
    private WebElement accLabel;

    @FindBy(css = "[href=\"/compose/\"]")
    private WebElement btnWriteMessage;


}
