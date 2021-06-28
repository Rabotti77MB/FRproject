package FR.Excel;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

public class InvoiceExcel {

    @ExcelRow
    private int rowIndex;

    @ExcelCellName("AZIENDA")
    private String row;

    @ExcelCellName("DATA")
    private Double cols;

    @ExcelCellName("FATT.NUMERO")
    private String num;

    @ExcelCellName("IMPORTO")
    private String boh;

    @Override
    public String toString() {
        return "InvoiceExcel [rowIndex=" + rowIndex + ", row=" + row + ", cols=" + cols + ", num=" + num
                + ", boh=" + boh + "]";
    }

}