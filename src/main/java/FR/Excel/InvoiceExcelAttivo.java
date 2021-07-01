package FR.Excel;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;
import com.poiji.annotation.ExcelSheet;

import java.util.Date;

@ExcelSheet("Attivo")
public class InvoiceExcelAttivo {

    @ExcelRow
    public int rowIndex;

    @ExcelCell(0)
    public String Azienda;

    @ExcelCell(1)
    public String Data;

    @ExcelCell(2)
    public Integer Numero;

    @ExcelCell(3)
    public Double Importo;

    @ExcelCell(4)
    public String fattElettronica;

    @ExcelCell(5)
    public String bollo;

    @ExcelCell(6)
    public String scadenza;

    @ExcelCell(7)
    public String incasso;

    @ExcelCell(8)
    public String pagato;

    @ExcelCell(9)
    public String banca;

    @ExcelCell(10)
    public Double totale;

    @ExcelCell(11)
    public String dPagamento;

    @ExcelCell(12)
    public Double controllo;

    @ExcelCell(13)
    public String note;

    @Override
    public String toString() {
        return "InvoiceExcel [rowIndex=" + rowIndex + ", Azienda=" + Azienda + ", Data=" + Data + ", Numero=" + Numero
                + ", Importo=" + Importo + ", Fattura Elettronica=" + fattElettronica + ", Bollo=" + bollo + ", Scadenza=" + scadenza + ", Incasso=" + incasso +
                ", Pagato=" + pagato + ", Banca=" + banca + ", Totale=" + totale + ", Data Pagamento=" + dPagamento + ", Note=" + note + ", Controllo=" + controllo + "]\n";
    }

}