package FR.Aestethics;

import javax.swing.*;
import java.awt.*;

public class IntroLoading extends JFrame {
    private JFrame frame = new JFrame("Gestionale MBE");
    private Timer timer;
    private int count = 0;
    private JLabel label = new JLabel();
    private JPanel p = new JPanel();

    public IntroLoading() {
        //ImageIcon image = new ImageIcon("C:\\Users\\draxt\\IdeaProjects\\ProgettoFR\\src\\main\\java\\FR\\Aestethics\\logombe.jpg");
        ImageIcon image = new ImageIcon("C:\\Users\\Giovanni\\IdeaProjects\\FRproject\\src\\main\\java\\FR\\Aestethics\\logombe.jpg");
        frame.setIconImage(image.getImage());
        // panel = new ImageImplement(new ImageIcon("C:\\Users\\Giovanni\\IdeaProjects\\FRproject\\src\\main\\java\\FR\\Aestethics\\logombe.jpg").getImage());
        label.setIcon(new ImageIcon("C:\\Users\\Giovanni\\IdeaProjects\\FRproject\\src\\main\\java\\FR\\Aestethics\\logombe.jpg"));
        p.add(label);
        p.setBackground(Color.BLACK);
        frame.add(p);
        frame.pack();
        frame.getContentPane();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(300, 225);
        frame.setBackground(Color.BLUE);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set delay with timer just to simulate a loading moment
        while (true) {
            int delay = 5000; // Delay in milliseconds
            timer = new Timer(delay, e -> {
                // System.out.println("Delay");
                frame.setVisible(false); // Hide the first frame
                // frame.validate();
                if (count == 0) {
                    SwingUtilities.invokeLater(MainWindow::new);
                    count++;
                }

            });
            timer.start();
            break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(IntroLoading::new);
    }
}

