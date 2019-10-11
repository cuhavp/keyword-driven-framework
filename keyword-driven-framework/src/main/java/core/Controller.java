package core;

import core.excel.WriteExcelFile;
import core.keywords.Action;
import core.keywords.KeywordFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class Controller {
    private static boolean performTestStep(String actionName, XSSFRow rowData) {
        Action keyword = KeywordFactory.getAction(actionName)
                .orElseThrow(() -> new IllegalArgumentException("Invalid keyword"));
       return keyword.apply(rowData);
    }

    /**
     * Each test case will be store each sheet
     *
     * @param sheetName
     */
    public static void runTestCase(String excelFileName, String sheetName) {
        WriteExcelFile writer = new WriteExcelFile(excelFileName);
        int rows = writer.setSheetName(sheetName).getRowCount();
        for (int i = 1; i < rows; i++) {
            XSSFRow rowData = writer.setSheetName(sheetName).getRowData(i);
           boolean isSuccess =  performTestStep(rowData.getCell(1).getStringCellValue(), rowData);
           if(isSuccess){
               writer.setStepResult(i,"PASSED");
           }else {
               writer.setStepResult(i,"FAILED");
           }
        }
        writer.exportResults();

    }
}
