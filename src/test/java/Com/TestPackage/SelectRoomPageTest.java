package Com.TestPackage;

import Com.BasePackage.OpenBrowser;
import Com.PagesPackage.HomePage;
import Com.PagesPackage.SearchHotels;
import Com.PagesPackage.SelectRoomPage;
import Com.UtilitiesPackage.JavaScriptconcepts;
import Com.UtilitiesPackage.ScreenshotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SelectRoomPageTest  extends OpenBrowser {
    JavaScriptconcepts JS = new JavaScriptconcepts();

    static HomePage HP;
    static SearchHotels SH;
    static SelectRoomPage SR;
    static ScreenshotUtility SC;
    public SelectRoomPageTest() throws IOException {
    }

    @BeforeMethod
    public static void Sbrowser() throws InterruptedException, IOException {
        HP = new HomePage();
        SH = new SearchHotels();
        SR = new SelectRoomPage();
        SC= new ScreenshotUtility();
    }
    @Test
    public void selectRoom() throws InterruptedException, IOException {
        Thread.sleep(10000);
        System.out.println("**************Select Room Page *****************");
        String txt =  SR.selectDatestext();
        System.out.println("Selected dates text is:" + txt);
        Thread.sleep(5000);
        System.out.println("get room selection title is:" + driver.getTitle());
        String title = driver.getTitle();
       // Assert.assertEquals(title,"Rooms & suites at I Qs - Venice");
        System.out.println("get Room selection  url :" + driver.getCurrentUrl());
       // WebElement bookroom = driver.findElement(By.xpath("//*[@id='room-11480-rates']/article[2]/div[3]/div[2]/a"));
        WebElement bookroom = driver.findElement(By.xpath("//*[@id='room-6837-rates']/div/article/div[3]/div[2]/a"));
        // //*[@id="room-6837-rates"]/div/article/div[3]/div[2]/a
        Thread.sleep(3000);
        SC.screen("SelecrRoomPageTest Screenshot");
        JS.clickElementByJS(bookroom,driver);
        Thread.sleep(3000);

    }
}
