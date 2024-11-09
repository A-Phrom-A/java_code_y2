import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL; // Import the URL class

class SystemSolar extends JPanel {
    URL imageURL = this.getClass().getResource("solar.png");
    Image image = new ImageIcon(imageURL).getImage();

    int mercury = 0;
    int venus = 0;
    int earth = 0;
    int mars = 0;
    double jupiter = 0;
    double saturn = 0;
    double uranus = 0;
    double neptune = 0;
    int moon = 0;

    Timer timer;

    public SystemSolar() {
        timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 1600,900, this);

        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        // Draw Sun
        g.setColor(Color.YELLOW);
        g.fillOval(xCenter - 35, yCenter - 35, 70, 70); // Sun

        // Draw Mercury
        mercury += 4; // Increase speed
        g.setColor(Color.ORANGE);
        g.fillOval((int) (xCenter + 100 * Math.cos(Math.toRadians(mercury)) - 6),
                   (int) (yCenter + 100 * Math.sin(Math.toRadians(mercury)) - 6), 12, 12); // Mercury

        // Draw Venus
        venus += 3; // Increase speed
        g.setColor(Color.CYAN);
        g.fillOval((int) (xCenter + 150 * Math.cos(Math.toRadians(venus)) - 12),
                   (int) (yCenter + 150 * Math.sin(Math.toRadians(venus)) - 12), 24, 24); // Venus

        // Draw Earth
        earth += 2; // Increase speed
        g.setColor(Color.BLUE);
        int xEarth = (int) (xCenter + 230 * Math.cos(Math.toRadians(earth)) - 12);
        int yEarth = (int) (yCenter + 230 * Math.sin(Math.toRadians(earth)) - 12);
        g.fillOval(xEarth, yEarth, 24, 24); // Earth

        // Draw Moon
        moon += 10;
        g.setColor(Color.GRAY);
        g.fillOval((int) (xEarth + 10 + 30 * Math.cos(Math.toRadians(moon)) - 5),
                   (int) (yEarth + 10 + 30 * Math.sin(Math.toRadians(moon)) - 5), 10, 10); // Moon

        // Draw Mars
        mars += 1; // Increase speed
        g.setColor(Color.RED);
        g.fillOval((int) (xCenter + 300 * Math.cos(Math.toRadians(mars)) - 12),
                   (int) (yCenter + 300 * Math.sin(Math.toRadians(mars)) - 12), 24, 24); // Mars

        // Draw Jupiter
        jupiter += 0.5; // Movement speed
        g.setColor(new Color(255, 165, 0)); // Light orange
        g.fillOval((int) (xCenter + 400 * Math.cos(Math.toRadians(jupiter)) - 30),
                   (int) (yCenter + 400 * Math.sin(Math.toRadians(jupiter)) - 30), 60, 60); // Jupiter

        // Draw Saturn
        saturn += 0.3; // Movement speed
        g.setColor(new Color(210, 180, 140)); // Light brown
        g.fillOval((int) (xCenter + 500 * Math.cos(Math.toRadians(saturn)) - 25),
                   (int) (yCenter + 500 * Math.sin(Math.toRadians(saturn)) - 25), 50, 50); // Saturn

        // Draw Uranus
        uranus += 0.2; // Movement speed
        g.setColor(Color.CYAN); // Blue
        g.fillOval((int) (xCenter + 600 * Math.cos(Math.toRadians(uranus)) - 20),
                   (int) (yCenter + 600 * Math.sin(Math.toRadians(uranus)) - 20), 40, 40); // Uranus

        // Draw Neptune
        neptune += 0.1; // Movement speed
        g.setColor(Color.BLUE.darker()); // Dark blue
        g.fillOval((int) (xCenter + 700 * Math.cos(Math.toRadians(neptune)) - 20),
                   (int) (yCenter + 700 * Math.sin(Math.toRadians(neptune)) - 20), 40, 40); // Neptune
    }
}

public class NewClass19 extends JFrame {
    public NewClass19() {
        add(new SystemSolar());
        setSize(800, 600);
        setTitle("The Universe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NewClass19::new);
    }
}
