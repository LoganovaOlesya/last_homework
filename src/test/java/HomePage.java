//package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public HomePage(final WebDriver driver) {
        wait = new WebDriverWait(driver, 10,
                500);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private Wait<WebDriver> wait;

    public WebDriver driver;

    @FindBy(xpath = "//input[@name = 'userName']")
    WebElement loginField;

    @FindBy(xpath = "//input[@name = 'password'][@type = 'password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@name = 'login'][@value = 'Login']")
    WebElement signInButton;

    public void pageWaiting() {
        wait.until(ExpectedConditions.
                titleContains("Welcome"));
    }

    public void signInAs(final String login, final String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();
    }
}
