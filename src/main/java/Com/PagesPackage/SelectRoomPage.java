package Com.PagesPackage;

import Com.BasePackage.OpenBrowser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SelectRoomPage  extends OpenBrowser {

// @FindBy(xpath="//*[@id='availability_calendar_11480']/div/div[1]/h3")
    @FindBy(xpath="//*[@id='availability_calendar_6837']/div/div[3]")
     WebElement sel_datestext;

    public  SelectRoomPage() throws IOException {
      super();
      PageFactory.initElements(driver,this);
  }
  public String selectDatestext(){
      return sel_datestext.getText();
  }
}
