package FR.Aestethics;

import FR.jdbc.DBManager;
import FR.jdbc.Look;
import FR.utils.Utils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;

public class MainWindow extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private final JButton Payments;
    private final JButton Magazzino;
    private final JButton Corrieri;
    // private final JTextArea Nome;

    JFrame frame = new JFrame();

    // JMenuBar m;
    // JMenu Menu;
    // JMenuItem i1, i2, i3;

    public MainWindow() {
        frame.setTitle("MBE: gestionale d'impresa");
        // Nome=new JTextArea("MBE");
        Payments = new JButton("Gestione fatture");
        Payments.setBackground(Color.BLACK);
        Payments.setPreferredSize(new Dimension(150, 150));
        Payments.setFont(new Font("Arial", Font.PLAIN, 15));
        Payments.setForeground(Color.white);

        Magazzino = new JButton("Magazzino");
        Magazzino.setBackground(Color.RED);
        Magazzino.setPreferredSize(new Dimension(150, 150));
        Magazzino.setFont(new Font("Arial", Font.PLAIN, 15));
        Magazzino.setForeground(Color.black);

        Corrieri = new JButton("Miglior corriere");
        Corrieri.setPreferredSize(new Dimension(150, 150));
        Corrieri.setFont(new Font("Arial", Font.PLAIN, 15));

        // set Look and Feel
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

        // RABBO ImageIcon image = new ImageIcon("C:\\Users\\draxt\\IdeaProjects\\FRproject\\src\\main\\java\\FR\\Aestethics\\logombe.jpg");
        ImageIcon image = new ImageIcon("C:\\Users\\Giovanni\\IdeaProjects\\FRproject\\src\\main\\java\\FR\\Aestethics\\logombe.jpg");
        frame.setIconImage(image.getImage());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400, 400);

        JPanel p = new JPanel();

        p.add(Payments);
        Payments.addActionListener(this);
        p.add(Magazzino);
        Magazzino.addActionListener(this);
        p.add(Corrieri);
        Corrieri.addActionListener(this);
        frame.add(p);

        /* try JFileChooser */
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu mntest = new JMenu("File");
        menuBar.add(mntest);
        JMenuItem mi = new JMenuItem("Open...");
        mntest.add(mi);

        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == mi) {
                    JFileChooser fileChooser = new JFileChooser();
                    /* default JFileChooser is okay from Documents */
                    FileFilter filter = new FileNameExtensionFilter("Excel File","xlsx");
                    fileChooser.setFileFilter(filter);
                    int a = fileChooser.showOpenDialog(null);

                    if (a == JFileChooser.APPROVE_OPTION) {
                        File fileToOpen = fileChooser.getSelectedFile();
                        try {
                            Desktop.getDesktop().open(fileToOpen);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
            }
        });

    }

    @Override
    // change page to Look setting DB connection
    // change page to see warehouse situation
    // change page to display best way to ship an object
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Payments) {
            DBManager.setConnection(Utils.JDBC_Driver_MySQL, Utils.JDBC_URL_MySQL);
            try {
                Statement statement = DBManager.getConnection().createStatement();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            SwingUtilities.invokeLater(Look::new);
        }

        if(e.getSource()==Magazzino){
            System.out.println("Guardiamo il magazzino");
        }
        if(e.getSource()==Corrieri){
            System.out.println("Best Corriere");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }

}



