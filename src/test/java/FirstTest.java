import org.hamcrest.MatcherAssert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class FirstTest {

    private static WebDriver drv;

    private static int parsedTaxes;
    private static int parsedTotal;

    private static HomePage homePage;
    private static FlightFinderPage flightFinderPage;
    private static SelectFlightPage selectFlightPage;
    private static BookFlightPage bookFlightPage;
    private static FlightConfirmationPage flightConfirmationPage;

    private static final String LOGIN = "test1";
    private static final String PASSWORD = "test1";

    private static final String PASS_COUNT = "1";

    private static final String PORT_FROM = "New York";
    private static final String PORT_TO = "Seattle";

    private static final String MONTH_FROM = "11";
    private static final String MONTH_TO = "12";

    private static final String DAY_FROM = "20";
    private static final String DAY_TO = "19";

    private static final String AIRLINES = "Pangea Airlines";

    private static final String CC_FIRST = "Elon";
    private static final String CC_MID = "Ivanovich";
    private static final String CC_LAST = "Musk";

    private static final String CC_NUMBER = "5479540454132487";
    private static final String CC_TYPE = "Visa";
    private static final String CC_EXP_MONTH = "05";
    private static final String CC_EXP_YEAR = "2009";

    private static final String FIRST_PASS_NAME = CC_FIRST;
    private static final String FIRST_PASS_LAST = CC_LAST;

    private static final String FIRST_PASS_MEAL = "Vegetarian";

    private static final String BILL_ADDRESS = "1085 Borregas Ave.";
    private static final String BILL_CITY = "Albuquerque";
    private static final String BILL_STATE = "New Mexico";
    private static final String BILL_ZIP = "94089";
    private static final String BILL_COUNTRY = "UNITED STATES";

    private static final String DEL_ADDRESS = "1225 Borregas Ave.";
    private static final String DEL_CITY = "Boston";
    private static final String DEL_STATE = "Massachusetts";
    private static final String DEL_ZIP = "91089";
    private static final String DEL_COUNTRY = "UNITED STATES";

    private static final int TAXES = 42;

    public FirstTest() {
        System.out.print("Constructor created");
    }

    @BeforeClass
    public static void setUp() {
        System.out.println("@BeforeClass static method invoked. WebDriver initialising, preconditioned.");

        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");

        drv = new ChromeDriver();

        //EventFiringWebDriver init using Chrome WebDriver instance
        drv = new EventFiringWebDriver(drv);

        ((EventFiringWebDriver) drv).register(new EventHandler());

        // Window maximizing
        drv.manage().window().maximize();

        //Create page objects and save it to vars
        homePage = new HomePage(drv);

        flightFinderPage = new FlightFinderPage(drv);
        selectFlightPage = new SelectFlightPage(drv);
        bookFlightPage = new BookFlightPage(drv);
        flightConfirmationPage = new FlightConfirmationPage(drv);

        //Page open
        drv.get("http://newtours.demoaut.com");
        homePage.pageWaiting();
    }


    @Test
    public void test() {

        //sign in
        homePage.signInAs(LOGIN, PASSWORD);

        flightFinderPage.pageWaiting();

        // Find a Flight Page opened assertion
        MatcherAssert.assertThat("Houston, we have a problem - login failed or timeout",
                drv.getTitle().contains("Find a Flight"));

        flightFinderPage.findFlightsFrom(PASS_COUNT, PORT_FROM, MONTH_FROM, DAY_FROM);

        flightFinderPage.findFlightsIn(PORT_TO, MONTH_TO, DAY_TO);

        flightFinderPage.setPreferences(AIRLINES);

        selectFlightPage.pageWaiting();

        //Select a Flight Page opened assertion
        MatcherAssert.assertThat("Can`t open page 'Select a Flight!'",
                drv.getTitle().contains("Select a Flight"));

        MatcherAssert.assertThat("Incorrect departing!",
                selectFlightPage.strDepart.getText().contains("New York to Seattle"));

        MatcherAssert.assertThat("Incorrect departing date!",
                selectFlightPage.strDepartDate.getText().contains("11/20/"));

        selectFlightPage.departAirlines.click();

        MatcherAssert.assertThat("Incorrect returning destination!",
                selectFlightPage.strReturn.getText().
                        contains("Seattle to New York"));

        MatcherAssert.assertThat("Incorrect returning date!",
                selectFlightPage.strReturnDate.getText().
                        contains("12/19/"));

        selectFlightPage.returnAirlines.click();
        selectFlightPage.strReturnPrice.getText();

        selectFlightPage.reserveFlights.click();
        bookFlightPage.pageWaiting();

        MatcherAssert.assertThat("Can`t open page Book a Flight!",
                drv.getTitle().contains("Book a Flight"));

        MatcherAssert.assertThat("Incorrect departing destination!",
                bookFlightPage.strTo.getText().contains("New York to Seattle"));

        MatcherAssert.assertThat("Incorrect departing to date!",
                bookFlightPage.strDateTo.getText().contains("11/20/"));

        MatcherAssert.assertThat("Incorrect carrier!",
                bookFlightPage.strAirlinesTo.getText().contains("363"));

        MatcherAssert.assertThat("Incorrect class!",
                bookFlightPage.strServClassTo.getText().contains("First"));

        MatcherAssert.assertThat("Incorrect price!",
                bookFlightPage.strPriceTo.getText().contains("281"));

        int parsePriceTo = Integer.parseInt(bookFlightPage.strPriceTo.
                getText());

        MatcherAssert.assertThat("Incorrect returning!",
                bookFlightPage.strFrom.getText().contains("Seattle to New York"));

        MatcherAssert.assertThat("Incorrect returning from date!",
                bookFlightPage.strDateFrom.getText().contains("12/19/"));

        MatcherAssert.assertThat("Incorrect carrier!",
                bookFlightPage.strAirlinesFrom.getText().contains("631"));

        MatcherAssert.assertThat("Incorrect class!",
                bookFlightPage.strServClassFrom.getText().contains("First"));

        MatcherAssert.assertThat("Incorrect price!",
                bookFlightPage.strPriceFrom.getText().contains("273"));

        int parsePriceFrom = Integer.parseInt(bookFlightPage.strPriceFrom.
                getText());

        MatcherAssert.assertThat("Incorrect number of passengers!",
                bookFlightPage.strPassCount.getText().contains("1"));

        parsedTaxes = Integer.parseInt(bookFlightPage.strTaxes.getText().substring(1));

        MatcherAssert.assertThat("Incorrect taxes!", parsedTaxes != TAXES);

        parsedTotal = Integer.parseInt(bookFlightPage.strTotal.getText().substring(1));


        int parsedSummary = parsePriceFrom + parsePriceTo + parsedTaxes;
        MatcherAssert.assertThat("Incorrect total price including taxes!", parsedTotal == parsedSummary);

        bookFlightPage.bookFlight();

        bookFlightPage.setPassengers(FIRST_PASS_NAME, FIRST_PASS_LAST, FIRST_PASS_MEAL);

        bookFlightPage.setCreditCard(CC_TYPE, CC_NUMBER, CC_EXP_MONTH,
                CC_EXP_YEAR, CC_FIRST, CC_MID, CC_LAST);

        bookFlightPage.setBillAddress(BILL_ADDRESS, BILL_CITY, BILL_STATE,
                BILL_ZIP, BILL_COUNTRY);

        bookFlightPage.setDeliveryAddress(DEL_ADDRESS, DEL_CITY, DEL_STATE,
                DEL_ZIP, DEL_COUNTRY);

        flightConfirmationPage.pageWaiting();

        //light confirmation page opened assertion
        MatcherAssert.assertThat("Can`t open page Flight Confirmation or Timeout!",
                drv.getTitle().contains("Flight Confirmation"));

        MatcherAssert.assertThat("Incorrect departing destination!",
                flightConfirmationPage.strTo.getText().contains("New York to Seattle"));

        MatcherAssert.assertThat("Incorrect departing date!",
                flightConfirmationPage.strDateTo.getText().contains("11/20/"));

        MatcherAssert.assertThat("Incorrect departing carrier!",
                flightConfirmationPage.strAirlinesTo.getText().
                        contains("Unified Airlines 363"));

        MatcherAssert.assertThat("Incorrect returning destination!",
                flightConfirmationPage.strFrom.getText().
                        contains("Seattle to New York"));

        MatcherAssert.assertThat("Incorrect returning date!",
                flightConfirmationPage.strDateFrom.getText().
                        contains("12/19"));

        MatcherAssert.assertThat("Incorrect returning carrier!",
                flightConfirmationPage.strAirlinesFrom.getText().
                        contains("Blue Skies Airlines 631"));

        int parsedPriceTo = Integer.parseInt(flightConfirmationPage.
                strPriceTo.getText().split("\\$")[1].
                replaceAll("[^0-9]", ""));

        int parsedPriceFrom = Integer.parseInt(flightConfirmationPage.
                strPriceFrom.getText().split("\\$")[1].
                replaceAll("[^0-9]", ""));

        int parseTaxes = Integer.parseInt(flightConfirmationPage.
                strTotalTaxes.getText().replaceAll("[^0-9]", ""));

        int parseTotal = parsedPriceFrom + parsedPriceTo + parseTaxes;

        MatcherAssert.assertThat("Incorrect number of passengers!",
                flightConfirmationPage.strPassCount.getText().contains("1"));

        MatcherAssert.assertThat("Incorrect billing receiver!",
                flightConfirmationPage.strBillTo.getText().
                        contains("Elon Ivanovich Musk"));

        MatcherAssert.assertThat("Incorrect billing street!",
                flightConfirmationPage.strBillTo.getText().
                        contains("1085 Borregas Ave."));

        MatcherAssert.assertThat("Incorrect billing address!",
                flightConfirmationPage.strBillTo.getText().
                        contains("Albuquerque, New Mexico, 94089"));

        MatcherAssert.assertThat("Incorrect delivery street!",
                flightConfirmationPage.strDelTo.getText().
                        contains("1225 Borregas Ave."));

        MatcherAssert.assertThat("Incorrect delivery address!",
                flightConfirmationPage.strDelTo.getText().
                        contains("Boston, Massachusetts, 91089"));

        int parseTotalPrice = Integer.parseInt(flightConfirmationPage.
                strTotalPrice.getText().replaceAll("[^0-9]", ""));

        //Total price assertion
        MatcherAssert.assertThat("Incorrect total price,",
                parseTotalPrice == parseTotal);

        //Back to Home button click
        flightConfirmationPage.backToHome.click();

        homePage.pageWaiting();

        //HomePage is opened assertion
        MatcherAssert.assertThat("Can`t open home page!",
                drv.getTitle().contains("Welcome"));
    }
    //Close WebDriver, post-conds
    @AfterClass
    public static void afterClassMethod() {
        drv.close();
    }
}
