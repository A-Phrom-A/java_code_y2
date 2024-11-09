import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
public class Red_green_light extends JFrame {
    public static void main(String args[]){
      Red_green_light a = new Red_green_light();
      a.setSize(600,500);
      a.setVisible(true);
   }

   Red_green_light(){
      add(new A());
   }
    class A extends JPanel{
         Button btStart,btStop;
         int color=0;
         int n=1000,d=1;
         int xBase=0;
         Timer timer=new Timer(n,new TimerListener());
         public A() {
	         setBackground(Color.white);
	         setLayout(null);
	         btStop =new Button("STOP");
	         btStart=new Button("START");
	         btStop.setBackground(Color.red);
	         btStart.setBackground(Color.green);
	         btStop.setBounds(10,10,50,50);
	         btStart.setBounds(10,60,50,50);
	         add(btStop);
            add(btStart);
		
            btStop.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                  color = 3;
                  n = 0;
                  timer.stop();
                  repaint();
               }
            });
            btStart.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                  color = 1;
                  n = 0;
                  d=2;
                  timer.start();
                  repaint();
                 }
              });
		
	         timer.start();
		
           }
         private class TimerListener implements ActionListener{
	         public void actionPerformed(ActionEvent e) {
               System.out.println(n);
               if(n==1000) {
		            color=1;
               }else if(n==4000) {
		            color=2;
               }else if(n==7000) {
		            color=3;               
               }else if(n==10000) {
		            n=0;
               }
                  n+=1000;
               //count time
               if(n>=7000) d--;
               else if(n==0)d=0;
               else d=4;
               repaint();
	         }
         }
	
         public void paintComponent(Graphics g){
            super.paintComponent(g);
            int yBase = getHeight();
            g.setColor(Color.black);
            g.drawRect(100,10,50,50);
            g.drawRect(150,10,50,50);
            g.drawRect(200,10,50,50);
            g.drawRect(250,10,50,50);
            if (xBase > getWidth())
               xBase = -20;
            else
	         {	
       	      if(color==1) {
                  g.drawString(""+(n/1000-1), 270, 40);
	   	         g.setColor(Color.green);
	   	         g.fillOval(100,10,50,50); 
                  xBase += 30;
               }else if(color==2) {
                  g.drawString(""+(n/1000-1), 270, 40);
   		         g.setColor(Color.yellow);
   		         g.fillOval(150,10,50,50);   
                  xBase += 10;
                }else if(color==3) {
                  g.drawString(""+(d), 270, 40);
   		         g.setColor(Color.red);
   		         g.fillOval(200,10,50,50);
                  xBase += 0;
               }
            }
	         g.setColor(Color.BLACK);
	         g.fillOval(xBase + 10, yBase - 10, 10, 10);
	         g.fillOval(xBase + 30, yBase - 10, 10, 10);
	         g.setColor(Color.GREEN);
	         g.fillRect(xBase, yBase - 20, 50, 10);
	         g.setColor(Color.RED);
          }

    
    }   
   
	
}