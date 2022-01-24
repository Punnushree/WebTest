package ExtentReporting;

import Base.Baseclass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends Baseclass implements ITestListener {

    //Globalise variable for class
    ExtentTest test;
    ExtentReports extent = Report.getReportObject();

    //Picks up name of the Testcase being executed
    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
       // ITestListener.super.onTestStart(result);
        test = extent.createTest(result.getMethod().getMethodName());
    }

    //Reports testresults after every passed testcase
    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        //ITestListener.super.onTestSuccess(result);
        test.log(Status.PASS,"Testcase Passed");

    }

    //Executes after testcase fails and captures screenshot
    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        //ITestListener.super.onTestFailure(result);
        test.fail(result.getThrowable());
        WebDriver driver = null;
        //captures failed testcase name
        String testCaseName = result.getMethod().getMethodName();
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            getScreenshot(testCaseName, driver);
        } catch(Exception e){

            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        ITestListener.super.onStart(context);
    }

    //To stop Extent reporter listening to testcases
    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
       // ITestListener.super.onFinish(context);
        extent.flush();
    }


}
