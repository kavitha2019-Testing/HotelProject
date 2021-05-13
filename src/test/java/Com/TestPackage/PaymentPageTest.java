package Com.TestPackage;

import Com.BasePackage.OpenBrowser;
import Com.PagesPackage.*;
import Com.UtilitiesPackage.JavaScriptconcepts;
import Com.UtilitiesPackage.ScreenshotUtility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PaymentPageTest  extends OpenBrowser {
    JavaScriptconcepts JS= new JavaScriptconcepts();

    static  HomePage HP;
    static SearchHotels SH;
    static SelectRoomPage SR;
    static ConfirmBookingPage CB;
    static PaymentPage PP ;
    static ScreenshotUtility SC;
    public PaymentPageTest() throws IOException {
    }
    @BeforeMethod
    public void paymentbrowser() throws IOException {
        SH = new SearchHotels();
        SR = new SelectRoomPage();
        CB = new ConfirmBookingPage();
        PP = new PaymentPage();
        SC= new ScreenshotUtility();
    }
    @Test
    public void paymentTest() throws InterruptedException, IOException {
        System.out.println("******* Payment Page *************");
        Thread.sleep(3000);
        System.out.println("Payment title is :"+ driver.getTitle());
        System.out.println("Payment current url is:"+ driver.getCurrentUrl());
        Thread.sleep(3000);
        String booksummarytext = PP.booksummarySel();
        System.out.println("Book suumary text is:"+ booksummarytext);
        Thread.sleep(3000);
        SC.screen("PaymentPage Screenshot");
        System.out.println("print num is:"+ 9/0.0); // output: Infinity
    }
}
