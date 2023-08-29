package com.oneaston.tap.automation.ui.utils.excelfileutils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    private Workbook workbook;

    public ExcelReader(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getScenarioData(String sheetName, String uniqueValue) throws NullPointerException {
        Map<String, String> scenarioData = new HashMap<>();
        Sheet sheet = workbook.getSheet(sheetName);

        Row headerRow = sheet.getRow(0); // Header Row

        for (int rowIndex = headerRow.getRowNum(); rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row dataRow = sheet.getRow(getDataRow(uniqueValue, sheet)); //Data Row
            scenarioData = getData(headerRow, dataRow);
        }
        return scenarioData;
    }

    private int getDataRow(String uniqueValue, Sheet sheet) throws NullPointerException{
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            if (sheet.getRow(rowIndex).getCell(0).getStringCellValue().equals(uniqueValue)) {
                return rowIndex;
            }
        }
        return 0;
    }

    private Map<String, String> getData(Row headerRow, Row dataRow) {
        Map<String, String> scenarioData = new HashMap<>();

        for (int cellIndex = 0; cellIndex < headerRow.getLastCellNum(); cellIndex++) {
            Cell headerCell = headerRow.getCell(cellIndex);
            Cell dataCell = dataRow.getCell(cellIndex);

            if (headerCell != null && dataCell != null) {
                scenarioData.put(headerCell.getStringCellValue(), dataCell.getStringCellValue());
            }
        }
        return scenarioData;
    }


    private int getScenarioNameIndex(String scenarioName, Sheet sheet) {
        try {
            int scenarioIndex = 0;

            do {
                System.out.println("Checking scenario: " + scenarioName + " row number: " + scenarioIndex);
                if (sheet.getRow(scenarioIndex).getCell(0).getStringCellValue().equals(scenarioName)) {
                    break;
                }
                scenarioIndex++;
            } while (true);
            return scenarioIndex;
        } catch (NullPointerException nullPointerException) {
            Assert.fail("Error in getting data - scenario not found in the provided file");
            return 0;
        }
    }

    public void closeWorkbook() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

