import java.awt.*;
import javax.swing.*;

public class W11_Stickman extends JFrame {
    public W11_Stickman() {
        add(new StickFigure());
    }

    public static void main(String[] args) {
        W11_Stickman frame = new W11_Stickman();
        frame.setTitle("Stick Figure Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}

class StickFigure extends JPanel {
    private int figurePositionX = 0;
    private int legMovement = 0; // Movement counter for legs
    private boolean legForward = true; // Direction of leg movement

    public StickFigure() {
        // Start the game thread
        Thread gameThread = new Thread(() -> {
            while (true) {
                // Update figure position
                if (figurePositionX > getWidth()) {
                    figurePositionX = -50; // Reset to the left of the screen
                } else {
                    figurePositionX += 1; // Move figure to the right
                }

                // Update leg movement
                if (legForward) {
                    legMovement += 2;
                    if (legMovement >= 20) { 
                        legForward = false;
                    }
                } else {
                    legMovement -= 2;
                    if (legMovement <= 0) { 
                        legForward = true;
                    }
                }

                repaint(); 
                try {
                    Thread.sleep(20); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); 
                }
            }
        });
        gameThread.start(); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yBase = getHeight();

        // Draw head
        g.drawOval(figurePositionX + 15, yBase - 50, 20, 20);

        // Draw body
        g.drawLine(figurePositionX + 25, yBase - 10, figurePositionX + 25, yBase - 30);

        // Draw arms
        g.drawLine(figurePositionX + 25, yBase - 20, figurePositionX + 45, yBase - 20); // Right arm

        // Draw legs with movement
        g.drawLine(figurePositionX + 25, yBase - 10, figurePositionX + 25 - legMovement, yBase); // Left leg
        g.drawLine(figurePositionX + 25, yBase - 10, figurePositionX + 25 + legMovement, yBase); // Right leg

        // Draw umbrella
        g.setColor(Color.BLUE);
        g.fillArc(figurePositionX + 15, yBase - 70, 60, 40, 0, 180); // Draw umbrella
        g.setColor(Color.BLACK);
        g.drawLine(figurePositionX + 45, yBase - 20, figurePositionX + 45, yBase - 50); // Umbrella handle
    }
}
