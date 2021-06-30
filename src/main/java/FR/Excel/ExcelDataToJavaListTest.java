package FR.Excel;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import FR.jdbc.BasicOperations;
import com.poiji.bind.Poiji;
import com.poiji.bind.mapping.PoijiNumberFormat;
import com.poiji.option.PoijiOptions;

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
        PoijiOptions.PoijiOptionsBuilder.settings().ignoreWhitespaces(true);
        PoijiOptions.PoijiOptionsBuilder.settings().caseInsensitive(true);

        PoijiNumberFormat numberFormat = new PoijiNumberFormat();
        numberFormat.putNumberFormat((short) 3, "");

        List<InvoiceExcel> invoices = Poiji.fromExcel(file, InvoiceExcel.class, options);
        // just DEBUG!

        System.out.println("Printing List Data: \n" + invoices);
       for(InvoiceExcel p : invoices){
            System.out.println(p);
            try {
                Aiuto.testInsertAttivo(p.Azienda,p.Data,p.Numero,p.Importo,p.fattElettronica,p.bollo,p.scadenza,p.incasso,p.pagato,p.banca,p.totale,p.dPagamento,p.note,p.controllo);
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
