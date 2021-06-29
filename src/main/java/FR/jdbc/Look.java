package FR.jdbc;

import FR.utils.Utils;
import org.apache.xmlbeans.impl.store.DomImpl;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;


public class Look extends JFrame implements ActionListener {
    //private static final long serialVersionUID = 1L;
    private final JButton Select;
    private final JButton Pulisci;
    private final JTextField fornitore;
    private final JTextField Data;
    private final JTextField numero;
    private final JTextField metodo_p;
    private final JButton ordina;
    private final JPanel p2;
    private final JPanel Risult;
    private final JPanel Comandi;
    private final JPanel Campi;
    private final JPanel Group;

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Select) {
            /*codice del db per la select (vedi funzione già creata da davide) */
                /*JOptionPane.showMessageDialog(this, "devo selezionare", "OPERAZIONE",
                        JOptionPane.WARNING_MESSAGE);*/
            try {
                String I_fornitore = fornitore.getText();
                //double I_prezzo = Double.parseDouble(prezzo.getText());
                int check_fornitore = I_fornitore.compareTo("");
                String I_pagamento=metodo_p.getText();

                int check_pagamento = I_pagamento.compareTo("");
                String I_data= Data.getText();
                int check_data=I_data.compareTo("");
                String I_numero= numero.getText();
                int check_numero=I_numero.compareTo("");
                double numero1=0;
                if(check_numero!=0){
                    numero1 = Double.parseDouble(numero.getText());
                }
                JPanel Attivo = new JPanel();
                JPanel Passivo = new JPanel();
                TitledBorder titleBorder = new TitledBorder("Attivo");
                Attivo.setBorder(titleBorder);
                TitledBorder titleBorder1 = new TitledBorder("Passivo");
                Passivo.setBorder(titleBorder1);

                if(check_data != 0 && check_numero!=0 && check_fornitore!=0 && check_pagamento!=0){

                    JScrollPane attivo = new JScrollPane(getTableSelect("SELECT * FROM Attivo  WHERE Azienda=\"" + I_fornitore + "\" "+
                            "and Pagato = \"" + I_pagamento + "\""+
                            "and Numero="+numero1+
                            "and Data= \""+ I_data+"\""));
                    JScrollPane passivo = new JScrollPane(getTableSelect("SELECT * FROM Passivo  WHERE Azienda=\"" + I_fornitore + "\" "+
                            "and Pagato = \"" + I_pagamento + "\""+
                            "and Numero="+numero1+
                            "and Data= '"+ I_data+"'"));
                    Passivo.add(passivo);
                    Attivo.add(attivo);
                }
                else if(check_data!=0){
                    JScrollPane attivo = new JScrollPane(getTableSelect("SELECT * FROM Attivo  WHERE Data= \""+ I_data+"\""));
                    JScrollPane passivo = new JScrollPane(getTableSelect("SELECT * FROM Passivo  WHERE Data= \""+ I_data+"\""));
                    Passivo.add(passivo);
                    Attivo.add(attivo);
                }
                else if(check_numero!=0){
                    JScrollPane attivo = new JScrollPane(getTableSelect("SELECT * FROM Attivo  WHERE Numero="+numero1));
                    JScrollPane passivo = new JScrollPane(getTableSelect("SELECT * FROM Passivo  WHERE Numero="+numero1));
                    Passivo.add(passivo);
                    Attivo.add(attivo);
                }
                else if(check_fornitore!=0){
                    JScrollPane attivo = new JScrollPane(getTableSelect("SELECT * FROM Attivo  WHERE Azienda=\"" + I_fornitore + "\" "+"order by Data"));
                    JScrollPane passivo = new JScrollPane(getTableSelect("SELECT * FROM Passivo  WHERE Azienda=\"" + I_fornitore + "\" "+"order by Data"));
                    Passivo.add(passivo);
                    Attivo.add(attivo);
                }
                else if(check_pagamento!=0){
                    JScrollPane attivo = new JScrollPane(getTableSelect("SELECT * FROM Attivo  WHERE Pagato = \"" + I_pagamento + "\""));
                    JScrollPane passivo = new JScrollPane(getTableSelect("SELECT * FROM Passivo  WHERE Pagato = \"" + I_pagamento + "\""));
                    Passivo.add(passivo);
                    Attivo.add(attivo);
                }


                Risult.add(Attivo, BorderLayout.WEST);
                Risult.add(Passivo, BorderLayout.EAST);
                Risult.revalidate();
                Risult.repaint();

            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }


        }
        if (e.getSource() == Pulisci) {
            Risult.removeAll();
            pack();
            setSize(1200, 739);
            p2.revalidate();
            p2.repaint();
            setVisible(true);
        }
        if (e.getSource() == ordina) {
            try {
                JPanel Attivo1 = new JPanel();
                JPanel Passivo1 = new JPanel();
                JScrollPane ordinatiP = new JScrollPane(getTableSelect("SELECT * FROM passivo order by Data"));
                JScrollPane ordinatiA = new JScrollPane(getTableSelect("SELECT * FROM attivo order by Data_pagamento"));
                Attivo1.add(ordinatiA);
                Passivo1.add(ordinatiP);
                TitledBorder titleBorder1 = new TitledBorder("Passivo");
                Passivo1.setBorder(titleBorder1);
                TitledBorder titleBorder = new TitledBorder("Attivo");
                Attivo1.setBorder(titleBorder);
                Risult.add(Attivo1,BorderLayout.WEST);
                Risult.add(Passivo1,BorderLayout.EAST);
                Risult.revalidate();
                Risult.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
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
        t.setRowHeight(30);
        t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        return t;
    }

    public static void main(String[] args) throws SQLException {

        DBManager.setConnection(Utils.JDBC_Driver_MySQL, Utils.JDBC_URL_MySQL);
        Statement statement = DBManager.getConnection().createStatement();
        SwingUtilities.invokeLater(Look::new);
    }

    public Look() {
        Group=new JPanel(new BorderLayout());
        Comandi = new JPanel(new GridLayout(1, 3));
        Campi = new JPanel(new GridLayout(1,5));
        Risult = new JPanel(new BorderLayout());
        Select = new JButton("Seleziona");
        Select.addActionListener(this);
        Pulisci = new JButton("Pulisci");
        Pulisci.addActionListener(this);
        fornitore = new JTextField("fornitore");
        p2 = new JPanel();
        ordina = new JButton("Ordina");
        ordina.addActionListener(this);
        Comandi.add(ordina,BorderLayout.SOUTH);
        Comandi.add(Select,BorderLayout.SOUTH);
        Comandi.add(Pulisci,BorderLayout.SOUTH);
        Campi.add(fornitore,BorderLayout.NORTH);

        Data = new JTextField("Data");
        metodo_p= new JTextField("Pagamento");
        numero = new JTextField("Numero");
        Campi.add(Data);
        Campi.add(metodo_p);
        Campi.add(numero);
        Group.add(Comandi,BorderLayout.NORTH);
        Group.add(Campi,BorderLayout.SOUTH);

        TitledBorder comandi= new TitledBorder("Comandi");
        Group.setBorder(comandi);
        p2.add(Group,BorderLayout.PAGE_END);
        p2.add(Risult,BorderLayout.NORTH);

        setContentPane(p2);
        pack();
        setSize(1200, 739);
        setVisible(true);
    }
}
