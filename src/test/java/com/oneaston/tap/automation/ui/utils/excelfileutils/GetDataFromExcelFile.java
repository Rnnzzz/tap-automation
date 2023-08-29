package com.oneaston.tap.automation.ui.utils.excelfileutils;

import java.util.Map;

public class GetDataFromExcelFile {

    public static Map<String, String> getData(String sheetName, String uniqueValue, String testDataDirectory) throws NullPointerException {
        ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir") + testDataDirectory);
        Map<String, String> data = excelReader.getScenarioData(sheetName, uniqueValue);
        excelReader.closeWorkbook();
        return data;
    }

}
