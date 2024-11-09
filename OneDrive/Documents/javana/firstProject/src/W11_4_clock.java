import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class W11_4_clock extends JFrame {
    private StillClock clock1 = new StillClock("Local Time");
    private StillClock clock2 = new StillClock("Korean Time", 14); // KST is UTC+9
    private Thread clockThread; // Thread for updating the clocks

    public W11_4_clock() {
        setLayout(new GridLayout(1, 2));
        add(clock1);
        add(clock2);

        // Start the clock update thread
        clockThread = new Thread(new ClockUpdater());
        clockThread.start();
    }

    private class ClockUpdater implements Runnable {
        @Override
        public void run() {
            while (true) {
                // Update the time for both clocks
                clock1.setCurrentTime();
                clock2.setCurrentTime();
                clock1.repaint();
                clock2.repaint();

                // Sleep for 1000 ms
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupted status
                    break; // Exit the loop if interrupted
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        JFrame frame = new W10_2_clock();
        frame.setTitle("Clock Animation");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class StillClock extends JPanel {
    private int hour;
    private int minute;
    private int second;
    private String title;
    private int timeZoneOffset; // Offset in hours for time zone

    /** Construct a clock with the specified title */
    public StillClock(String title) {
        this.title = title;
        this.timeZoneOffset = 0; // Default to local time
        setCurrentTime();
    }

    /** Construct a clock with specified title and time zone offset */
    public StillClock(String title, int timeZoneOffset) {
        this.title = title;
        this.timeZoneOffset = timeZoneOffset; // Set the offset
        setCurrentTime();
    }

    /** Set the current time */
    public void setCurrentTime() {
        // Construct a calendar for the current date and time
        Calendar calendar = new GregorianCalendar();
        
        // Set current hour, minute, and second
        this.hour = (calendar.get(Calendar.HOUR_OF_DAY) + timeZoneOffset) % 24;
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }

    @Override // Draw the clock
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(title, 10, 20); // Draw the title

        // Initialize clock parameters
        int clockRadius = (int)(Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        // Draw circle
        g.setColor(Color.black);
        g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
        g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
        g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
        g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
        g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

        // Draw second hand
        int sLength = (int)(clockRadius * 0.8);
        int xSecond = (int)(xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
        int ySecond = (int)(yCenter - sLength * Math.cos(second * (2 * Math.PI / 60)));
        g.setColor(Color.red);
        g.drawLine(xCenter, yCenter, xSecond, ySecond);

        // Draw minute hand
        int mLength = (int)(clockRadius * 0.65);
        int xMinute = (int)(xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60)));
        int yMinute = (int)(yCenter - mLength * Math.cos(minute * (2 * Math.PI / 60)));
        g.setColor(Color.blue);
        g.drawLine(xCenter, yCenter, xMinute, yMinute);

        // Draw hour hand
        int hLength = (int)(clockRadius * 0.5);
        int xHour = (int)(xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int)(yCenter - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        g.setColor(Color.green);
        g.drawLine(xCenter, yCenter, xHour, yHour);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}