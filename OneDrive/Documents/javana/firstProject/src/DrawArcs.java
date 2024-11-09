import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawArcs extends JFrame {
    public int A = 0;
    public int B = 90;
    public int C = 180;
    public int D = 270;

    private ArcsPanel arcsPanel;
    private Timer timer; // ตัวจัดการเวลา

    DrawArcs() {
        arcsPanel = new ArcsPanel();
        add(arcsPanel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        
        JButton buttonA = new JButton("stop");
        JButton buttonB = new JButton("1");
        JButton buttonC = new JButton("2");
        JButton buttonD = new JButton("3");

        // ปุ่ม A เพื่อหยุดการทำงานของ Timer
        buttonA.addActionListener(e -> {
            if (timer != null && timer.isRunning()) {
                timer.stop();
            }
            fan(0);  
        });

        // ปุ่ม B เพื่อเริ่มทำงานต่อเนื่อง
        buttonB.addActionListener(e -> startFan(1));
        
        // ปุ่ม C เพื่อเริ่มทำงานต่อเนื่อง
        buttonC.addActionListener(e -> startFan(3));
        
        // ปุ่ม D เพื่อเริ่มทำงานต่อเนื่อง
        buttonD.addActionListener(e -> startFan(6));

        buttonPanel.add(buttonA);
        buttonPanel.add(buttonB);
        buttonPanel.add(buttonC);
        buttonPanel.add(buttonD);
    }

    class ArcsPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int r = (int)(Math.min(getWidth(), getHeight()) * 0.4);
            int xCenter = getWidth() / 2;
            int yCenter = getHeight() / 2;

            int x = xCenter - r;
            int y = yCenter - r;

            g.fillArc(x, y, 2 * r, 2 * r, A, 30);
            g.fillArc(x, y, 2 * r, 2 * r, B, 30);
            g.fillArc(x, y, 2 * r, 2 * r, C, 30);
            g.fillArc(x, y, 2 * r, 2 * r, D, 30);
        }
    }

    // ฟังก์ชันเพื่อเพิ่มมุม
    private void fan(int S) {
        A = (A + S) % 360;
        B = (B + S) % 360;
        C = (C + S) % 360;
        D = (D + S) % 360;
        arcsPanel.repaint();
    }

    
    private void startFan(int S) {
        if (timer != null && timer.isRunning()) {
            timer.stop(); 
        }
        
        timer = new Timer(100, e -> fan(S)); 
        timer.start(); 
    }

    public static void main(String[] args) {
        DrawArcs frame = new DrawArcs();
        frame.setSize(720, 720);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}