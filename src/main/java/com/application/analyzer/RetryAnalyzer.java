package com.application.analyzer;

import com.application.utils.filehandlingutils.ReadProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static com.application.utils.commons.CommonVariables.configfilePath;

public class RetryAnalyzer implements IRetryAnalyzer {

    int count = 0;
    ReadProperties properties = new ReadProperties(configfilePath);
    int retryLimit = Integer.parseInt(properties.getProperty("retryCount"));

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<retryLimit){
            count++;
            return true;
        }
        return false;
    }
}
