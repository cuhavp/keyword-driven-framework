package core.keywords;

import core.Keywords;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class Fill implements Action {
    @Override
    public boolean apply(XSSFRow rowData) {
        return Keywords.fill(rowData.getCell(2).getStringCellValue(), rowData.getCell(3).getStringCellValue());
    }
}
