package core.keywords;

import org.apache.poi.xssf.usermodel.XSSFRow;

public interface Action {
    boolean apply(XSSFRow rowData);
}
