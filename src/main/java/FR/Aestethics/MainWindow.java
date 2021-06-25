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

    JFrame frame = new JFrame();

    JMenuBar m;
    JMenu Menu;
    JMenuItem i1, i2, i3;


    public MainWindow() {
        frame.setTitle("MBE: gestionale d'impresa");
        // Nome=new JTextArea("MBE");
        Payments = new JButton("Gestione fatture");
        //Payments.setBackground(Color.RED);
        Magazzino = new JButton("Gestione magazzino");
        //Magazzino.setBackground(Color.GRAY);
        Corrieri = new JButton("Miglior corriere");
/*
if(e.getSource() == prova){
            SwingUtilities.invokeLater(Look::new);
        }

        */
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
        frame.setResizable(true);
        frame.setSize(420,420);

        m = new JMenuBar();
        Menu = new JMenu("Menu");
        i1 = new JMenuItem("Item 1");
        Menu.add(i1);
        m.add(Menu);

        frame.add(m);

        JPanel p = new JPanel();

        p.add(Payments);
        p.add(Magazzino);
        p.add(Corrieri);

        frame.add(p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}



