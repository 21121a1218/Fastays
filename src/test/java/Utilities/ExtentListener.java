package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Hotel_TestCases.BaseTestCase;

public class ExtentListener implements ITestListener {

    public static ExtentReports extent;
    public static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timestamp + ".html";

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle("Fastays Automation Report");
        spark.config().setReportName("Hotel End To End Execution");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        
        extent.setSystemInfo("Project", "Fastays");
        extent.setSystemInfo("Tester", "Govardhan");
        extent.setSystemInfo("Environment", "UAT");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");
        test.fail(result.getThrowable());

        Object currentClass = result.getInstance();
        BaseTestCase base = (BaseTestCase) currentClass;

        try {
            String screenshotPath = captureScreenshot(base, result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public String captureScreenshot(BaseTestCase base, String testName) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) base.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "/reports/screenshots/" + testName + ".png";
        File destination = new File(path);

        FileUtils.copyFile(source, destination);

        return path;
    }
}
