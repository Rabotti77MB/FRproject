package FR.Magazzino;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertView extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Inserisci pacco");
    JTextField Azienda = new JTextField("Azienda");
    JTextField Altezza = new JTextField("Altezza");
    JTextField Larghezza = new JTextField("Larghezza");
    JTextField Profondita = new JTextField("Profondita");
    JTextField Scomparto = new JTextField("Scaffale");
    JTextField Ripiano = new JTextField("Ripiano");
    JTextField Prodotto = new JTextField("Prodotto");
    JButton Conferma = new JButton("Conferma");
    JPanel panel = new JPanel();

    public InsertView() {
        panel.add(Azienda);
        panel.add(Altezza);
        panel.add(Larghezza);
        panel.add(Profondita);
        panel.add(Scomparto);
        panel.add(Ripiano);
        panel.add(Prodotto);
        panel.add(Conferma);

        frame.add(panel);

        frame.getContentPane();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(1000, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InsertView::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
