package FR.jdbc;

import FR.utils.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetToJTable extends JFrame {

    public ResultSetToJTable() {
        super("RABOTTI&FOLLONI");

        try {
            DBManager.setConnection(Utils.JDBC_Driver_MySQL, Utils.JDBC_URL_MySQL);
            Statement statement = DBManager.getConnection().createStatement();
            setContentPane(new JScrollPane(getTableSelect("SELECT * FROM giocatori")));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database Error!");
        }

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void testConnection() throws SQLException {
        DBManager.setConnection(Utils.JDBC_Driver_MySQL, Utils.JDBC_URL_MySQL);
        Statement statement = DBManager.getConnection().createStatement();
        /*
        try {
            statement.executeQuery("SELECT * FROM persona ");
        } catch (SQLException e) {
            System.out.print("errore");
            /*
            statement.executeUpdate("CREATE TABLE sausage (" + "id VARCHAR(50) PRIMARY KEY, " + "length REAL, diameter REAL, " + "weight REAL, " + "quality VARCHAR(50))");
            statement.executeUpdate("INSERT INTO sausage (id, length, diameter, weight, quality) VALUES ('214bb0db-aa52-48be-b052-cd30f730ae79', 30.2, 30.0, 2.6, 'High')");
            statement.executeUpdate("INSERT INTO sausage (id, length, diameter, weight, quality) VALUES ('03e9e721-f241-4539-9cc7-baecd8b3a931', 40.3, 35.5, 2.2, 'Low')");
            statement.executeUpdate("INSERT INTO sausage (id, length, diameter, weight, quality) VALUES ('e1f0dcb0-181b-4463-97d7-edcfed736ae1', 35.1, 28.2, 4.3, 'High')");

        }
        */
    }

    public JTable getTableSelect(String query) throws SQLException {
        JTable t = new JTable();
        DefaultTableModel dm = new DefaultTableModel();

        ResultSet rs = DBManager.getConnection().createStatement().executeQuery(query);
        ResultSetMetaData rsMetaData = rs.getMetaData();

        // get columns metadata
        int cols = rsMetaData.getColumnCount();
        String[] c = new String[cols];
        for (int i = 0; i < cols; i++) {
            c[i] = rsMetaData.getColumnName(i + 1);
            dm.addColumn(c[i]);
        }

        // Get rows
        Object[] row = new Object[cols];
        while (rs.next()) {
            for (int i = 0; i < cols; i++) {
                row[i] = rs.getString(i + 1);
            }
            dm.addRow(row);
        }

        t.setModel(dm);
        t.setGridColor(Color.magenta);

        return t;
    }

    public static void main(String[] args) {
       try {

            BasicOperations op = new BasicOperations();
            //op.testDelete("cognome","tomori");
       } catch (SQLException e) {
           e.printStackTrace();
       }
       new ResultSetToJTable();

    }
}