import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Circlecontrol extends JFrame implements ActionListener {
    JButton jbtEnlarge = new JButton("Enlarge");
    JButton jbtShrink = new JButton("Shrink");
    drawArea p = new drawArea();
    
    
    Circlecontrol(){
        jbtShrink.addActionListener(this);
        jbtEnlarge.addActionListener(this);
        JPanel pcricle = new JPanel();
        pcricle.add(jbtEnlarge);
        pcricle.add(jbtShrink);
        add(p,BorderLayout.CENTER);
        add(pcricle,BorderLayout.SOUTH);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jbtEnlarge){
            p.inc();
        }else if(e.getSource()==jbtShrink){
            p.dec();
        }
        
    }
    //inner class//
    static class drawArea extends JPanel {
         int radius = 5;
         public void inc(){
            radius++;
            repaint();
         }
         public void dec(){
            radius--;
            repaint();
         }
         @Override
         protected void paintComponent(Graphics g) {
             
             super.paintComponent(g);
             g.drawOval(getWidth()/2-radius, getHeight()/2-radius, radius*2, radius*2);

         }

        
    }
    public static void main(String[] args) {
        Circlecontrol frame = new Circlecontrol();

        
        frame.setTitle("MoveMessageDemo");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
