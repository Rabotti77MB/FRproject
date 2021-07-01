package FR.Excel;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;
import com.poiji.annotation.ExcelSheet;

import java.util.Date;

@ExcelSheet("Passivo")
public class InvoiceExcelPassivo {

    @ExcelRow
    public int rowIndex;

    @ExcelCell(0)
    public String Azienda;

    @ExcelCell(1)
    public String Data;

    @ExcelCell(2)
    public String Numero;

    @ExcelCell(4)
    public Double Importo;

    @ExcelCell(3)
    public String fattElettronica;

    @ExcelCell(5)
    public String valuta;

    @ExcelCell(6)
    public String incasso;

    @ExcelCell(7)
    public String pagato;

    @ExcelCell(8)
    public String banca;

    @ExcelCell(9)
    public Double totale;

    @ExcelCell(11)
    public Double controllo;

    @ExcelCell(10)
    public String note;

    @ExcelCell(12)
    public String anomalie;

    @Override
    public String toString() {
        return "InvoiceExcel [rowIndex=" + rowIndex + ", Azienda=" + Azienda + ", Data=" + Data + ", Numero=" + Numero
                + ", Importo=" + Importo + ", Fattura Elettronica=" + fattElettronica + ", Valuta=" + valuta + ", Incasso=" + incasso +
                ", Pagato=" + pagato + ", Banca=" + banca + ", Totale=" + totale + ", Anomalie=" + anomalie + ", Note=" + note + ", Controllo=" + controllo + "]\n";
    }

}