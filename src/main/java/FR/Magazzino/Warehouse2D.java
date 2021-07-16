package FR.Magazzino;

import FR.Aestethics.ImageImplement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Warehouse2D extends JFrame implements ActionListener {
    JFrame f;
    JPanel p;
    JMenuBar menu;
    JMenu A, B, C, D, E;
    JMenuItem A1, A2, A3;
    JMenuItem B1, B2, B3;
    JMenuItem C1, C2, C3, C4;
    JMenuItem D1, D2, D3, D4;
    JMenuItem E1, E2, E3, E4, E5;
    private final int height = 100;
    private final int length = 150;
    private final int depth = 50;
    ImageIcon image;
    private ImageImplement panel;
    JLabel label=new JLabel();

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public Warehouse2D() {
        f = new JFrame();
        f.setTitle("Gestione Magazzino");

        p = new JPanel();
        label.setIcon(new ImageIcon("C:\\Users\\Giovanni\\IdeaProjects\\FRproject\\src\\main\\java\\FR\\Magazzino\\pianta2Dprova.jpg"));
        f.add(label);
        f.pack();

        menu = new JMenuBar();

        A = new JMenu();
        A1 = new JMenuItem();
        A2 = new JMenuItem();
        A3 = new JMenuItem();
        A.add(A1);
        A.add(A2);
        A.add(A3);

        B = new JMenu();
        B1 = new JMenuItem();
        B2 = new JMenuItem();
        B3 = new JMenuItem();
        B.add(B1);
        B.add(B2);
        B.add(B3);

        C = new JMenu();
        C1 = new JMenuItem();
        C2 = new JMenuItem();
        C3 = new JMenuItem();
        C4 = new JMenuItem();
        C.add(C1);
        C.add(C2);
        C.add(C3);
        C.add(C4);

        D = new JMenu();
        D1 = new JMenuItem();
        D2 = new JMenuItem();
        D3 = new JMenuItem();
        D4 = new JMenuItem();
        D.add(D1);
        D.add(D2);
        D.add(D3);
        D.add(D4);

        E = new JMenu();
        E1 = new JMenuItem();
        E2 = new JMenuItem();
        E3 = new JMenuItem();
        E4 = new JMenuItem();
        E5 = new JMenuItem();
        E.add(E1);
        E.add(E2);
        E.add(E3);
        E.add(E4);
        E.add(E5);

        menu.add(A);
        menu.add(B);
        menu.add(C);
        menu.add(D);
        menu.add(E);
        menu.setVisible(true);
        menu.add(Box.createRigidArea(new Dimension(100,25)));
        f.setJMenuBar(menu);

        f.setVisible(true);
        f.setResizable(false);
        f.setSize(1500, 850);
        f.setBackground(Color.GRAY);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Warehouse2D::new);
    }


}
