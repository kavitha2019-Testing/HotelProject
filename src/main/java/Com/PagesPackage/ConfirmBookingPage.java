package Com.PagesPackage;

import Com.BasePackage.OpenBrowser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ConfirmBookingPage  extends OpenBrowser {

@FindBy(xpath = "//*[@id='quick-checkout']/div/div[2]/a")
    WebElement  sel_confirmbooking ;
@FindBy(xpath = "//*[@id='basket-panel']/div/header/div[1]/h1")
WebElement sel_baskettext;


    public ConfirmBookingPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
    public String  baskettextsel(){
        return  sel_baskettext.getText();
    }

    public  PaymentPage  confirmbookingsel() throws IOException {
        sel_confirmbooking.click();
        return new  PaymentPage();
    }
}
