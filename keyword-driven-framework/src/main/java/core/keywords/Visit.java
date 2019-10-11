package core.keywords;

import core.Keywords;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class Visit implements Action {
    @Override
    public boolean apply(XSSFRow rowData) {
        return Keywords.visit(rowData.getCell(3).getStringCellValue());
    }
}
