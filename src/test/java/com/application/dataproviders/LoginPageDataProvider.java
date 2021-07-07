package com.application.dataproviders;

import com.application.utils.filehandlingutils.ExcelUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;

import static com.application.utils.commons.CommonVariables.LOGIN_DATA;
import static com.application.utils.commons.CommonVariables.SHEET_NAME;

public class LoginPageDataProvider {


    ExcelUtils utils;

    @DataProvider
    public Object[][] loginData() {
        utils = new ExcelUtils(LOGIN_DATA, SHEET_NAME);
        Object[][] data = utils.getExcelData();
        return data;
    }
}
