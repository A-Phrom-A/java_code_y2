import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class W11_7AirDefense extends JFrame {
    public static void main(String[] args) {
        W11_7AirDefense game = new W11_7AirDefense();
        game.setSize(600, 500);
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private BalloonPanel paintPanel = new BalloonPanel();

    public W11_7AirDefense() {
        setLayout(new BorderLayout());
        add(paintPanel);
    }

    class BalloonPanel extends JPanel {
        public int score = 0;

        final static int BALLOON_RADIUS = 10;
        final static int BALL_RADIUS = 5;
        final static int GUN_LENGTH = 25;

        private int xBalloon = (int) (Math.random() * getWidth());
        private int yBalloon = (int) (Math.random() * getHeight());
        private int angle = 90;

        private LinkedList<SmallBall> balls = new LinkedList<>();

        public BalloonPanel() {
            setFocusable(true);
            addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_LEFT && angle < 180) {
                        angle += 3;
                    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && angle > 0) {
                        angle -= 3;
                    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                        // Launch a small ball
                        balls.add(new SmallBall(GUN_LENGTH, angle));
                    }
                    repaint();
                }
            });

            // Start the game loop
            Thread gameThread = new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        updateBalls();
                        repaint();
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            });
            gameThread.start();
        }

        public void updateBalls() {
            for (int i = 0; i < balls.size(); i++) {
                SmallBall ball = balls.get(i);
                ball.length += 5;

                int x = (int) (ball.length * Math.cos(Math.toRadians(ball.angle)) + getWidth() / 2);
                int y = (int) (getHeight() - ball.length * Math.sin(Math.toRadians(ball.angle)));

                // Check for collision with the balloon
                if (overlaps(x, y, BALL_RADIUS, xBalloon, yBalloon, BALLOON_RADIUS)) {
                    balls.remove(i);
                    score += 10;

                    // New random location for the balloon
                    xBalloon = (int) (Math.random() * getWidth());
                    yBalloon = (int) (Math.random() * getHeight());
                    i--; // Adjust index after removal
                } else if (x > getWidth() || x < 0 || y < 0) {
                    balls.remove(i);
                    i--; // Adjust index after removal
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("Score: " + score, 10, 20);

            // Draw the gun
            int gunX = (int) (GUN_LENGTH * Math.cos(Math.toRadians(angle)) + getWidth() / 2);
            int gunY = (int) (getHeight() - GUN_LENGTH * Math.sin(Math.toRadians(angle)));
            g.drawLine(getWidth() / 2, getHeight(), gunX, gunY);

            // Draw the balloon
            g.drawOval(xBalloon - BALLOON_RADIUS, yBalloon - BALLOON_RADIUS, 2 * BALLOON_RADIUS, 2 * BALLOON_RADIUS);

            // Draw small balls
            for (SmallBall ball : balls) {
                int x = (int) (ball.length * Math.cos(Math.toRadians(ball.angle)) + getWidth() / 2);
                int y = (int) (getHeight() - ball.length * Math.sin(Math.toRadians(ball.angle)));
                g.fillOval(x - BALL_RADIUS, y - BALL_RADIUS, 2 * BALL_RADIUS, 2 * BALL_RADIUS);
            }
        }
    }

    public static boolean overlaps(double x1, double y1, double radius1,
                                   double x2, double y2, double radius2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) <= radius1 + radius2;
    }

    class SmallBall {
        int length;
        int angle;

        SmallBall(int length, int angle) {
            this.length = length;
            this.angle = angle;
        }
    }
}
