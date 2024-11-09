import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class W9_4_GUI_dollars extends JFrame {
  
    private JTextField jtfUSADollars = new JTextField();
    private JTextField jtfCanadianDollars = new JTextField();
    
    
    private JButton jbtConvert = new JButton("Convert");

    public W9_4_GUI_dollars() {
        Dimension textFieldSize = new Dimension(150, 10);
        jtfCanadianDollars.setPreferredSize(textFieldSize);
        jtfUSADollars.setPreferredSize(textFieldSize);

        
        // Panel p1 to hold labels and text fields
        JPanel p1 = new JPanel(new GridLayout(2, 2));
        p1.add(new JLabel("US Dollars"));
        p1.add(jtfUSADollars);
        
        p1.add(new JLabel("Canadian Dollars"));
        p1.add(jtfCanadianDollars);
        jtfCanadianDollars.setEditable(false); 
        

 

        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p2.add(jbtConvert);

        // Add the panels to the frame
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        // Register listener for the button
        jbtConvert.addActionListener(new ButtonListener());
    }

    /** Handle the Convert button */
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get values from text fields
            try {
                double usd = Double.parseDouble(jtfUSADollars.getText());
                double cad = convertToCAD(usd); // Convert to Canadian Dollars
                
                // Display the result
                jtfCanadianDollars.setText(String.format("%.2f", cad));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }

        // Conversion method (example rate, adjust as needed)
        private double convertToCAD(double usd) {
            double conversionRate = 1.5; // Example conversion rate from USD to CAD
            return usd * conversionRate;
        }
    }

    public static void main(String[] args) {
        W9_4_GUI_dollars frame = new W9_4_GUI_dollars();
        frame.pack();
        frame.setTitle("US Dollars to Canadian Dollars");
        frame.setSize(400, 250); // กำหนดขนาดของ JFrame
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
