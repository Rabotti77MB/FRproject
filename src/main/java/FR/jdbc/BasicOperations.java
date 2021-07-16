package FR.jdbc;

import FR.utils.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A class for testing basic operations with JDBC It supports both MySQL and
 * SQLite
 *
 * @author Nicola Bicocchi
 */
public class BasicOperations {
    Statement statement;

    public BasicOperations() throws SQLException {

        /*DBManager.setConnection(
                Utils.JDBC_Driver_SQLite,
                Utils.JDBC_URL_SQLite);
        statement = DBManager.getConnection().createStatement();
*/

        DBManager.setConnection(
                Utils.JDBC_Driver_MySQL,
                Utils.JDBC_URL_MySQL);
        statement = DBManager.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);


        try {
            /*
             * Simple query for testing that everything is OK. If an exception raised, the
             * db is deleted and created from scratch.
             */
            statement.executeQuery("SELECT * FROM persona ");
        } catch (SQLException e) {
           /* statement.executeUpdate("DROP TABLE IF EXISTS book");
            statement.executeUpdate("CREATE TABLE book (" + "id INTEGER PRIMARY KEY, " + "title VARCHAR(30), "
                    + "author VARCHAR(30), " + "pages INTEGER)");

            statement.executeUpdate(
                    "INSERT INTO book (id, title, author, pages) VALUES(1, 'The Lord of the Rings', 'Tolkien', 241)");
            statement.executeUpdate("INSERT INTO book (id, title, author, pages) VALUES(2, 'Fight Club', 'Palahniuk', 212)");
            statement.executeUpdate(
                    "INSERT INTO book (id, title, author, pages) VALUES(3, 'Computer Networks', 'Tanenbaum', 313)");
            statement.executeUpdate(
                    "INSERT INTO book (id, title, author, pages) VALUES(4, 'Affective Computing', 'Picard', 127)");*/
            System.out.println("errore");
        }
    }

    public static void main(String[] args) {
        try {
            new BasicOperations().run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        /*try {
            System.out.println("\n- scrollable...");
            testInsertPassivo("RAbboINsert","2021-08-01",10,"si",123456,"$",200,"assegno","Monte Unicredit",2525,"nota","contr","anomal");
        } catch (SQLException a) {
            System.out.println("Something went wrong... " + a.getMessage());
        }*/

        try {
            System.out.println("\n- scrollable...");
            testDeletePacco("a",1.0,1.0,1.0,95.0,"A1",2,"si");
        } catch (SQLException a) {
            System.out.println("Something went wrong... " + a.getMessage());
        }

        /*
        try {
            System.out.println("\n- updating database...");
            testUpdate();
        } catch (SQLException e) {
            System.out.println("Something went wrong... " + e.getMessage());
        }

        try {
            System.out.println("\n- reading database...");
            testSelect();
        } catch (SQLException e) {
            System.out.println("Something went wrong... " + e.getMessage());
        }

        try {
            System.out.println("\n- test scrollable...");
            testScrollable();
        } catch (SQLException e) {
            System.out.println("Something went wrong... " + e.getMessage());
        }

        try {
            System.out.println("\n- test updateable...");
            testUpdateable();
        } catch (SQLException e) {
            System.out.println("Something went wrong... " + e.getMessage());
        }

        try {
            System.out.println("\n- reading database...");
            testSelect();
        } catch (SQLException e) {
            System.out.println("Something went wrong... " + e.getMessage());
        }

        try {
            System.out.println("\n- test sensitive...");
            testSensitive();
        } catch (SQLException e) {
            System.out.println("Something went wrong... " + e.getMessage());
        }
        */
        try {
            System.out.println("\n- closing database...");
            DBManager.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong... " + e.getMessage());
        }
    }

    /**
     * Reads the content of the person table Results are limited using "LIMIT
     * 100" This is useful for very large tables
     */
    public void testSelectAll(String s) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM " + s + ";  ");
        while (rs.next()) {
            printRow(rs);
        }
    }

    public void SvuotAttivo() throws SQLException{
        statement.executeUpdate("delete from attivo");
    }
    public void SvuotaPassivo()throws SQLException{
        statement.executeUpdate("delete from passivo");
    }

    public void testInsertPassivo(String Azienda, String DATE, String Num, String Fattura_El, double importo, String Valuta,String Incasso,String Pagato,String Banca,double Totale,String Note, double Controllo, String Anomalie) throws SQLException {
        System.out.print("sto eseguendo: insert into passivo  values (\""+Azienda+"\",\""+DATE+"\",\""+Num+"\",\""+Fattura_El+"\","+importo+",\""+Valuta+"\",\""+Incasso+"\",\""+Pagato+"\",\""+Banca+"\","+Totale+",\""+Note+"\","+Controllo+",\""+Anomalie+"\"); ");
        statement.executeUpdate("insert into passivo  values (\""+Azienda+"\",\""+DATE+"\",\""+Num+"\",\""+Fattura_El+"\","+importo+",\""+Valuta+"\",\""+Incasso+"\",\""+Pagato+"\",\""+Banca+"\","+Totale+",\""+Note+"\","+Controllo+",\""+Anomalie+"\"); ");

    }
    public void testInsertAttivo(String Azienda, String DATE, int Num, double importo, String Fattura_El,  String Bollo,String Scadenza,String Incasso,String Pagato,String Banca,double Totale, String Data_pagamento, String Note, double Controllo) throws SQLException {
        //System.out.print("sto eseguendo: insert into attivo  values (\""+Azienda+"\",\""+DATE+"\","+Num+","+importo+",\""+Fattura_El+"\",\""+Bollo+"\",\""+Scadenza+"\",\""+Incasso+"\",\""+Pagato+"\",\""+Banca+"\","+Totale+",\""+Data_pagamento+"\","+Controllo+",\" "+Note+"\");");

        statement.executeUpdate(" insert into attivo  values (\""+Azienda+"\",\""+DATE+"\","+Num+","+importo+",\""+Fattura_El+"\",\""+Bollo+"\",\""+Scadenza+"\",\""+Incasso+"\",\""+Pagato+"\",\""+Banca+"\","+Totale+",\""+Data_pagamento+"\","+Controllo+",\""+Note+"\");");
    }
    public void TestInsertPacchi (String Azienda,Double Peso, Double Altezza,Double Larghezza, Double Profondita,String Scomparto,int Ripiano,String Prodotto) throws SQLException {
        statement.executeUpdate("insert into pacchi values (\""+Azienda+"\","+Peso+","+Altezza+","+Larghezza+","+Profondita+",\""+Scomparto+"\","+Ripiano+",\""+Prodotto+"\");");
    }
    public void testDeletePacco(String Azienda,Double Peso, Double Altezza,Double Larghezza, Double Profondita,String Scomparto,int Ripiano,String Prodotto) throws SQLException {
        //System.out.print("sto eseguendo: DELETE FROM persona WHERE " + nomecol + "='" + val + "'; ");
        statement.executeUpdate(
                "DELETE FROM pacchi WHERE Azienda ='" + Azienda + "' and Peso="+Peso+" and Altezza="+Altezza+" and Larghezza="+Larghezza+ " and Profondita = "+Profondita+" and Scomparto = '"+Scomparto+"' and Ripiano = "+Ripiano+" and Prodotto = '"+Prodotto+"';");

    }

    /**
     * Update the content of the book table
     */
    public void testUpdate() throws SQLException {
        statement.executeUpdate(
                "UPDATE book SET title='Il Principe', " + "author='Macchiavelli', " + "pages=176 " + "WHERE id=1");
    }

    /**
     * Test Scrollable ResultSet
     */
    public void testScrollable() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM persona ");
        // Third record
        rs.absolute(3);
        printRow(rs);

        // Previous record
        rs.previous();
        printRow(rs);

        // +2 records from current position
        rs.relative(2);
        printRow(rs);
    }

    /**
     * Test Updateable ResultSet Increment pages of one element
     */
    public void testUpdateable() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM book LIMIT 100 OFFSET 0");
        while (rs.next()) {
            int pages = rs.getInt("pages");
            rs.updateInt("pages", pages + 1);
            rs.updateRow();
        }
    }

    /**
     * Test Sensitive ResultSet
     */
    public void testSensitive() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM book LIMIT 100 OFFSET 0");
        for (int retry = 0; retry < 10; retry++) {
            while (rs.next()) {
                rs.refreshRow();
                printRow(rs);
            }
            System.out.printf("\n[%d] awaiting for external changes 6s...", retry);
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                // do nothing
            }
            rs.beforeFirst();
        }
    }

    /**
     * Prints the current ResultSet row
     */
    public void printRow(ResultSet rs) throws SQLException {
        System.out.println( rs.getString("Azienda") + rs.getString("Data") +
                rs.getString("Numero")+     rs.getString("Fattura_Elettronica")+ rs.getString("Importo")+
                rs.getString("Valuta")+ rs.getString("Incasso")+
                rs.getString("Pagato")+ rs.getString("Banca")+
                rs.getString("Totale")+ rs.getString("Note")+
                rs.getString("Controllo")+ rs.getString("Anomalie_note") );

    }

    public void printRowNome(ResultSet rs) throws SQLException {
        System.out.println("nome=" + rs.getString("nome"));

    }
}
