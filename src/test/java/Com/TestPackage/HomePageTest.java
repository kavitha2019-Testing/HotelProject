package Com.TestPackage;

import Com.BasePackage.OpenBrowser;
import Com.PagesPackage.HomePage;
import Com.UtilitiesPackage.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HomePageTest  extends OpenBrowser {

    static HomePage HP;
    static JavaScriptconcepts JS;
    static WaitCommands Wc;
    static Sel4Image SI;
    static dimensions DM;
    static ScreenshotUtility SC;
    public HomePageTest() throws IOException {
    }

    @BeforeMethod
    public static void Lbrowser() throws InterruptedException, IOException {
        launchbrowser();
        HP = new HomePage();
        JS = new JavaScriptconcepts();
        Wc = new WaitCommands();
        SI = new Sel4Image();
        DM = new dimensions();
        SC = new ScreenshotUtility();
    }

    @Test(enabled = false)
    public static void title() throws InterruptedException {
        String tle = driver.getTitle();
        Thread.sleep(5000);
        System.out.println("print title is:" + tle);
        Assert.assertEquals("Boutique Hotel Breaks & Luxury Accommodation | Mr & Mrs Smith", tle);
    }

    @Test(enabled = false)
    public static void Clogo() {
        Boolean B = HP.image();
        Assert.assertTrue(B);
    }

    @Test()
    public void stext() throws InterruptedException, IOException {
        System.out.println("***************HomePage ***********************");
        System.out.println("Entered search text");
        Thread.sleep(2000);
        HP.search(prop.getProperty("SearchText"));
        WebElement E = HP.Indateclick();
        JS.scrollIntoView(E, driver);
        // DM.Diemen(E); // dimensions of webelement using selenium4
        E.click();
        System.out.println("Entered checkIN section");
        String INmonth = HP.Indatesel();
        //Wc.fluwait(E);  // fluent wait used but not working
        WebElement next;
        while ((!INmonth.contains(prop.getProperty("CheckInM")))) {
            next = HP.clickIndateselect();
            next.click();
            Thread.sleep(2000);
            INmonth = HP.Indatesel();
        }
        List<WebElement> e =  HP.selectIndate();
        for (WebElement num : e) {
            if (num.getText().contains(prop.getProperty("CheckInDate"))) {
                num.click();
                Thread.sleep(2000);
                System.out.println(" checkIn date is:" + num.getText());
                break;
            }
        }
        // SI.Image4web("webelemimage");// using selenuium 4
        Thread.sleep(2000);
        // SI.Image4(E,"checkIn");  // using seleium4
        System.out.println("Entered checkOut section");
        String OutMonth = HP.Outdatesel().trim();
        WebElement next1;
        while ((!OutMonth.contains(prop.getProperty("CheckOutM")))) {
            Thread.sleep(2000);
           // next1 = driver.findElement(By.xpath("//div[@class='next-month']"));
            next1 = HP.Indateclick();
            next1.click();
            Thread.sleep(2000);
            OutMonth = HP.Outdatesel().trim();
        }
        List<WebElement> e1 = HP.selectIndate();
        for (WebElement num1 : e1) {
            if (num1.getText().contains(prop.getProperty("CheckOutDate"))) {
                Thread.sleep(2000);
                num1.click();
                Thread.sleep(2000);
                // System.out.println("checkout date is:" + num1.getText());
                break; }
        }
        // SI.wholeimage(driver,"wholepic"); using selenium4
        Thread.sleep(2000);
        System.out.println("Entered Adult num section");
        WebElement adultno = HP.adultnosel();
        adultno.click();
        Thread.sleep(2000);
        //String num = prop.getProperty("AdultNo");
        //int n = Integer.parseInt(num);
        for (int i = 2; i <= 20; i++) {
            if (i == 3) {
                System.out.println("Adult number selected:" + i);
                break;
            } else {
                WebElement button = HP.clickadultno();
                Thread.sleep(2000);
                button.click();
                Thread.sleep(2000); }
        }
        //  SI.Image4(adultno,"adultNoimgae");
        System.out.println("child number selected");
        WebElement childno = HP.choldnosel();
        Thread.sleep(2000);
        childno.click();
        Thread.sleep(2000);
        for (int j = 0; j <= 10; j++) {
            if (j == 1) {
                System.out.println("child age selected:" + j);
                break;
                    }
            else {
                WebElement button1 = driver.findElement(By.cssSelector("#globalSearch > div.c-occupancy.clearfix > " +
                        "div.c-occupancy__selector.c-occupancy__selector--children > div > div > div > " +
                        "button.c-ui-button.c-ui-button--quantity.c-ui-button--quantity-increment"));
                Thread.sleep(2000);
                button1.click();
            }
        }
        HP.clickchildage().click();
        Thread.sleep(2000);
        List<WebElement> age = HP.selchildage();
        System.out.println("list of age selected");
        for(WebElement cage:age){
            if (cage.getText().trim().contains(prop.getProperty("cage1"))) {
                cage.click();
                System.out.println("age selected");
                Thread.sleep(2000);
                SC.screen("HomepageScreenshot");
                System.out.println("Homopoage screenshot ");
                HP.clickSearch();
                Thread.sleep(2000);

            }
        }
    }
}

       /* @AfterMethod
    public void close(){
        driver.close();
}*/
