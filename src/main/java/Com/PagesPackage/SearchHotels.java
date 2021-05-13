package Com.PagesPackage;

import Com.BasePackage.OpenBrowser;
import Com.UtilitiesPackage.JavaScriptconcepts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class SearchHotels  extends OpenBrowser {
    static JavaScriptconcepts JS;

    static {
        try {
            JS = new   JavaScriptconcepts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FindBy(xpath="//*[@id='search-currenttags']/div/span")
    WebElement Stext;
    @FindBy(xpath = "//*[@id='hotel-results-controls-mobile']")
    WebElement sel_sortandview;
    @FindBy(xpath = "//*[@id='s_sort_type']")
    WebElement sel_price;
    @FindBy(xpath = "//*[@id='s_limit']")
    WebElement sel_showrank;
    @FindBy(xpath="//*[@id='global_settings_currency']")
    WebElement sel_currency;
    @FindBy(xpath="//*[@id='global_settings_tax']")
    WebElement sel_tax;
    @FindBy(xpath = "//*[@id='search-list']/li[2]/article/div/div/a")
    WebElement sel_room;


    public SearchHotels() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public String Searchdestinationtext(){
        return Stext.getText();
    }
    public WebElement selsortandview(){
        return sel_sortandview;
    }
    public WebElement selprice(){
        return sel_price;
    }
    public WebElement selshowrank(){
        return sel_showrank;
    }
    public WebElement selcurrency(){
        return sel_currency;
    }
    public WebElement seltax(){
        return sel_tax;
    }
    public SelectRoomPage selRoom() throws IOException {
        JS.clickElementByJS(sel_room,driver);
        return new SelectRoomPage();
    }
}


