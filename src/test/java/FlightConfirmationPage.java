import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlightConfirmationPage {

    public FlightConfirmationPage(final WebDriver driver) {
        wait = new WebDriverWait(driver,  10,
                 500);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void pageWaiting() {
        wait.until(ExpectedConditions.
                titleContains("Flight Confirmation"));
    }


    private Wait<WebDriver> wait;
    public WebDriver driver;

    //String To
    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[3]/font/b")
    WebElement strTo;

    //String Date to
    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[3]/font")
    WebElement strDateTo;

    //String Airlines to
    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[3]/font")
    WebElement strAirlinesTo;

    //String Price to
    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[3]/font")
    WebElement strPriceTo;

    //String From
    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[5]/font/b")
    WebElement strFrom;

    //String Date from
    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[5]/font")
    WebElement strDateFrom;

    //String Airlines from
    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[5]/font")
    WebElement strAirlinesFrom;

    //String Price from
    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[5]/font")
    WebElement strPriceFrom;

    //String Passengers
    @FindBy(xpath = "(//td[@class = 'data_left'])[2]/font")
    WebElement strPassCount;

    //String Bill to
    @FindBy(xpath = "((//p)[5]/font)[1]")
    WebElement strBillTo;

    //String Delivery to
    @FindBy(xpath = "(//p)[6]/font")
    WebElement strDelTo;

    //tring Total Taxes
    @FindBy(xpath = "((//td[@class = 'data_left'])[3]//font)[7]")
    WebElement strTotalTaxes;

    //String Total price
    @FindBy(xpath = "((//td[@class = 'data_left'])[3]//font)[14]")
    WebElement strTotalPrice;

    //Back to Home button
    @FindBy(xpath = "(//a)[13]")
    WebElement backToHome;

    //Flight confirmation method
    public void flightConfirmation() {
        strTo.getText();
        strDateTo.getText();
        strAirlinesTo.getText();
        strPriceTo.getText();

        strFrom.getText();
        strDateFrom.getText();
        strAirlinesFrom.getText();
        strPriceFrom.getText();

        strPassCount.getText();
        strBillTo.getText();
        strDelTo.getText();
        strTotalTaxes.getText();
        strTotalPrice.getText();

        backToHome.click();
    }
}
