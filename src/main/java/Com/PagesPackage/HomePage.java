package Com.PagesPackage;

import Com.BasePackage.OpenBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HomePage extends OpenBrowser {

    @FindBy(xpath = "//*[@id='logo']/img[1]")
    WebElement logo;
    @FindBy(linkText = "Hotels with swimming pools")
    WebElement collection;
    @FindBy(xpath = "//*[@id='nav-main-honeymoons']")
    WebElement Hmoon;
    @FindBy(xpath = "//*[@id='nav-main-collections']")
    WebElement inspire;
    @FindBy(xpath = "//input[@id='react-s_query']")
    WebElement searchtext;
    @FindBy(xpath = "//div[@class='date-section']")
    WebElement Dsection;
    @FindBy(xpath = "//*[@id='globalSearch']/div[2]/div/div/div[2]/div/div[1]/div[2] /div[2]/div/div[2]/div/div[1]/span")
    WebElement Indate;
    @FindBy(xpath = "//div[@class='next-month']")
    WebElement clickIndate;
    @FindBy(xpath = "//*[@id='globalSearch']/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/table/tbody/tr/td")
    List<WebElement> numbers;
    @FindBy(xpath = "//*[@id='globalSearch']/div[2]/div/div/div[2]/div/div[1] /div[2]/div[2]/div/div[2]/div/div[1]/span")
    WebElement Outdate;
    @FindBy(xpath ="//input[@name='adults']")
    WebElement seladultno;
    @FindBy(xpath ="//button[@name='increment']")
    WebElement adultnoclick;
    @FindBy(xpath = "//input[@name='children']")
    WebElement selchildno;
    @FindBy(xpath = "//*[@id='globalSearch']/div[3]/div[2]/div/div[2]/div/div[2]/div/ul/li/div")
    WebElement childageclick;
    @FindBy(xpath = "//*[@id='globalSearch']/div[3]/div[2]/div/div[2]/div/div[2]/div/ul/li/div/ul/li/label")
    List<WebElement> childagesel;
    @FindBy(xpath = "//button[@id='s_search']")
    WebElement SearchClick;
    public HomePage() throws IOException {
        PageFactory.initElements(driver, this);
    }
    public boolean image() {
        boolean I = logo.isDisplayed();
        return I;
    }
    public void Hcollection() {
        collection.click();
    }

    public void search(String text) {
        searchtext.sendKeys(text);
    }
    public WebElement Indateclick() {
        return Dsection;
    }
    public String Indatesel() {
        return Indate.getText();
    }
    public WebElement clickIndateselect() {
        return clickIndate;
    }
    public List<WebElement> selectIndate(){
        return numbers;
    }
    public String Outdatesel(){
        return Outdate.getText();
    }
    public WebElement adultnosel(){
        return seladultno;
    }
    public WebElement clickadultno(){
       return  adultnoclick;
    }
    public WebElement choldnosel(){
        return selchildno;
    }
    public WebElement clickchildage(){
        return childageclick;
    }
  public List<WebElement> selchildage(){
        return childagesel;
  }
  public SearchHotels clickSearch() throws IOException {
       SearchClick.click();
       return new SearchHotels();
  }
}

