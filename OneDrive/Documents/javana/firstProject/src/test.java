
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class test extends JFrame{
    private JButton jbt1 = new JButton("+");
    private JButton jbt2 = new JButton("-");
    private C c = new C();
    private int R = 20;

    public test(){
      jbt1.setPreferredSize(new Dimension(160 , 40));
      jbt2.setPreferredSize(new Dimension(160 , 40));
      
      JPanel p1 = new JPanel();
      p1.setLayout(new BorderLayout());

      JPanel p2 = new JPanel();
      p2.setLayout(new FlowLayout());

      p2.add(jbt1);
      p2.add(jbt2);

      p1.add(p2 , BorderLayout.SOUTH);
      p1.add(c , BorderLayout.CENTER);
      
      jbt1.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            R += 5;
            c.repaint();
            
        }
      });

      jbt2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            R -= 5;
            c.repaint();
        }
      });
      
      add(p1);
    }

    class C extends JPanel{

      @Override
      protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillArc(50, 55, 100, 100, 90, 180);
        
      }

    }

    public static void main(String[] args) {
      test f = new test();
      f.setTitle("test");
      f.setSize(400,250);
      f.setLocationRelativeTo(null);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
  }
}

