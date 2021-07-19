package FR.Aestethics;

import javax.swing.*;
import java.awt.*;

public class ImageInJframe extends JFrame {
    private ImageImplement panel;
    private JFrame frame = new JFrame();
    private Timer timer;
    private int count = 0;

    public ImageInJframe() {
        ImageIcon image = new ImageIcon("C:\\Users\\draxt\\IdeaProjects\\ProgettoFR\\src\\main\\java\\FR\\Aestethics\\logombe.jpg");
        frame.setIconImage(image.getImage());
        panel = new ImageImplement(new ImageIcon("C:\\Users\\draxt\\IdeaProjects\\ProgettoFR\\src\\main\\java\\FR\\Aestethics\\logombe.jpg").getImage());
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set delay with timer just to simulate a loading moment
        while(true) {
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

}

