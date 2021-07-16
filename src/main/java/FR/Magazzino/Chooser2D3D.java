package FR.Magazzino;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chooser2D3D extends JFrame implements ActionListener {
    public JFrame frame;
    public JPanel panel;
    public JButton c2D;
    public JButton c3D;
    public ImageIcon im;

    boolean dim2 = false;
    boolean dim3 = false;

    public Chooser2D3D() {
        frame = new JFrame();

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

        panel = new JPanel();
        c2D = new JButton("Pianta 2D");
        c2D.addActionListener(this);

        c3D = new JButton("Pianta 3D");
        c3D.addActionListener(this);

        panel.add(c2D);
        panel.add(c3D);
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void Selection2() {
        dim2 = true;
    }

    public void Selection3() {
        dim3 = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == c2D) {
            im = new ImageIcon("C:\\Users\\Giovanni\\IdeaProjects\\FRproject\\src\\main\\java\\FR\\Magazzino\\Pianta.jpg");
            Selection2();
        }
        if (e.getSource() == c3D) {
            im = new ImageIcon("C:\\Users\\Giovanni\\IdeaProjects\\FRproject\\src\\main\\java\\FR\\Magazzino\\Pianta3D.jpg");
            Selection3();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Chooser2D3D::new);
    }
}
