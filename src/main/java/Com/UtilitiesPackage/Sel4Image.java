package Com.UtilitiesPackage;

import Com.BasePackage.OpenBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class Sel4Image  extends OpenBrowser {

    public Sel4Image() throws IOException {
    }
// Image for single webelement
    public static void  Image4(WebElement elem, String  filename) throws IOException {
        File srcfile = elem.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcfile,new File("./target/ScreenshotsFolder/" + filename +".png"));

    }
 // Image for whole screen
    public static void wholeimage(WebDriver driver, String filename1) throws IOException {
        TakesScreenshot sshot =  ((TakesScreenshot)driver) ;
        File srcfile = sshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcfile,new File("./target/ScreenshotsFolder/" + filename1 +".png"));
    }
  // Image for group of elements
    public static  void  Image4web( String  filename) throws IOException, InterruptedException {
        WebElement elem2 = driver.findElement(By.xpath("//*[@id='globalSearch']/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div"));
        Thread.sleep(2000);
        File srcfile = elem2.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcfile,new File("./target/ScreenshotsFolder/" + filename +".png"));

    }
}


