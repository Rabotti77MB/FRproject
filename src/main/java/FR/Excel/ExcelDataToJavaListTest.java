package FR.Excel;

import java.io.File;
import java.util.List;
import com.poiji.bind.Poiji;

public class ExcelDataToJavaListTest {

    public ExcelDataToJavaListTest(){
        // it should take the selected xlsx file and convert to list then add this list to a new db
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Giovanni\\Desktop\\ProgettoFR\\PROVAPRO.xlsx");
        List<InvoiceExcel> invoices = Poiji.fromExcel(file, InvoiceExcel.class);
        System.out.println("Printing List Data: " +invoices);
    }
}
