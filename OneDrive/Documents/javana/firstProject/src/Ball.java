
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ball extends JPanel {
  private int delay = 10;

  // Create a timer with delay 1000 ms
  private Timer timer = new Timer(delay, new TimerListener());

  private int x = 0; private int y = 0; // Current ball position
  private int radius = 5; // Ball radius
  private int dx = 2; // Increment on ball's x-coordinate
  private int dy = 2; // Increment on ball's y-coordinate

  public Ball() {
    timer.start();
  }

  private class TimerListener implements ActionListener {
    @Override /** Handle the action event */
    public void actionPerformed(ActionEvent e) {
      repaint();
    }
  }
@Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(Color.red);

   // Check boundaries
    if (x < 0 || x > getWidth()) 
      dx *= -1;
    if (y < 0 || y > getHeight()) 
      dy *= -1;

    // Adjust ball position
    x += dx;
    y += dy;
    g.fillOval(x - radius, y - radius,radius * 2, radius * 2);
  }

  public void suspend() {
    timer.stop(); // Suspend timer
  }

  public void resume() {
    timer.start(); // Resume timer
  }

  public void setDelay(int delay) {
    this.delay = delay;
    timer.setDelay(delay);
  }
}




