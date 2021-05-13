package Com.BasePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v87.network.Network;
import org.openqa.selenium.devtools.v87.network.model.Headers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class OpenBrowser {
    public static Properties prop;
    public static WebDriver driver;
    public static final String username = "admin";
    public static final  String password = "admin";

    public OpenBrowser() throws IOException {
        prop = new Properties();
        FileInputStream fp = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
        prop.load(fp);
    }
    public  static void launchbrowser() throws InterruptedException {
        String br = prop.getProperty("browser");
        if (br.equals("chrome")) {
                //System.setProperty("webdriver.chrome.driver","user.dir"+"/HotelProject/Drivers/chromedriver_win32/chromedriver.exe");
               // System.setProperty("webdriver.chrome.driver","C:/Users/kavitha/IdeaProjects/HotelProject/Drivers/chromedriver_win32/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.NONE);
                options.addArguments("enable-automation");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-browser-side-navigation");
                options.addArguments("--disable-gpu");
                //disableimagechrome(options);
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
                driver.manage().deleteAllCookies();
                driver.get(prop.getProperty("url"));
                Thread.sleep(5000);
           /* driver.switchTo().newWindow(WindowType.WINDOW); //open new selenium 4 new feature
            System.out.println("Blank window open");
            Thread.sleep(5000);
            driver.navigate().to("https://www.mrandmrssmith.com/");*/
            }
        }

    }

