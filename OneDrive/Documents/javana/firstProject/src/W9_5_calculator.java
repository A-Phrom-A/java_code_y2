import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class W9_5_calculator extends JFrame {
    private JTextField textField;
    private double num1, num2, result;
    private String operator;

    public W9_5_calculator() {
        setTitle("เครื่องคิดเลข");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+",
            "√", "^", "±", "."
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
                textField.setText(textField.getText() + command);
            } else if (command.charAt(0) == 'C') {
                textField.setText("");
                num1 = num2 = result = 0;
                operator = "";
            } else if (command.charAt(0) == '=') {
                num2 = Double.parseDouble(textField.getText());
                calculate();
                textField.setText(String.valueOf(result));
                operator = "";
            } else if (command.equals("√")) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.sqrt(num1);
                textField.setText(String.valueOf(result));
            } else if (command.equals("^")) {
                num1 = Double.parseDouble(textField.getText());
                operator = command;
                textField.setText("");
            } else if (command.equals("±")) {
                num1 = Double.parseDouble(textField.getText());
                result = -num1;
                textField.setText(String.valueOf(result));
            } else {
                if (!operator.isEmpty()) {
                    return;
                }
                num1 = Double.parseDouble(textField.getText());
                operator = command;
                textField.setText("");
            }
        }

        private void calculate() {
            if (operator.equals("^")) {
                result = Math.pow(num1, num2);
            } else {
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            JOptionPane.showMessageDialog(null, "ไม่สามารถหารด้วยศูนย์!");
                            result = 0;
                        }
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            W9_5_calculator calculator = new W9_5_calculator();
            calculator.setVisible(true);
        });
    }
}
