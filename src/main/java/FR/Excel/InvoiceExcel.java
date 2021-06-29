package FR.Excel;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;
import com.poiji.annotation.ExcelSheet;
import com.poiji.option.PoijiOptions;

import java.util.Date;

@ExcelSheet("Attivo")
public class InvoiceExcel {

    @ExcelRow
    private int rowIndex;

    @ExcelCell(0)
    private String Azienda;

    @ExcelCell(1)
    private Date Data;

    @ExcelCell(2)
    private Integer Numero;

    @ExcelCell(3)
    private Double Importo;

    @ExcelCell(4)
    private String fattElettronica;

    @ExcelCell(5)
    private String bollo;

    @ExcelCell(6)
    private Date scadenza;

    @ExcelCell(7)
    private String incasso;

    @ExcelCell(8)
    private String pagato;

    @ExcelCell(9)
    private String banca;

    @ExcelCell(10)
    private Double totale;

    @ExcelCell(11)
    private Date dPagamento;

    @ExcelCell(12)
    private Double controllo;

    @ExcelCell(13)
    private String note;

    @Override
    public String toString() {
        return "InvoiceExcel [rowIndex=" + rowIndex + ", Azienda=" + Azienda + ", Data=" + Data + ", Numero=" + Numero
                + ", Importo=" + Importo + ", Fattura Elettronica=" + fattElettronica + ", Bollo=" + bollo + ", Scadenza=" + scadenza + ", Incasso=" + incasso +
                ", Pagato=" + pagato + ", Banca=" + banca + ", Totale=" + totale + ", Data Pagamento=" + dPagamento + ", Note=" + note + ", Controllo=" + controllo + "]\n";
    }

}