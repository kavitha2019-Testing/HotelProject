package Com.PagesPackage;

import Com.BasePackage.OpenBrowser;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PaymentPage  extends OpenBrowser {
@FindBy(xpath = "//*[@id='summary-box']/div[1]/h2")
    WebElement sel_booksummary;

    public PaymentPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }
    public String booksummarySel(){
        return sel_booksummary.getText();
    }
}
