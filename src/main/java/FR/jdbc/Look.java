package FR.jdbc;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Look extends JFrame implements ActionListener{
   //private static final long serialVersionUID = 1L;
    private final JButton Select;
    private final JButton Insert;
    private final JTextField fornitore;
    private final JTextField prezzo;
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Select) {
            String I_fornitore = fornitore.getText();
            double I_prezzo = Double.parseDouble(prezzo.getText());
            int r= I_fornitore.compareTo("");
            if(r!=0 && I_prezzo!=0) {
                /*codice del db per la select (vedi funzione già creata da davide) */
                /*JOptionPane.showMessageDialog(this, "devo selezionare", "OPERAZIONE",
                        JOptionPane.WARNING_MESSAGE);*/


            }

        }
        if (e.getSource() == Insert) {
            String I_fornitore = fornitore.getText();
            double I_prezzo = Double.parseDouble(prezzo.getText());
            int r= I_fornitore.compareTo("");
            if (I_prezzo > 0 && r!=0) {
                /* codice del db per la insert (vedi funzione già creata da davide)
                JOptionPane.showMessageDialog(this, "DEVO INSERIRE!", "INSERT",
                        JOptionPane.WARNING_MESSAGE);*/


            }
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(Look::new);
    }

    public Look() {
        Select = new JButton("Seleziona");
        Select.addActionListener(this);
        Insert = new JButton("Inserisci");
        Insert.addActionListener(this);
        fornitore= new JTextField(" inserisci fornitore");
        prezzo= new JTextField(" inserisci prezzo");


        JPanel p2 = new JPanel();
        p2.add(Select,BorderLayout.SOUTH);
        p2.add(Insert);
        p2.add(fornitore,BorderLayout.WEST);
        p2.add(prezzo,BorderLayout.EAST);



        setContentPane(p2);
        pack();
        setSize(400,200);
        setVisible(true);
    }
}
