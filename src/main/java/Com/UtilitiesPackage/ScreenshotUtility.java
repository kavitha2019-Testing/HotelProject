package Com.UtilitiesPackage;

import Com.BasePackage.OpenBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtility  extends OpenBrowser {

    public ScreenshotUtility() throws IOException {
    }
    public void screen(String filename) throws IOException {
        TakesScreenshot sshot =  ((TakesScreenshot)driver) ;
        File srcfile = sshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcfile,new File("./Screenshots/" + filename +".png"));
    }
    }

