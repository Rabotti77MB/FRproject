package FR.Aestethics;

import javax.swing.*;
import java.awt.*;

public class ImageImplement extends JPanel {
    private Image img;

    public ImageImplement(Image img) {
        this.img = img;
        Dimension size = new Dimension(400,400);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 75, 50, null);
    }
}


