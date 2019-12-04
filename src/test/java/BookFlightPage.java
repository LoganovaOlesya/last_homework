import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookFlightPage {

    public BookFlightPage(final WebDriver driver) {
        wait = new WebDriverWait(driver, 10, 500);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void pageWaiting() {
        wait.until(ExpectedConditions.
                titleContains("Book a Flight"));
    }

    private Wait<WebDriver> wait;
    private WebDriver driver;

    //To dest string find
    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[1]/"
            + "b/font")
    WebElement strTo;

    //Date TO dest string find
    @FindBy(xpath = "(//td[@class = 'frame_header_info'])[2]/"
            + "b/font")
    WebElement strDateTo;

    //Airlines TO dest string find
    @FindBy(xpath = "(//td[@class = 'data_left'])[1]//b")
    WebElement strAirlinesTo;

    //Service class TO dest string find
    @FindBy(xpath = "(//td[@class = 'data_center_mono'])[1]/font")
    WebElement strServClassTo;

    //Price TO dest string find
    @FindBy(xpath = "(//td[@class = 'data_center'])[1]/font")
    WebElement strPriceTo;

    //From dest string find
    @FindBy(xpath = "(//td[@class = 'data_left'])[2]/b/font")
    WebElement strFrom;

    //Date From dest string find
    @FindBy(xpath = "(//td[@class = 'data_center_mono'])[2]/b/font")
    WebElement strDateFrom;

    //Airlines From dest find
    @FindBy(xpath = "(//td[@class = 'data_left'])[4]//b")
    WebElement strAirlinesFrom;

    //Service class From find
    @FindBy(xpath = "(//td[@class = 'data_center_mono'])[4]/font")
    WebElement strServClassFrom;

    //Price from find
    @FindBy(xpath = "(//td[@class = 'data_center'])[3]/font")
    WebElement strPriceFrom;

    //Pass count find
    @FindBy(xpath = "(//td[@class = 'data_left'])[6]/font")
    WebElement strPassCount;

    //Taxes find
    @FindBy(xpath = "(//td[@class = 'data_left'])[8]/font")
    WebElement strTaxes;

    //Total price find
    @FindBy(xpath = "(//td[@class = 'data_left'])[10]/font/b")
    WebElement strTotal;

    //passenger first name find
    @FindBy(xpath = "//input[@name = 'passFirst0']")
    WebElement passFirst;

    //passenger last name find
    @FindBy(xpath = "//input[@name = 'passLast0']")
    WebElement passLast;

    //passenger meal
    @FindBy(xpath = "//select[@name = 'pass.0.meal']")
    WebElement passMeal;

    //Credit card type find
    @FindBy(xpath = "//select[@name = 'creditCard']")
    WebElement creditCard;

    //Credit card number find
    @FindBy(xpath = "//input[@name = 'creditnumber']")
    WebElement creditNumber;

    //Credit card exp month find
    @FindBy(xpath = "//select[@name = 'cc_exp_dt_mn']")
    WebElement CCExpDtMn;

    //Credit card exp year find
    @FindBy(xpath = "//select[@name = 'cc_exp_dt_yr']")
    WebElement CCExpDtYr;

    //Cardholder first name find
    @FindBy(xpath = "//input[@name = 'cc_frst_name']")
    WebElement ccFirstName;

    //Cardholder mid name find
    @FindBy(xpath = "//input[@name = 'cc_mid_name']")
    WebElement ccMidName;

    //Cardholder last name find
    @FindBy(xpath = "//input[@name = 'cc_last_name']")
    WebElement ccLastName;

    //Bill address find
    @FindBy(xpath = "//input[@name = 'billAddress1']")
    WebElement billAddress;

    //Bill city find
    @FindBy(xpath = "//input[@name = 'billCity']")
    WebElement billCity;

    //Bill state find
    @FindBy(xpath = "//input[@name = 'billState']")
    WebElement billState;

    //Bill zip find
    @FindBy(xpath = "//input[@name = 'billZip']")
    WebElement billZip;

    //Bill country find
    @FindBy(xpath = "//select[@name = 'billCountry']")
    WebElement billCountry;

    //Same as Bill checkbox find
    @FindBy(xpath = "(//input[@value = 'checkbox'])[2]")
    WebElement sameAsBill;

    //Delivery address find
    @FindBy(xpath = "//input[@name = 'delAddress1']")
    WebElement delAddress;

    //Delivery city find
    @FindBy(xpath = "//input[@name = 'delCity']")
    WebElement delCity;

    //Delivery state find
    @FindBy(xpath = "//input[@name = 'delState']")
    WebElement delState;

    //Delivery zip find
    @FindBy(xpath = "//input[@name = 'delZip']")
    WebElement delZip;

    //Delivery country find
    @FindBy(xpath = "//select[@name = 'delCountry']")
    WebElement delCountry;

    //Secure purchase button find
    @FindBy(xpath = "//input[@name = 'buyFlights']")
    WebElement securePurchase;

    //Flight booking method realise
    public void bookFlight() {
        strTo.getText();
        strDateTo.getText();
        strAirlinesTo.getText();
        strServClassTo.getText();
        strPriceTo.getText();

        strFrom.getText();
        strDateFrom.getText();
        strAirlinesFrom.getText();
        strServClassFrom.getText();
        strPriceFrom.getText();

        strPassCount.getText();

        strTaxes.getText();
        strTotal.getText();
    }


    public void setPassengers(final String firstName, final String lastName,
                              final String meal) {
        passFirst.sendKeys(firstName);
        passLast.sendKeys(lastName);

        Select passMeals = new Select(passMeal);
        passMeals.selectByVisibleText(meal);
    }


    public void setCreditCard(final String typeCard, final String numberCard,
                              final String expMonth, final String expYear,
                              final String ccNameFirst, final String ccNameMid,
                              final String ccNameLast) {

        Select creditCardTypes = new Select(creditCard);
        creditCardTypes.selectByVisibleText(typeCard);
        creditNumber.sendKeys(numberCard);

        Select ccExpDtMn = new Select(CCExpDtMn);
        ccExpDtMn.selectByVisibleText(expMonth);

        Select ccExpDtYr = new Select(CCExpDtYr);
        ccExpDtYr.selectByValue(expYear);

        ccFirstName.sendKeys(ccNameFirst);
        ccMidName.sendKeys(ccNameMid);
        ccLastName.sendKeys(ccNameLast);

    }


    public void setBillAddress(final String addressBill,
                               final String cityBill, final String stateBill,
                               final String zipBill, final String countryBill) {
        billAddress.clear();
        billAddress.sendKeys(addressBill);
        billCity.clear();
        billCity.sendKeys(cityBill);
        billState.clear();
        billState.sendKeys(stateBill);
        billZip.clear();
        billZip.sendKeys(zipBill);

        Select billCountries = new Select(billCountry);
        billCountries.selectByVisibleText(countryBill);

    }


    public void setDeliveryAddress(final String addressDel,
                                   final String cityDel, final String stateDel,
                                   final String zipDel,
                                   final String countryDel) {
        sameAsBill.click();
        delAddress.clear();
        delAddress.sendKeys(addressDel);
        delCity.clear();
        delCity.sendKeys(cityDel);
        delState.clear();
        delState.sendKeys(stateDel);
        delZip.clear();
        delZip.sendKeys(zipDel);

        Select delCountries = new Select(delCountry);
        delCountries.selectByVisibleText(countryDel);

        securePurchase.click();
    }
}
