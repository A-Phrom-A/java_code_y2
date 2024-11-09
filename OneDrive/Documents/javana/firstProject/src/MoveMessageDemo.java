import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoveMessageDemo extends JFrame {
    public MoveMessageDemo() {
        drawArea p = new drawArea();
        add(p);
    }
    //inner class//
    static class drawArea extends JPanel {
        String s = "moodeng";
        int x = 20;
        int y = 20;
        drawArea(){
               addMouseMotionListener(new MouseMotionListener() {
                
                @Override
                public void mouseDragged(MouseEvent e) {
                    x = e.getX();
                    y = e.getY();
                    repaint();
                    
                }
                @Override
                public void mouseMoved(MouseEvent e) {
                    x = e.getX();
                    y = e.getY();
                    repaint();
                    
                }

               });
        }
        @Override
        public void paintComponent(Graphics g) {
           
            super.paintComponent(g);
            g.drawString(s, x, y);
        }
        
    }

    public static void main(String[] args) {
        MoveMessageDemo frame = new MoveMessageDemo();
        frame.setTitle("MoveMessageDemo");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

   
    }

