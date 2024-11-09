import java.lang.Math;
import javax.swing.plaf.synth.Region;
public class W2_8 {
    public static void main(String[] args){
        RegularPolygon polygon1 = new RegularPolygon();
        RegularPolygon polygon2 = new RegularPolygon(6,4);
        RegularPolygon polygon3 = new RegularPolygon(10,4,5.6,7.8);
        System.out.println("Polygon 1: Perimeter = " + polygon1.getPerimeter() + ", Area = " + polygon1.getArea());
        System.out.println("Polygon 2: Perimeter = " + polygon2.getPerimeter() + ", Area = " + polygon2.getArea());
        System.out.println("Polygon 3: Perimeter = " + polygon3.getPerimeter() + ", Area = " + polygon3.getArea());
    }
}
class RegularPolygon{
    private int n;
    private double side;
    private double x;
    private double y;
    RegularPolygon(){
        this.n=3;
        this.side = 1;
        this.x=0;
        this.y=0;
    }
    public RegularPolygon(int n,double side){
        this.n = n;
        this.side = side;
    }
    public RegularPolygon(int n,double side,double x,double y){
        this.n = n;
        this.side = side;
        this.x = x;
        this.y =y;
    }
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }
    public void setSide(double side){
        this.side=side;
    }
    public void setN(int n){
        this.n = n;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getSide(){
        return this.side;
    } 
    public int getN(int n){
        return this.n;
    }
    public double getPerimeter(){
        return n*side;
    }
    public double getArea(){
        return (n*side*side)/(4*Math.tan(Math.PI/n));
    }
}