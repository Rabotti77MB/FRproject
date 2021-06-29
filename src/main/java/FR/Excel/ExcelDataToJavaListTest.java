package FR.Excel;

import java.io.File;
import java.util.List;

import com.poiji.bind.Poiji;
import com.poiji.bind.mapping.PoijiNumberFormat;
import com.poiji.option.PoijiOptions;

public class ExcelDataToJavaListTest {

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
    }

    public static void main(String[] args) {
        /* File file = new File("C:\\Users\\Giovanni\\Desktop\\PROVAVEROEX.xlsx");
        System.out.printf("File %s\n",file);
        List<InvoiceExcel> invoices = Poiji.fromExcel(file, InvoiceExcel.class);
        System.out.println("Printing List Data: " +invoices);
         */
    }
}
