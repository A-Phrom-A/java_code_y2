import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App extends JFrame {

    private JTextField timeDisplay;

    public App() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 3));

        // สร้างปุ่มตัวเลข 0-9
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton("" + i);
            button.addActionListener(e -> timeDisplay.setText(button.getText()));
            p1.add(button);
        }

        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(e -> timeDisplay.setText(zeroButton.getText()));
        p1.add(zeroButton);

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        // เพิ่ม ActionListener ให้กับปุ่ม Start และ Stop
        startButton.addActionListener(e -> timeDisplay.setText("Start"));
        stopButton.addActionListener(e -> timeDisplay.setText("Stop"));

        p1.add(startButton);
        p1.add(stopButton);

        // ตั้งค่าการแสดงผล
        timeDisplay = new JTextField("Time to be displayed here", 20);
        timeDisplay.setEditable(false);

        JPanel p2 = new JPanel(new BorderLayout());
        p2.add(timeDisplay, BorderLayout.NORTH);
        p2.add(p1, BorderLayout.CENTER);

        add(p2, BorderLayout.EAST);
        add(new JButton("Food to be placed here"), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        App frame = new App();
        frame.setTitle("The Front View of a Microwave Oven");
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
