package FR.Aestethics;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JButton Payments;
    private final JButton Magazzino;
    private final JButton Corrieri;
    // private final JTextArea Nome;

    JMenuBar m;
    JMenu Menu;
    JMenuItem i1, i2, i3;


    public MainWindow() {
        super("MBE: gestionale d'impresa");
        // Nome=new JTextArea("MBE");
        Payments = new JButton("Gestione fatture");
        //Payments.setBackground(Color.RED);
        Magazzino = new JButton("Gestione magazzino");
        //Magazzino.setBackground(Color.GRAY);
        Corrieri = new JButton("Miglior corriere");

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

        m = new JMenuBar();
        Menu = new JMenu("Menu");
        i1 = new JMenuItem("Item 1");
        Menu.add(i1);
        m.add(Menu);

        JFrame p1 = new JFrame();
        JPanel p = new JPanel();
        // p.setBackground(Color.BLUE);
        // p1.getContentPane().add(new JPanelBackground("mbe.jpg"));
        // p1.add(m);
        // p1.setJMenuBar(m);

        // JPanel p2 = new JPanel(new GridLayout());
        // p1.add(Nome,BorderLayout.NORTH);
        p.add(Payments);
        // p1.add(new JLabel("°C"));
        p.add(Magazzino);
        p.add(Corrieri);

        p1.add(p);

        /** JPanel p2 = new JPanel(new GridLayout(1, 2));
         p2.add(CFButton);
         p2.add(FCButton);

         JPanel p3 = new JPanel(new BorderLayout());
         p3.add(p1, BorderLayout.CENTER);
         p3.add(p2, BorderLayout.PAGE_END); */

        /** JFrame methods called */
        setContentPane(p);
        // add(Menu);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(375, 110);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}



