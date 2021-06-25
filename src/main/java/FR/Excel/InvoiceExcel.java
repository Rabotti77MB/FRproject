package FR.Excel;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

public class InvoiceExcel {

    @ExcelRow
    private int rowIndex;

    @ExcelCellName("row")
    private String row;

    @ExcelCellName("cols")
    private Double cols;

    @ExcelCellName("num")
    private String num;

    @ExcelCellName("boh")
    private String boh;

    @Override
    public String toString() {
        return "InvoiceExcel [rowIndex=" + rowIndex + ", row=" + row + ", cols=" + cols + ", num=" + num
                + ", boh=" + boh + "]";
    }

}