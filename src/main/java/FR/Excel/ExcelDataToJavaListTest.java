package FR.Excel;

import FR.jdbc.BasicOperations;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;

import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.List;

public class ExcelDataToJavaListTest  {
BasicOperations Aiuto;
    {
        try {
            Aiuto = new BasicOperations();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ExcelDataToJavaListTest(File file) {
        // it should take the selected xlsx file and convert to list then add this list to a new db
        System.out.printf("File %s\n", file);
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings(2).build();

        List<InvoiceExcelAttivo> invoicesA = Poiji.fromExcel(file, InvoiceExcelAttivo.class, options);
        // just DEBUG!

        System.out.println("Printing List Data: \n" + invoicesA);
        try {
            Aiuto.SvuotAttivo();
            Aiuto.SvuotaPassivo();
        } catch (SQLException throwables) {
            System.out.println("errore nello svuotare");
            throwables.printStackTrace();
        }

       for(InvoiceExcelAttivo p : invoicesA){
            //System.out.println(p);
            try {
                Aiuto.testInsertAttivo(p.Azienda,p.Data,p.Numero,p.Importo,p.fattElettronica,p.bollo,p.scadenza,p.incasso,p.pagato,p.banca,p.totale,p.dPagamento,p.note,p.controllo);

            } catch (SQLException throwables) {
                System.out.println("errore");
                throwables.printStackTrace();
            }
        }

        List<InvoiceExcelPassivo> invoicesP = Poiji.fromExcel(file, InvoiceExcelPassivo.class, options);
        System.out.println("Printing List Data: \n" + invoicesP);
        for(InvoiceExcelPassivo p : invoicesP){
            //System.out.println(p);
            try {

                Aiuto.testInsertPassivo(p.Azienda,p.Data,p.Numero,p.fattElettronica,p.Importo,p.valuta,p.incasso,p.pagato,p.banca,p.totale,p.note,p.controllo,p.anomalie);
            } catch (SQLException throwables) {
                System.out.println("errore");
                throwables.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        /* File file = new File("C:\\Users\\Giovanni\\Desktop\\PROVAVEROEX.xlsx");
        System.out.printf("File %s\n",file);
        List<InvoiceExcel> invoices = Poiji.fromExcel(file, InvoiceExcel.class);
        System.out.println("Printing List Data: " +invoices);
         */
    }
}
