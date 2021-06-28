package FR.Excel;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

import java.util.Date;

public class InvoiceExcel {

    @ExcelRow
    private int rowIndex;

    @ExcelCellName("Azienda")
    private String Azienda;

    @ExcelCellName("Data")
    private Date Data;

    @ExcelCellName("Numero")
    private int Numero;

    @ExcelCellName("IMPORTO")
    private int Importo;

    @ExcelCellName("Fattura Elettronica")
    private int fattElettronica;

    @ExcelCellName("Bollo")
    private int bollo;

    @ExcelCellName("Scadenza")
    private Date scadenza;

    @ExcelCellName("Incasso")
    private int incasso;

    @ExcelCellName("Pagato")
    private String pagato;

    @ExcelCellName("Banca")
    private String banca;

    @ExcelCellName("Totale")
    private int totale;

    @ExcelCellName("Data pagamento")
    private Date dPagamento;

    @ExcelCellName("Note")
    private String note;

    @ExcelCellName("Controllo")
    private String controllo;

    @Override
    public String toString() {
        return "InvoiceExcel [rowIndex=" + rowIndex + ", Azienda=" + Azienda + ", Data=" + Data + ", Numero=" + Numero
                + ", Importo=" + Importo + ", Fattura Elettronica=" + fattElettronica + ", Bollo=" + bollo + ", Scadenza=" + scadenza + ", Incasso=" + incasso +
                ", Pagato=" + pagato + ", Banca=" + banca + ", Totale=" + totale + ", Data Pagamento=" + dPagamento + ", Note=" + note + ", Controllo=" + controllo + "]";
    }

}