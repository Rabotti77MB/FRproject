package FR.Aestethics;

import FR.jdbc.DBManager;
import FR.jdbc.Look;
import FR.utils.Utils;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MainWindow extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private final JButton Payments;
    private final JButton Magazzino;
    private final JButton Corrieri;
    // private final JTextArea Nome;

    JFrame frame = new JFrame();

    JMenuBar m;
    JMenu Menu;
    JMenuItem i1, i2, i3;


    public MainWindow() {
        frame.setTitle("MBE: gestionale d'impresa");
        // Nome=new JTextArea("MBE");
        Payments = new JButton("Gestione fatture");
        Payments.setBackground(Color.BLACK);
        Payments.setPreferredSize(new Dimension(150,150));
        Payments.setFont(new Font("Arial", Font.PLAIN, 15));
        Payments.setForeground(Color.white);

        Magazzino = new JButton("Magazzino");
        Magazzino.setBackground(Color.RED);
        Magazzino.setPreferredSize(new Dimension(150,150));
        Magazzino.setFont(new Font("Arial", Font.PLAIN, 15));
        Magazzino.setForeground(Color.black);

        Corrieri = new JButton("Miglior corriere");
        Corrieri.setPreferredSize(new Dimension(150,150));
        Corrieri.setFont(new Font("Arial", Font.PLAIN, 15));

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
            e.printStackTrace();
        }

        ImageIcon image = new ImageIcon("C:\\Users\\Giovanni\\IdeaProjects\\FRproject\\src\\main\\java\\FR\\Aestethics\\logombe.jpg");
        frame.setIconImage(image.getImage());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(420, 420);

        m = new JMenuBar();
        Menu = new JMenu("Menu");
        i1 = new JMenuItem("Item 1");
        Menu.add(i1);
        m.add(Menu);

        frame.add(m);

        JPanel p = new JPanel();

        p.add(Payments);
        Payments.addActionListener(this);
        p.add(Magazzino);
        p.add(Corrieri);
        frame.add(p);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* if (e.getSource() == Payments) {
            frame.getContentPane().removeAll();
            Look Fatture = new Look();
            add(Fatture);
            setVisible(true);
        } */
        if(e.getSource() == Payments){
            DBManager.setConnection(Utils.JDBC_Driver_MySQL, Utils.JDBC_URL_MySQL);
            try{
                Statement statement = DBManager.getConnection().createStatement();
            } catch(Exception e1){
                e1.printStackTrace();
            }
            SwingUtilities.invokeLater(Look::new);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }

}



