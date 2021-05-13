package Com.TestPackage;

import Com.BasePackage.OpenBrowser;
import Com.PagesPackage.HomePage;
import Com.PagesPackage.SearchHotels;
import Com.UtilitiesPackage.JavaScriptconcepts;
import Com.UtilitiesPackage.ScreenshotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SearchHotelsTest  extends OpenBrowser {
    JavaScriptconcepts JS= new JavaScriptconcepts();

    static  HomePage HP;
    static SearchHotels SH;
    static ScreenshotUtility SC;
    public SearchHotelsTest() throws IOException {
    }

    @BeforeMethod
    public static void Sbrowser() throws InterruptedException,IOException{
        HP = new HomePage();
        SH = new SearchHotels();
        SC = new ScreenshotUtility();

    }
    @Test
    public void Italytitle() throws InterruptedException, IOException {
        Thread.sleep(5000);
        System.out.println("***************** SearchHotels Page ************");
        String tit = SH.Searchdestinationtext();
        Thread.sleep(5000);
        System.out.println("Search destination  text is :" +  tit);
       // System.out.println("get new title is:" + driver.getTitle());
       // System.out.println("get current url :" + driver.getCurrentUrl());
        WebElement sort = SH.selsortandview();
        sort.click();
        WebElement search = SH.selprice();
        JS.scrollIntoView(search, driver);
        search.click();
        Thread.sleep(5000);
        System.out.println("search button clicked");
        Select s = new Select(SH.selprice());
        s.selectByVisibleText("Price Low to High");
        System.out.println("price selection select");
        Select s1 = new Select(SH.selshowrank());
        //s1.isMultiple();
        Thread.sleep(5000);
        s1.selectByValue("25");
        System.out.println("show select");
        Thread.sleep(5000);
        sort.click();
        Thread.sleep(5000);
       // s1.deselectByValue("25"); //java.lang.UnsupportedOperationException: You may only deselect options of a multi-select

        //System.out.println("deselect show select");
       WebElement E2= SH.selcurrency();
        JS.clickElementByJS(E2,driver);
        Thread.sleep(7000);
        System.out.println("currency clicked");
        Select s2 = new Select(SH.selcurrency());
        Thread.sleep(5000);
        s2.selectByVisibleText(prop.getProperty("currency"));
        System.out.println("currency country selected");
       Thread.sleep(5000);
        sort.click();
        Thread.sleep(7000);
        Select s3 = new Select(SH.seltax());
        Thread.sleep(7000);
        s3.selectByValue(prop.getProperty("tax"));
        System.out.println("Exclusive tax selected");
        Thread.sleep(5000);
        SC.screen("SearchHotelsPageScreenshot");
        SH.selRoom();
        Thread.sleep(3000);
    }
    }

