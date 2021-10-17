package page;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-testid=\"logo-item\"]")
    private WebElement mailRuLogo;

    @FindBy(css = "[data-testid=\"login-input\"]")
    private WebElement inputLogin;

    @FindBy(xpath = "//button[@data-testid=\"enter-password\"]")
    private WebElement btnEnterPwd;

    @FindBy(css = "[data-testid=\"password-input\"]")
    private WebElement inputPwd;

    @FindBy(css = "[data-testid=\"login-to-mail\"]")
    private WebElement btnLogin;
}
