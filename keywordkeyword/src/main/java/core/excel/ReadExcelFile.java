package core;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelFile {
    XSSFWorkbook wb;
    XSSFSheet sheet;
    String sheetName;

    public ReadExcelFile(String excelPath) {
        try {
            File src = new File(getClass().getClassLoader().getResource(excelPath).getFile());
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public ReadExcelFile setSheetName(String sheetName) {
        this.sheetName = sheetName;
        this.sheet = wb.getSheet(sheetName);
        return this;
    }

    public XSSFRow getRowData(int row) {
        return this.sheet.getRow(row);
    }

    public int getRowCount() {
        int row = this.sheet.getLastRowNum();
        row = row + 1;
        return row;
    }
}
