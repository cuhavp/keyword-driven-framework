package core.keywords;

import org.apache.poi.xssf.usermodel.XSSFRow;

public interface Keyword {
    void apply(XSSFRow rowData);
}
