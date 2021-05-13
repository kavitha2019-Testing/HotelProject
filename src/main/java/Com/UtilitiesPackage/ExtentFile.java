package Com.UtilitiesPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

    public class ExtentFile extends TestListenerAdapter {

        //Listener class used to generate Extent reports
        public ExtentHtmlReporter htmlReporter;
        public ExtentReports extent;
        public ExtentTest test;


        public void onStart(ITestContext testContext)
        {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
            String repName="Test-Report-"+timeStamp+".html";

            //  htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");//specify location of the report
            htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReports/ExtentReport1.html");
            extent=new ExtentReports();

            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Project name","RestAssuredSDETProject");
            extent.setSystemInfo("Host name","localhost");
            extent.setSystemInfo("Environemnt","QA");
            extent.setSystemInfo("user","kavitha");

            htmlReporter.config().setDocumentTitle("RestAssured Test Project"); // Title of report
            htmlReporter.config().setReportName("RestAssured RestAPI Test Automation Report"); // name of the report
            // htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
            htmlReporter.config().setTheme(Theme.DARK);
        }
        public void onTestSuccess(ITestResult tr)
        {
            test=extent.createTest(tr.getName()); // create new entry in th report
            test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
        }

        public void onTestFailure(ITestResult tr)
        {
            test=extent.createTest(tr.getName()); // create new entry in th report
            test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted

            String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";

            File f = new File(screenshotPath);

            if(f.exists())
            {
                try {
                    test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

        }
        public void onTestSkipped(ITestResult tr)
        {
            test=extent.createTest(tr.getName()); // create new entry in th report
            test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
        }
        public void onFinish(ITestContext testContext)
        {
            extent.flush();
        }
    }




