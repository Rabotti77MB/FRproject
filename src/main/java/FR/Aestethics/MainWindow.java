package FR.Aestethics;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JButton Payments;
    private final JButton Magazzino;
    private final JButton Corrieri;
    // private final JTextArea Nome;

    public MainWindow() {
        super("MBE: gestionale d'impresa");
        // Nome=new JTextArea("MBE");
        Payments = new JButton("Gestione fatture");
        Payments.setBackground(Color.RED);
        Magazzino = new JButton("Gestione magazzino");
        Magazzino.setBackground(Color.GRAY);
        Corrieri = new JButton("Miglior corriere");

        JPanel p1 = new JPanel();
        p1.setBackground(Color.BLUE);
        // p1.getContentPane().add(new JPanelBackground("mbe.jpg"));

        // JPanel p2 = new JPanel(new GridLayout());
        // p1.add(Nome,BorderLayout.NORTH);
        p1.add(Payments);
        // p1.add(new JLabel("°C"));
        p1.add(Magazzino);
        p1.add(Corrieri);

        /** JPanel p2 = new JPanel(new GridLayout(1, 2));
         p2.add(CFButton);
         p2.add(FCButton);

         JPanel p3 = new JPanel(new BorderLayout());
         p3.add(p1, BorderLayout.CENTER);
         p3.add(p2, BorderLayout.PAGE_END); */

        /** JFrame methods called */
        setContentPane(p1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(375, 110);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}



