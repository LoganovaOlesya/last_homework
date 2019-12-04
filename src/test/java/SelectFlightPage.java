import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SelectFlightPage {

    SelectFlightPage(final WebDriver driver) {
        wait = new WebDriverWait(driver,  10, 500);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private Wait<WebDriver> wait;
    WebDriver driver;

    //Depart
    @FindBy(xpath = "(//form[@method = 'post']//td[@class = 'title'])[3]//font")
    WebElement strDepart;

    // Depart date
    @FindBy(xpath = "(//form[@method = 'post']//td[@class = 'title'])[4]//font")
    WebElement strDepartDate;

    //Depart airlines
    @FindBy(xpath = "(//input[@name = 'outFlight'])[4]")
    WebElement departAirlines;

    //Depart price
    @FindBy(xpath = "(//td[@class = 'data_verb_xcols']//b)[4]")
    WebElement strDepartPrice;

    //Return
    @FindBy(xpath = "(//form[@method = 'post']//td[@class = 'title'])[7]//font")
    WebElement strReturn;

    //Return date
    @FindBy(xpath = "(//form[@method = 'post']//td[@class = 'title'])[8]//font")
    WebElement strReturnDate;

    //Return airlines
    @FindBy(xpath = "(//input[@name = 'inFlight'])[2]")
    WebElement returnAirlines;

    //Return price
    @FindBy(xpath = "(//td[@class = 'data_verb_xcols']//b)[6]")
    WebElement strReturnPrice;

    //Continue button
    @FindBy(xpath = "//input[@name = 'reserveFlights']")
    WebElement reserveFlights;

    public void selectFlight() {
        strDepart.getText();
        strDepartDate.getText();
        departAirlines.click();
        strDepartPrice.getText();

        strReturn.getText();
        strReturnDate.getText();
        returnAirlines.click();
        strReturnPrice.getText();

        reserveFlights.click();
    }

    public void pageWaiting() {
        wait.until(ExpectedConditions.
                titleContains("Select a Flight"));
    }
}
