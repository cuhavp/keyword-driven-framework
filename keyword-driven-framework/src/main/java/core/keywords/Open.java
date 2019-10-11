package core.keywords;

import core.Keywords;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class Open implements Action {
    @Override
    public boolean apply(XSSFRow rowData) {
        return Keywords.open(rowData.getCell(3).getStringCellValue());
    }
}
