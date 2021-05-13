package Com.TestPackage;

import Com.BasePackage.OpenBrowser;
import Com.PagesPackage.ConfirmBookingPage;
import Com.PagesPackage.HomePage;
import Com.PagesPackage.SearchHotels;
import Com.PagesPackage.SelectRoomPage;
import Com.UtilitiesPackage.JavaScriptconcepts;
import Com.UtilitiesPackage.ScreenshotUtility;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ConfirmBookingPageTest  extends OpenBrowser {
    JavaScriptconcepts JS = new JavaScriptconcepts();

    static HomePage HP;
    static SearchHotels SH;
    static SelectRoomPage SR;
    static ConfirmBookingPage CB;
    static ScreenshotUtility SC;

    public ConfirmBookingPageTest() throws IOException {
    }
    @BeforeMethod
    public static void bookingbrowser() throws InterruptedException, IOException {
        HP = new HomePage();
        SH = new SearchHotels();
        SR = new SelectRoomPage();
        CB = new ConfirmBookingPage();
        SC= new ScreenshotUtility();

    }
    @Test
    public void bookingPage() throws InterruptedException, IOException {
        Thread.sleep(3000);
        System.out.println("**************** Confirm bookimg page is ******************");
        System.out.println("Current booking page title is: "+driver.getTitle());
        System.out.println("current booking page url is :"+ driver.getCurrentUrl());
        String btext = CB.baskettextsel();
        System.out.println("Basket text is:"+ btext);
        Thread.sleep(3000);
        SC.screen("ConfirmBookingPageTest Screenshot");
        CB.confirmbookingsel();
    }
}
