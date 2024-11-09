import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DrawingPanel extends JPanel implements ActionListener {
    public JButton startBtn;
    public JButton stopBtn;
    public int offset; 
    public boolean swingForward;
    private Timer timer; // Timer for updating the position

    DrawingPanel() {
        JPanel p1 = new JPanel();
        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");
        startBtn.addActionListener(this);
        stopBtn.addActionListener(this);
        p1.add(startBtn);
        p1.add(stopBtn);
        add(p1, BorderLayout.SOUTH);
        
        // Initialize the swinging state
        swingForward = true; // Start swinging forward
        offset = 0; // Starting offset
        timer = new Timer(30, e -> { // Update every 30 ms
            updatePosition();
            repaint(); // Request repaint after updating position
        });
    }

    public void updatePosition() {
        // Update the swing direction
        if (offset > 70) {
            swingForward = false;
        } else if (offset < -70) {
            swingForward = true;
        }
        
        // Update the offset based on swing direction
        if (swingForward) {
            offset += 2;
        } else {
            offset -= 2;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear previous drawings

        // Drawing code
        g.drawArc(20, 220, 80, 40, 0, 180); // Base
        g.drawLine(20 + 40, 220, 20 + 40, 20); // Vertical pole
        g.drawLine(20 + 40, 20, 20 + 40 + 100, 20); // Horizontal pole
        g.drawLine(20 + 40 + 100, 20, 160 + offset, 40); // Rope on the head
        
        int radius = 20;
        g.drawOval(160 - (radius-offset), 40, 2 * radius, 2 * radius);
        
        g.drawLine(160+offset - (int)(radius * Math.cos(Math.toRadians(45))),
                   40 + radius + (int)(radius * Math.sin(Math.toRadians(45))),
                   160 - 60 + offset*2, 40 + radius + 60); // Left arm

        g.drawLine(160 +offset + (int)(radius * Math.cos(Math.toRadians(45))),
                   40 + radius + (int)(radius * Math.sin(Math.toRadians(45))),
                   160 + 60 + offset*2, 40 + radius + 60); // Right arm

        g.drawLine(160+offset, 40 + 2 * radius, 160+offset*2, 40 + radius + 80); // Body
       
        g.drawLine(160+offset*2, 40 + radius + 80 , 20 + 40 + 100 - 40 + offset*3, 40 + radius + 80 + 40); // Left leg
        g.drawLine(160+offset*2, 40 + radius + 80,
                   20 + 40 + 100 + 40+ offset*3, 40 + radius + 80 + 40); // Right leg
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn) {
            System.out.println("Start button clicked!"); // Output message
            timer.start(); // Start the timer
        } else if (e.getSource() == stopBtn) {
            System.out.println("Stop button clicked!"); // Output message
            timer.stop(); // Stop the timer
        }
    }
}

public class W9_6_hangman {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hangman Example");
        DrawingPanel drawingPanel = new DrawingPanel();

        frame.add(drawingPanel);
        frame.setLocationRelativeTo(null);
        frame.setSize(800, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}