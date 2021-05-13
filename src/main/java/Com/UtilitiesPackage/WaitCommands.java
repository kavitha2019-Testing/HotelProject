package Com.UtilitiesPackage;

import Com.BasePackage.OpenBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.time.Duration;

public class WaitCommands  extends OpenBrowser {

    public WaitCommands() throws IOException {
    }

    public  static void fluwait(WebElement ele){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofMillis(20))
                .pollingEvery(Duration.ofMillis(2))
                .withMessage("Fluent wait used")
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated((By) ele));
    }
}
