import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class keyDemo extends JFrame{
    keyDemo(){
        drawArea p = new drawArea();
        add(p);
        p.setFocusable(true);
    }
    static class  drawArea extends JPanel {
        char ch = 'A';
        int x = 30;
        int y = 30;
        @Override
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            g.setFont(new Font("Timeroman",Font.BOLD,20));
            g.drawString(String.valueOf(ch), x, y);
        }
         drawArea(){
            addKeyListener(new KeyListener() {
                @Override
                    public void keyTyped(KeyEvent e) {
                        switch (e.getKeyCode()) {
                            case KeyEvent.VK_UP:y -= 10;
                                break;
                            case KeyEvent.VK_DOWN:y += 10;
                                break;
                            case KeyEvent.VK_LEFT:x -= 10;
                                break;
                            case KeyEvent.VK_RIGHT:x += 10;
                                break;
                            default:ch = e.getKeyChar();
                                break;
                        }
                    repaint();
                        
                    }
                @Override
                    public void keyPressed(KeyEvent e) {
                        switch (e.getKeyCode()) {
                            case KeyEvent.VK_UP:y -= 10;
                                break;
                            case KeyEvent.VK_DOWN:y += 10;
                                break;
                            case KeyEvent.VK_LEFT:x -= 10;
                                break;
                            case KeyEvent.VK_RIGHT:x += 10;
                                break;
                            default:ch = e.getKeyChar();
                                break;
                        }
                    repaint();
                            
                    }
             @Override
             public void keyReleased(KeyEvent e) {
                 // TODO Auto-generated method stub
                 
             }

            });
         }
        
    }
    public static void main(String[] args) {
        keyDemo frame = new keyDemo();
        frame.setTitle("MoveMessageDemo");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
