package FR.Excel;

import java.io.File;
import java.util.List;
import com.poiji.bind.Poiji;

public class ExcelDataToJavaListTest {

    public ExcelDataToJavaListTest(File file){
        // it should take the selected xlsx file and convert to list then add this list to a new db
        System.out.printf("File %s",file);
        List<InvoiceExcel> invoices = Poiji.fromExcel(file, InvoiceExcel.class);
        System.out.println("Printing List Data: " +invoices);
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Giovanni\\Desktop\\PROVAVEROEX.xlsx");
        System.out.printf("File %s\n",file);
        List<InvoiceExcel> invoices = Poiji.fromExcel(file, InvoiceExcel.class);
        System.out.println("Printing List Data: " +invoices);
    }
}
