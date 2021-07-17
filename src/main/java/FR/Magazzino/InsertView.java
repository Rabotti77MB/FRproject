package FR.Magazzino;

import FR.jdbc.BasicOperations;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InsertView extends JFrame implements ActionListener {
    BasicOperations Aiuto;

    {
        try {
            Aiuto = new BasicOperations();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    JFrame frame = new JFrame("Inserisci pacco");
    JTextField Azienda = new JTextField("Azienda");
    JTextField Altezza = new JTextField("Altezza");
    JTextField Larghezza = new JTextField("Larghezza");
    JTextField Profondita = new JTextField("Profondita");
    JTextField Scomparto = new JTextField("Scaffale");
    JTextField Ripiano = new JTextField("Ripiano");
    JTextField Prodotto = new JTextField("Prodotto");
    JTextField Peso = new JTextField("Peso");
    JButton Conferma = new JButton("Conferma");
    JPanel panel = new JPanel();

    public InsertView() {
        panel.add(Azienda);
        panel.add(Peso);
        panel.add(Altezza);
        panel.add(Larghezza);
        panel.add(Profondita);
        panel.add(Scomparto);
        panel.add(Ripiano);
        panel.add(Prodotto);
        Conferma.addActionListener(this);
        panel.add(Conferma);
        frame.add(panel);

        frame.getContentPane();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(1000, 200);
        //frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InsertView::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Conferma) {
            System.out.println("daje");
            String I_Azienda = Azienda.getText();
            //double I_prezzo = Double.parseDouble(prezzo.getText());
            int check_Azienda = I_Azienda.compareTo("");
            String I_peso = Peso.getText();
            int check_peso = I_peso.compareTo("");
            String I_Altezza = Altezza.getText();
            int check_Altezza = I_Altezza.compareTo("");
            String I_Larghezza = Larghezza.getText();
            int check_Larghezza = I_Larghezza.compareTo("");
            String I_profondita = Profondita.getText();
            int check_profondita = I_profondita.compareTo("");
            double altezza = 0, larghezza = 0, profondita = 0, peso = 0;
            int ripiano = 0;

            String I_scomparto = Scomparto.getText();
            int check_scomparto = I_scomparto.compareTo("");

            String I_ripiano = Ripiano.getText();
            int check_ripiano = I_ripiano.compareTo("");
            String I_prodotto = Prodotto.getText();
            int check_prodotto = I_prodotto.compareTo("");
            System.out.println(check_Altezza);
            System.out.println(check_prodotto);
            System.out.println(check_Azienda);
            System.out.println(check_Larghezza);
            System.out.println(check_peso);
            System.out.println(check_profondita);
            System.out.println(check_ripiano);
            System.out.println(check_scomparto);
            if (check_peso != 0 && check_Altezza != 0 && check_Larghezza != 0 && check_profondita != 0 && check_ripiano != 0 && check_Azienda != 0 && check_prodotto != 0 && check_ripiano != 0 && check_scomparto != 0) {
                System.out.println("dentro");
                altezza = Double.parseDouble(Altezza.getText());
                profondita = Double.parseDouble(Profondita.getText());
                larghezza = Double.parseDouble(Larghezza.getText());
                peso = Double.parseDouble(Peso.getText());
                ripiano = Integer.parseInt(Ripiano.getText());
                    /*System.out.println(I_Azienda);
                    System.out.println(peso);
                    System.out.println(altezza);
                    System.out.println(larghezza);
                    System.out.println(profondita);
                    System.out.println(I_scomparto);
                    System.out.println(I_prodotto);*/
                try {
                    Aiuto.TestInsertPacchi(I_Azienda, peso, altezza, larghezza, profondita, I_scomparto, ripiano, I_prodotto);
                    JOptionPane.showMessageDialog(this, "INSERIMENTO CORRETTO!");
                } catch (SQLException throwables) {
                    System.out.println("errore");

                    JOptionPane.showMessageDialog(this, "ERRORE NELL'INSERIMENTO!");
                    throwables.printStackTrace();
                }

            }

        }
    }
}