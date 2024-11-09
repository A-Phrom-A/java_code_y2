import java.awt.*;
import javax.swing.*;

public class W11_5Exercise extends JFrame {
    public W11_5Exercise() {
        add(new RaceCar()); // Add the race car panel to the frame
    }

    public static void main(String[] args) {
        W10_3Exercise frame = new W10_3Exercise();
        frame.setTitle("Race Car Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200); // Increased size for better visibility
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}

class RaceCar extends JPanel {
    private int carPositionX = 0; // Initial horizontal position of the car

    public RaceCar() {
        // Start the game thread to update the car's position
        Thread gameThread = new Thread(() -> {
            while (true) {
                // Update car position
                if (carPositionX > getWidth()) {
                    carPositionX = -50; // Reset car position to the left of the screen
                } else {
                    carPositionX += 1; // Move car to the right
                }
                repaint(); // Request a repaint to update the display
                try {
                    Thread.sleep(20); // Control the speed of the car
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupted status
                }
            }
        });
        gameThread.start(); // Start the game thread
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass method

        int yBase = getHeight(); // Get the base y-coordinate for drawing

        // Draw wheels
        g.setColor(Color.BLACK);
        g.fillOval(carPositionX + 10, yBase - 10, 10, 10); // Left wheel
        g.fillOval(carPositionX + 30, yBase - 10, 10, 10); // Right wheel

        // Draw car body
        g.setColor(Color.GREEN);
        g.fillRect(carPositionX, yBase - 20, 50, 10); // Car body

        // Draw car roof
        g.setColor(Color.RED);
        Polygon polygon = new Polygon(); // Create a polygon for the roof
        polygon.addPoint(carPositionX + 10, yBase - 20); // Left corner of the roof
        polygon.addPoint(carPositionX + 20, yBase - 30); // Top left corner
        polygon.addPoint(carPositionX + 30, yBase - 30); // Top right corner
        polygon.addPoint(carPositionX + 40, yBase - 20); // Right corner of the roof
        g.fillPolygon(polygon); // Draw the roof
    }
}
