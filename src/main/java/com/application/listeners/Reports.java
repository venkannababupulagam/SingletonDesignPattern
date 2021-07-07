package com.application.listeners;

import com.application.base.BrowserSetup;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reports extends BrowserSetup implements ITestListener {


    Logger logger = LogManager.getLogger(getClass().getName());
    ExtentHtmlReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public Reports() {

    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("*******************Test " + result.getName() + " is started*******************");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        String testName = iTestResult.getMethod().getMethodName();
        logger.info("*******************Test: " + testName + " Passed.*******************");
        test.pass(testName + " Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String testName = iTestResult.getMethod().getMethodName();
        getScreenshot(testName);
        logger.error("*******************Test: " + testName + " Failed.*******************");
        test.fail(testName + " Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        String testName = iTestResult.getMethod().getMethodName();
        logger.warn("*******************Test: " + testName + " Skipped.*******************");
        test.skip(testName + " Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        htmlReporter = new ExtentHtmlReporter("Reports-" + getCurrentDate() + ".html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        String className = this.getClass().getSimpleName();
        test = reports.createTest(className, "Automation Test Report " + getCurrentDate());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        reports.flush();
    }

    public String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
        return sdf.format(new Date());
    }

    public void getScreenshot(String testName) {
        try {
            File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./Screenshots/" + getCurrentDate() + "/" + testName + ".png"));
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}