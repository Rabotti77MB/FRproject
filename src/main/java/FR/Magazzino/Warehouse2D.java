package FR.Magazzino;

import FR.Aestethics.ImageImplement;
import FR.jdbc.DBManager;
import FR.utils.Utils;
import org.apache.xpath.operations.Lt;

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

public class Warehouse2D extends JFrame implements ActionListener {
    JFrame f;
    JPanel Ltati,Base;
    JMenuBar menu;
    JMenu Visualizza;
    JMenu A, B, C, D, E;
    JMenuItem A1, A2, A3;
    JMenuItem B1, B2, B3;
    JMenuItem C1, C2, C3, C4;
    JMenuItem D1, D2, D3, D4;
    JMenuItem E1, E2, E3, E4, E5;

    JMenu Operations = new JMenu("Operazioni");
    JMenuItem Insert = new JMenuItem("Inserisci");
    JMenuItem Delete = new JMenuItem("Rimuovi");
    JMenuItem Pulisco = new JMenuItem("Pulisco");

    private final int height = 100;
    private final int length = 150;
    private final int depth = 50;
    ImageIcon image;
    private ImageImplement panel;
    JLabel label = new JLabel();

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == A1) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='A1'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == A2) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='A2'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == A3) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='A3'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == B1){
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='B1'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == B2) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='B2'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == B3) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='B3'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == C1) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='C1'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == C2) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='C2'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == C3) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='C3'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == C4) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='C4'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == D1) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='D1'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == D2) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='D2'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == D3) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='D3'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == D4) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='D4'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == E1) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='E1'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == E2) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='E2'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == E3) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='E3'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == E4) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='E4'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if (e.getSource() == E5) {
            try {
                JPanel Res=new JPanel(new BorderLayout());
                TitledBorder titleBorder1 = new TitledBorder("Pacchi");
                Res.setBorder(titleBorder1);
                JScrollPane Pacchi = new JScrollPane(getTableSelect("SELECT * FROM pacchi where Scomparto='E5'"));
                Res.add(Pacchi,BorderLayout.CENTER);
                Base.add(Res);
                Base.revalidate();
                Base.repaint();
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(this, "Database Error!");
            }
        }
        if(e.getSource()==Pulisco){
            Base.removeAll();
            Base.repaint();
            Base.revalidate();
        }
        /** --------------------------------------------------*/
        /** --------------------------------------------------*/
        /** --------------------------------------------------*/
        /** --------------------------------------------------*/

        if(e.getSource()==Insert){
            SwingUtilities.invokeLater(InsertView::new);
        }
        if(e.getSource()==Delete){
            SwingUtilities.invokeLater(DeleteView::new);
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
    public Warehouse2D() {
        f = new JFrame();
        f.setTitle("Gestione Magazzino");
        Base= new JPanel();
        Base.setBackground(Color.GREEN);
        //Base.setSize(200,200);
        f.add(Base,BorderLayout.SOUTH);

        label.setIcon(new ImageIcon("C:\\Users\\Giovanni\\IdeaProjects\\FRproject\\src\\main\\java\\FR\\Magazzino\\pianta2Dprova.jpg"));
        f.add(label);
        f.pack();

        menu = new JMenuBar();
        Visualizza = new JMenu("Seleziona scaffale");

        A = new JMenu("A");
        A1 = new JMenuItem("A1");
        A1.addActionListener(this);
        A2 = new JMenuItem("A2");
        A2.addActionListener(this);
        A3 = new JMenuItem("A3");
        A3.addActionListener(this);
        A.add(A1);
        A.add(A2);
        A.add(A3);

        B = new JMenu("B");
        B1 = new JMenuItem("B1");
        B1.addActionListener(this);
        B2 = new JMenuItem("B2");
        B2.addActionListener(this);
        B3 = new JMenuItem("B3");
        B3.addActionListener(this);
        B.add(B1);
        B.add(B2);
        B.add(B3);

        C = new JMenu("C");
        C1 = new JMenuItem("C1");
        C1.addActionListener(this);
        C2 = new JMenuItem("C2");
        C2.addActionListener(this);
        C3 = new JMenuItem("C3");
        C3.addActionListener(this);
        C4 = new JMenuItem("C4");
        C4.addActionListener(this);
        C.add(C1);
        C.add(C2);
        C.add(C3);
        C.add(C4);

        D = new JMenu("D");
        D1 = new JMenuItem("D1");
        D1.addActionListener(this);
        D2 = new JMenuItem("D2");
        D2.addActionListener(this);
        D3 = new JMenuItem("D3");
        D3.addActionListener(this);
        D4 = new JMenuItem("D4");
        D4.addActionListener(this);
        D.add(D1);
        D.add(D2);
        D.add(D3);
        D.add(D4);

        E = new JMenu("E");
        E1 = new JMenuItem("E1");
        E1.addActionListener(this);
        E2 = new JMenuItem("E2");
        E2.addActionListener(this);
        E3 = new JMenuItem("E3");
        E3.addActionListener(this);
        E4 = new JMenuItem("E4");
        E4.addActionListener(this);
        E5 = new JMenuItem("E5");
        E5.addActionListener(this);
        E.add(E1);
        E.add(E2);
        E.add(E3);
        E.add(E4);
        E.add(E5);

        Pulisco.addActionListener(this);
        Visualizza.add(Pulisco);
        Visualizza.add(A);
        Visualizza.add(B);
        Visualizza.add(C);
        Visualizza.add(D);
        Visualizza.add(E);
        menu.add(Visualizza);
        Operations.add(Insert);
        Insert.addActionListener(this);
        Operations.add(Delete);
        Delete.addActionListener(this);
        menu.add(Operations);
        menu.setVisible(true);
        // menu.add(Box.createRigidArea(new Dimension(100,25)));

        f.setJMenuBar(menu);
        f.getContentPane();
        f.setVisible(true);
        f.setResizable(false);
        f.setSize(1500, 850);
        f.setBackground(Color.GRAY);
        //f.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) throws SQLException{

        DBManager.setConnection(Utils.JDBC_Driver_MySQL, Utils.JDBC_URL_MySQL);
        Statement statement = DBManager.getConnection().createStatement();

        SwingUtilities.invokeLater(Warehouse2D::new);
    }


}
