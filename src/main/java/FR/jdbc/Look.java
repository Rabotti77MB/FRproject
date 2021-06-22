package FR.jdbc;


import FR.utils.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Look extends JFrame implements ActionListener{
   //private static final long serialVersionUID = 1L;
    private final JButton Select;
    private final JButton Insert;
    private final JTextField fornitore;
    private final JTextField prezzo;
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == Select) {
            String I_fornitore = fornitore.getText();
            double I_prezzo = Double.parseDouble(prezzo.getText());
            int r= I_fornitore.compareTo("");
            if(r!=0 && I_prezzo!=0) {
                /*codice del db per la select (vedi funzione già creata da davide) */
                /*JOptionPane.showMessageDialog(this, "devo selezionare", "OPERAZIONE",
                        JOptionPane.WARNING_MESSAGE);*/
                try {
                    DBManager.setConnection(Utils.JDBC_Driver_MySQL, Utils.JDBC_URL_MySQL);
                    Statement statement = DBManager.getConnection().createStatement();
                    setContentPane(new JScrollPane(getTableSelect("SELECT * FROM persona  WHERE nome=\""+I_fornitore+"\"")));
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(this, "Database Error!");
                }

            }

        }
        if (e.getSource() == Insert) {
            String I_fornitore = fornitore.getText();
            double I_prezzo = Double.parseDouble(prezzo.getText());
            int r= I_fornitore.compareTo("");
            if (I_prezzo > 0 && r!=0) {
                /* codice del db per la insert (vedi funzione già creata da davide)
                JOptionPane.showMessageDialog(this, "DEVO INSERIRE!", "INSERT",
                        JOptionPane.WARNING_MESSAGE);*/


            }
        }
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
        t.setGridColor(Color.black);

        return t;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Look::new);
    }

    public Look() {
        Select = new JButton("Seleziona");
        Select.addActionListener(this);
        Insert = new JButton("Inserisci");
        Insert.addActionListener(this);
        fornitore= new JTextField(" inserisci fornitore");
        prezzo= new JTextField(" inserisci prezzo");


        JPanel p2 = new JPanel();
        p2.add(Select,BorderLayout.SOUTH);
        p2.add(Insert);
        p2.add(fornitore,BorderLayout.WEST);
        p2.add(prezzo,BorderLayout.EAST);



        setContentPane(p2);
        pack();
        setSize(400,200);
        setVisible(true);
    }
}
