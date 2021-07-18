package FR.jdbc;

import FR.utils.Utils;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Look extends JFrame implements ActionListener {
    //private static final long serialVersionUID = 1L;
    private final JButton Select;
    private final JButton Pulisci;
    private final JTextField fornitore;
    private final JTextField Data;
    private final JTextField numero;
    private final JTextField metodo_p;
    private final JButton selezionaTutto;
    private final JPanel p2;
    private final JPanel Risult;
    private final JPanel Comandi;
    private final JPanel Campi;
    private final JPanel Group;
    private final JButton ordinaForn;
    private final JButton ordinaPrezz;
    private final JButton ordinaData;
    private final JButton ordinaNum;
    private final JLabel informazione;
    private final JButton ordinaIncass;
    private final JButton ordinaBanca;
    private final JPanel Comandi1;
    private final JPanel Comandi2;
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Select) {
            /*codice del db per la select (vedi funzione già creata da davide) */
                /*JOptionPane.showMessageDialog(this, "devo selezionare", "OPERAZIONE",
                        JOptionPane.WARNING_MESSAGE);*/
            try {
                String I_fornitore = fornitore.getText();
                //double I_prezzo = Double.parseDouble(prezzo.getText());
                int check_fornitore = I_fornitore.compareTo("");
                String I_pagamento = metodo_p.getText();

                int check_pagamento = I_pagamento.compareTo("");
                String I_data = Data.getText();
                int check_data = I_data.compareTo("");
                String I_numero = numero.getText();
                int check_numero = I_numero.compareTo("");
                double numero1 = 0;
                if (check_numero != 0) {
                    numero1 = Double.parseDouble(numero.getText());
                }
                JPanel Attivo = new JPanel();
                JPanel Passivo = new JPanel();
                TitledBorder titleBorder = new TitledBorder("Attivo");
                Attivo.setBorder(titleBorder);
                TitledBorder titleBorder1 = new TitledBorder("Passivo");
                Passivo.setBorder(titleBorder1);

                if (check_data != 0 && check_numero != 0 && check_fornitore != 0 && check_pagamento != 0) {

                    JScrollPane attivo = new JScrollPane(getTableSelect("SELECT * FROM Attivo  WHERE Azienda=\"" + I_fornitore + "\" " +
                            "and Pagato = \"" + I_pagamento + "\"" +
                            "and Numero=" + numero1 +
                            "and Data= \"" + I_data + "\""));
                    JScrollPane passivo = new JScrollPane(getTableSelect("SELECT * FROM Passivo  WHERE Azienda=\"" + I_fornitore + "\" " +
                            "and Pagato = \"" + I_pagamento + "\"" +
                            "and Numero=" + numero1 +
                            "and Data= '" + I_data + "'"));
                    Passivo.add(passivo);
                    Attivo.add(attivo);
                } else if (check_data != 0) {
                    JScrollPane attivo = new JScrollPane(getTableSelect("SELECT * FROM Attivo  WHERE Data= \"" + I_data + "\""));
                    JScrollPane passivo = new JScrollPane(getTableSelect("SELECT * FROM Passivo  WHERE Data= \"" + I_data + "\""));
                    Passivo.add(passivo);
                    Attivo.add(attivo);
                } else if (check_numero != 0) {
                    JScrollPane attivo = new JScrollPane(getTableSelect("SELECT * FROM Attivo  WHERE Numero=" + numero1));
                    JScrollPane passivo = new JScrollPane(getTableSelect("SELECT * FROM Passivo  WHERE Numero=" + numero1));
                    Passivo.add(passivo);
                    Attivo.add(attivo);
                } else if (check_fornitore != 0) {
                    JScrollPane attivo = new JScrollPane(getTableSelect("SELECT * FROM Attivo  WHERE Azienda=\"" + I_fornitore + "\" " + "order by Data"));
                    JScrollPane passivo = new JScrollPane(getTableSelect("SELECT * FROM Passivo  WHERE Azienda=\"" + I_fornitore + "\" " + "order by Data"));
                    Passivo.add(passivo);
                    Attivo.add(attivo);
                } else if (check_pagamento != 0) {
                    JScrollPane attivo = new JScrollPane(getTableSelect("SELECT * FROM Attivo  WHERE Incasso = \"" + I_pagamento + "\""));
                    JScrollPane passivo = new JScrollPane(getTableSelect("SELECT * FROM Passivo  WHERE Incasso = \"" + I_pagamento + "\""));
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
            setSize(1500, 739);
            p2.revalidate();
            p2.repaint();
            setVisible(true);
        }
        if (e.getSource() == selezionaTutto) {
            try {
                JPanel Attivo1 = new JPanel();
                JPanel Passivo1 = new JPanel();
                JScrollPane ordinatiP = new JScrollPane(getTableSelect("SELECT * FROM passivo"));
                JScrollPane ordinatiA = new JScrollPane(getTableSelect("SELECT * FROM attivo "));
                Attivo1.add(ordinatiA);
                Passivo1.add(ordinatiP);
                TitledBorder titleBorder1 = new TitledBorder("Passivo");
                Passivo1.setBorder(titleBorder1);
                TitledBorder titleBorder = new TitledBorder("Attivo");
                Attivo1.setBorder(titleBorder);
                Risult.add(Attivo1, BorderLayout.WEST);
                Risult.add(Passivo1, BorderLayout.EAST);
                Risult.revalidate();
                Risult.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == ordinaForn) {
            try {
                JPanel Attivo1 = new JPanel();
                JPanel Passivo1 = new JPanel();
                JScrollPane ordinatiP = new JScrollPane(getTableSelect("SELECT * FROM passivo order by Azienda"));
                JScrollPane ordinatiA = new JScrollPane(getTableSelect("SELECT * FROM attivo order by Azienda"));
                Attivo1.add(ordinatiA);
                Passivo1.add(ordinatiP);
                TitledBorder titleBorder1 = new TitledBorder("Passivo");
                Passivo1.setBorder(titleBorder1);
                TitledBorder titleBorder = new TitledBorder("Attivo");
                Attivo1.setBorder(titleBorder);
                Risult.add(Attivo1, BorderLayout.WEST);
                Risult.add(Passivo1, BorderLayout.EAST);
                Risult.revalidate();
                Risult.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == ordinaPrezz) {
            try {
                JPanel Attivo1 = new JPanel();
                JPanel Passivo1 = new JPanel();
                JScrollPane ordinatiP = new JScrollPane(getTableSelect("SELECT * FROM passivo order by Importo"));
                JScrollPane ordinatiA = new JScrollPane(getTableSelect("SELECT * FROM attivo order by Importo"));
                Attivo1.add(ordinatiA);
                Passivo1.add(ordinatiP);
                TitledBorder titleBorder1 = new TitledBorder("Passivo");
                Passivo1.setBorder(titleBorder1);
                TitledBorder titleBorder = new TitledBorder("Attivo");
                Attivo1.setBorder(titleBorder);
                Risult.add(Attivo1, BorderLayout.WEST);
                Risult.add(Passivo1, BorderLayout.EAST);
                Risult.revalidate();
                Risult.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == ordinaData) {
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
                Risult.add(Attivo1, BorderLayout.WEST);
                Risult.add(Passivo1, BorderLayout.EAST);
                Risult.revalidate();
                Risult.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == ordinaNum) {
            try {
                JPanel Attivo1 = new JPanel();
                JPanel Passivo1 = new JPanel();
                JScrollPane ordinatiP = new JScrollPane(getTableSelect("SELECT * FROM passivo order by Numero"));
                JScrollPane ordinatiA = new JScrollPane(getTableSelect("SELECT * FROM attivo order by Numero"));
                Attivo1.add(ordinatiA);
                Passivo1.add(ordinatiP);
                TitledBorder titleBorder1 = new TitledBorder("Passivo");
                Passivo1.setBorder(titleBorder1);
                TitledBorder titleBorder = new TitledBorder("Attivo");
                Attivo1.setBorder(titleBorder);
                Risult.add(Attivo1, BorderLayout.WEST);
                Risult.add(Passivo1, BorderLayout.EAST);
                Risult.revalidate();
                Risult.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == ordinaIncass) {
            try {
                JPanel Attivo1 = new JPanel();
                JPanel Passivo1 = new JPanel();
                JScrollPane ordinatiP = new JScrollPane(getTableSelect("SELECT * FROM passivo order by Incasso"));
                JScrollPane ordinatiA = new JScrollPane(getTableSelect("SELECT * FROM attivo order by Incasso"));
                Attivo1.add(ordinatiA);
                Passivo1.add(ordinatiP);
                TitledBorder titleBorder1 = new TitledBorder("Passivo");
                Passivo1.setBorder(titleBorder1);
                TitledBorder titleBorder = new TitledBorder("Attivo");
                Attivo1.setBorder(titleBorder);
                Risult.add(Attivo1, BorderLayout.WEST);
                Risult.add(Passivo1, BorderLayout.EAST);
                Risult.revalidate();
                Risult.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == ordinaBanca) {
            try {
                JPanel Attivo1 = new JPanel();
                JPanel Passivo1 = new JPanel();
                JScrollPane ordinatiP = new JScrollPane(getTableSelect("SELECT * FROM passivo order by Banca"));
                JScrollPane ordinatiA = new JScrollPane(getTableSelect("SELECT * FROM attivo order by Banca"));
                Attivo1.add(ordinatiA);
                Passivo1.add(ordinatiP);
                TitledBorder titleBorder1 = new TitledBorder("Passivo");
                Passivo1.setBorder(titleBorder1);
                TitledBorder titleBorder = new TitledBorder("Attivo");
                Attivo1.setBorder(titleBorder);
                Risult.add(Attivo1, BorderLayout.WEST);
                Risult.add(Passivo1, BorderLayout.EAST);
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
        Comandi1 = new JPanel(new GridLayout(1,5));
        Comandi2= new JPanel(new GridLayout(1,4));
        ordinaBanca=new JButton("Ordina per Banca");
        ordinaBanca.addActionListener(this);
        ordinaIncass=new JButton("Ordina per Pagamento");
        ordinaIncass.addActionListener(this);
        ordinaNum= new JButton("Ordina per Numero ");
        ordinaNum.addActionListener(this);
        ordinaData= new JButton("Ordina per Data");
        ordinaData.addActionListener(this);
        informazione=new JLabel("PER UTILIZZARE IL TASTO SELEZIONA SCRIVERE NELLA CASELLA DESIDERATA E CANCELLARE IL CONTENUTO DEGLI ALTRI CAMPI. OPPURE RIEMPIRLI TUTTI E 4");
        Group = new JPanel(new BorderLayout());
        Comandi = new JPanel();
        Campi = new JPanel(new GridLayout(1, 4));
        Risult = new JPanel(new BorderLayout());
        Select = new JButton("Seleziona");
        ordinaForn= new JButton("Ordina per Azienda");
        ordinaForn.addActionListener(this);
        Select.addActionListener(this);
        Pulisci = new JButton("Pulisci");
        Pulisci.addActionListener(this);
        fornitore = new JTextField("fornitore");
        p2 = new JPanel();
        ordinaPrezz=new JButton("Ordina per Importo");
        ordinaPrezz.addActionListener(this);

        selezionaTutto = new JButton("Seleziona tutto");
        selezionaTutto.addActionListener(this);
        Comandi1.add(ordinaBanca,BorderLayout.SOUTH);
        Comandi1.add(ordinaPrezz, BorderLayout.SOUTH);
        Comandi1.add(ordinaData, BorderLayout.SOUTH);
        Comandi1.add(ordinaIncass,BorderLayout.SOUTH);
        Comandi1.add(selezionaTutto, BorderLayout.SOUTH);
        Comandi2.add(ordinaForn, BorderLayout.SOUTH);
        Comandi2.add(Select, BorderLayout.SOUTH);
        Comandi2.add(Pulisci, BorderLayout.SOUTH);
        Comandi2.add(ordinaNum,BorderLayout.SOUTH);
        Campi.add(fornitore, BorderLayout.NORTH);
        Comandi.add(Comandi1,BorderLayout.NORTH);
        Comandi.add(Comandi2,BorderLayout.SOUTH);
        Data = new JTextField("Data");
        metodo_p = new JTextField("Pagamento");
        numero = new JTextField("Numero");
        Campi.add(Data);
        Campi.add(metodo_p);
        Campi.add(numero);
        Group.add(Comandi, BorderLayout.NORTH);
        Group.add(Campi, BorderLayout.SOUTH);

        TitledBorder comandi = new TitledBorder("Comandi");
        Group.setBorder(comandi);
        p2.add(Group, BorderLayout.PAGE_END);
        p2.add(Risult, BorderLayout.NORTH);
        p2.add(informazione, BorderLayout.PAGE_END);

        setContentPane(p2);
        pack();
        setSize(1500, 739);
        setVisible(true);
    }
}
