package FR.Excel;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

import java.util.Date;

public class InvoiceExcel {

    @ExcelRow
    private int rowIndex;

    @ExcelCellName("AZIENDA")
    private String Azienda;

    @ExcelCellName("DATA")
    private Date Data;

    @ExcelCellName("FATT.NUMERO")
    private Integer Numero;

    @ExcelCellName("IMPORTO")
    private Double Importo;

    @ExcelCellName("FT.ELETT CARICATA")
    private String fattElettronica;

    @ExcelCellName("BOLLO")
    private String bollo;

    @ExcelCellName("SCADENZA")
    private Date scadenza;

    @ExcelCellName("INCASSO")
    private Integer incasso;

    @ExcelCellName("PAGATO")
    private String pagato;

    @ExcelCellName("BANCA")
    private String banca;

    @ExcelCellName("TOTALE")
    private Integer totale;

    @ExcelCellName("DATA DI PAGAMENTO")
    private Date dPagamento;

    @ExcelCellName("CONTROLLO")
    private String controllo;

    @ExcelCellName("NOTE")
    private String note;

    @Override
    public String toString() {
        return "InvoiceExcel [rowIndex=" + rowIndex + ", Azienda=" + Azienda + ", Data=" + Data + ", Numero=" + Numero
                + ", Importo=" + Importo + ", Fattura Elettronica=" + fattElettronica + ", Bollo=" + bollo + ", Scadenza=" + scadenza + ", Incasso=" + incasso +
                ", Pagato=" + pagato + ", Banca=" + banca + ", Totale=" + totale + ", Data Pagamento=" + dPagamento + ", Note=" + note + ", Controllo=" + controllo + "]\n";
    }

}