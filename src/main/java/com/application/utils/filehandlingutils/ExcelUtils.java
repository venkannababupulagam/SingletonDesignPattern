package com.application.utils.filehandlingutils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    FileInputStream file;
    XSSFWorkbook workbook;
    XSSFSheet sheet;


    public ExcelUtils(String filePath, String sheetName) {
        try {
            file = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String getCellValue(int row, int column) {
        return sheet.getRow(row).getCell(column).getStringCellValue();
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColumnCount(int row) {
        return sheet.getRow(row).getPhysicalNumberOfCells();
    }

    public Object[][] getExcelData() {
        int rowCount = getRowCount();
        int columnCount = getColumnCount(1);
        Object[][] data = new Object[rowCount - 1][columnCount];
        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                data[i - 1][j] = getCellValue(i, j);
            }
        }
        return data;
    }
}