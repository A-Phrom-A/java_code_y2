import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.PopupMenu;
import javax.swing.JFrame;
import javax.swing.JPanel;
abstract class AbstractDrawFunction extends JPanel{
/**Polygon to hold the points*/
private Polygon p = new Polygon();
/**Default constructor*/
protected AbstractDrawFunction (){
    drawFunction();
        setBackground(Color.white);
}
/**Draw the function*/
    public abstract double f(double x);
        /**Obtain points for x coordinates 100, 101, ..., 300*/
        public void drawFunction(){
            for (int x = -100; x <= 100; x++){
                p.addPoint(x+200, 200-(int)f(x));
            }
        }
/**Paint the function diagram*/
    public void paintComponent(Graphics g)
        {       
                super.paintComponent(g);
                // Draw x axis
                g.setColor(Color.red);
                g.drawLine(10, 200, 390, 200);
                // Draw y axis
                g.drawLine(200,30, 200, 390);
                // Draw arrows on x axis
                g.drawLine(390, 200, 370, 190);
                g.drawLine(390, 200, 370, 210);
                // Draw arrows on y axis
                g.drawLine(200, 30, 190, 50);
                g.drawLine(200, 30, 210, 50);
                // Draw x, y
                g.drawString("X", 370, 170);
                g.drawString("Y", 220, 40);
                // Draw a polygon line by connecting the points in the polygon
                g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
        }
    }

public class W8_3 extends JFrame{

        public W8_3(){
            getContentPane().setLayout(new GridLayout(2, 4, 5, 5));
            getContentPane().add(new DrawSq());
             getContentPane().add(new Drawsin());
             getContentPane().add(new Drawcos());
             getContentPane().add(new Drawtan());
             getContentPane().add(new Drawcos5sin());
             getContentPane().add(new Draw5cossin());
             getContentPane().add(new Drawlog());
        }
        public static void main(String[] args){
            W8_3 frame = new W8_3();
            frame.setSize(1920, 1080);
            frame.setTitle("Exercise 10.10");
            frame.setVisible(true);
        }

   
}

class DrawSq extends AbstractDrawFunction{
    
    @Override 
    public double f(double x){
        return Math.pow(x, 2);
    }
}
class Drawsin extends AbstractDrawFunction{
    
    @Override 
    public double f(double x){
        return 100*Math.sin(Math.toRadians(x));
    }
}
class Drawcos extends AbstractDrawFunction{
    
    @Override 
    public double f(double x){
        return 100*Math.cos(Math.toRadians(x));
    }
}
class Drawtan extends AbstractDrawFunction{
    
    @Override 
    public double f(double x){
        return Math.tan(Math.toRadians(x));
    }
}

class Drawcos5sin extends AbstractDrawFunction{
    
    @Override 
    public double f(double x){
    return (Math.cos(Math.toRadians(x))+5*Math.sin(Math.toRadians(x)));
    }
}
class Draw5cossin extends AbstractDrawFunction{
    
    @Override 
    public double f(double x){
        return 100*(5*Math.cos(Math.toRadians(x))+Math.sin(Math.toRadians(x)));
    }
}
class Drawlog extends AbstractDrawFunction{
    
    @Override 
    public double f(double x){
        return (Math.log(x)+Math.pow(x, 2));
    }
}
