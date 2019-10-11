package core.excel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteExcelFile {
    String reportPath = "./target/excel/Result-%s-%d.xlsx";
    XSSFWorkbook reportWorkbook;
    String testResultsPath;
    XSSFSheet sheet;

    public WriteExcelFile(String excelFile) {
        try {
            FileInputStream runFile = new FileInputStream(new File(getClass().getClassLoader().getResource(excelFile + ".xlsx").getFile()));
            this.reportWorkbook = new XSSFWorkbook(runFile);
            if (Files.notExists(Paths.get("./target/excel/"))){
                Files.createDirectory(Paths.get("./target/excel/"));
            }
            this.testResultsPath = String.format(reportPath, excelFile, System.currentTimeMillis());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    public WriteExcelFile setSheetName(String sheetName){
        this.sheet = this.reportWorkbook.getSheet(sheetName);
        return this;
    }

    public void setStepResult(int row,String result) {
       sheet.getRow(row).createCell(4).setCellValue(result);

    }
    public void exportResults()  {
        try {
            FileOutputStream outputStream = new FileOutputStream(this.testResultsPath);
            this.reportWorkbook.write(outputStream);
            this.reportWorkbook.close();
        }catch (Exception e){
            System.out.println(e);
        }

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
