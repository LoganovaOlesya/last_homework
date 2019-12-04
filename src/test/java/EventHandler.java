import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import java.util.logging.Logger;

//Listener
public class EventHandler implements WebDriverEventListener {

    //Listener
    Logger LOGGER = Logger.getLogger(EventHandler.class.getName());


    public void afterChangeValueOf(final WebElement webElement,
                                   final WebDriver webDriver) {
        LOGGER.info("Value changed");
    }

    public void afterClickOn(final WebElement webElement,
                             final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("inside method afterClickOn on "
                + webElement.toString());
    }

    public void beforeChangeValueOf(final WebElement webElement,
                                    final WebDriver webDriver,
                                    final CharSequence[] charSequences) {
         LOGGER.info("Value of " + webElement
                 + " changed to " + charSequences);
    }

    public void afterChangeValueOf(final WebElement webElement,
                                   final WebDriver webDriver,
                                   final CharSequence[] charSequences) {

    }


    public void afterFindBy(final By by,
                            final WebElement str,
                            final WebDriver webDriver) {
        LOGGER.info("Element found");
    }


    public void afterNavigateBack(final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("Inside the after navigate back to "
                + webDriver.getCurrentUrl());
    }

    public void afterNavigateForward(final WebDriver webDriver) {
        // TODO Auto-generated method stub
       System.out.println("Inside the afterNavigateForward to "
                + webDriver.getCurrentUrl());
    }


    public void beforeNavigateRefresh(final WebDriver webDriver) {

    }

    public void afterNavigateRefresh(final WebDriver webDriver) {

    }

    public void afterNavigateTo(final String str,
                                final WebDriver webDriver) {
        LOGGER.info("Transition completed");
    }

    public void afterScript(final String str,
                            final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("Inside the afterScript to, Script is " + webDriver);
    }

    public void beforeSwitchToWindow(final String str,
                                     final WebDriver webDriver) {

    }

    public void afterSwitchToWindow(final String str,
                                    final WebDriver webDriver) {
    }


    public void beforeChangeValueOf(final WebElement webElement,
                                    final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("Inside the beforeChangeValueOf method");
    }

    public void beforeClickOn(final WebElement webElement,
                              final WebDriver webDriver) {
        LOGGER.info("Click on element " + webElement);
    }


    public void beforeFindBy(final By by,
                             final WebElement str,
                             final WebDriver webDriver) {
        LOGGER.info("Before finding element by " + by);
    }

    public void beforeNavigateBack(final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("Just before beforeNavigateBack "
                + webDriver.getCurrentUrl());
    }

    public void beforeNavigateForward(final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("Just before beforeNavigateForward "
                + webDriver.getCurrentUrl());
    }

    public void beforeAlertAccept(final WebDriver webDriver) {
    }

    public void afterAlertAccept(final WebDriver webDriver) {
    }

    /** by default.*/
    public void afterAlertDismiss(final WebDriver webDriver) {
    }

    /** by default.*/
    public void beforeAlertDismiss(final WebDriver webDriver) {

    }

    /** Before navigate to message.*/
    public void beforeNavigateTo(final String str,
                                 final WebDriver webDriver) {
        LOGGER.info("Transition to" + str + "");
    }

    /** by default.*/
    public void beforeScript(final String str,
                             final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("Just before beforeScript "
                + webDriver);
    }

    public void onException(final Throwable throwable,
                            final WebDriver webDriver) {
        // TODO Auto-generated method stub
        System.out.println("Exception occured at "
                + throwable.getMessage());
    }

    public <X> void beforeGetScreenshotAs(final OutputType<X> outputType) {
    }

    public <X> void afterGetScreenshotAs(final OutputType<X> outputType,
                                         final X x) {
    }

    public void beforeGetText(final WebElement webElement,
                              final WebDriver webDriver) {
    }


    public void afterGetText(final WebElement webElement,
                             final WebDriver webDriver,
                             final String str) {
    }

}