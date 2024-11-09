import java.awt.*;

import javax.swing.*;

public class W10_3Exercise extends JFrame {
    public W10_3Exercise() {
        add(new RaceCar());
    }

    public static void main(String[] args) {
        W10_3Exercise frame = new W10_3Exercise();
        frame.setTitle("Exercise");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 100);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}

class RaceCar extends JPanel {
    private int carPositionX = 0;

    public RaceCar() {
        // Start the game thread
        Thread gameThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    // Update car position
                    if (carPositionX > getWidth()) {
                        carPositionX = -50; // Reset to the left of the screen
                    } else {
                        carPositionX += 1; // Move car to the right
                    }
                    repaint(); // Request a repaint
                    try {
                        Thread.sleep(20); // Control the speed of the car
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // Restore interrupt status
                    }
                }
            }
        });
        gameThread.start(); // Start the game thread
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yBase = getHeight();

        // Draw wheels
        g.setColor(Color.BLACK);
        g.fillOval(carPositionX + 10, yBase - 10, 10, 10);
        g.fillOval(carPositionX + 30, yBase - 10, 10, 10);

        // Draw car body
        g.setColor(Color.GREEN);
        g.fillRect(carPositionX, yBase - 20, 50, 10);

        // Draw car roof
        g.setColor(Color.RED);
        Polygon polygon = new Polygon();
        polygon.addPoint(carPositionX + 10, yBase - 20);
        polygon.addPoint(carPositionX + 20, yBase - 30);
        polygon.addPoint(carPositionX + 30, yBase - 30);
        polygon.addPoint(carPositionX + 40, yBase - 20);
        g.fillPolygon(polygon);
    }
}
