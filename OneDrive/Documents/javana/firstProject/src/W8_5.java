import java.lang.Math;
abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    protected GeometricObject() {
    }
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}
class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
   }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Circle other = (Circle) obj;
        return Double.compare(this.radius, other.radius) == 0;
    }
    @Override
    public int hashCode() {
        return Double.hashCode(radius);
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    @Override
    public int compareTo(Circle o) {
        return Double.compare(this.radius, o.radius);
    }
}
class Rectangle extends GeometricObject implements Comparable<Rectangle> {
    private double width;
    private double length;
    private double area;
 @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rectangle other = (Rectangle) obj;
        return Double.compare(this.area, other.area) == 0;
    }
        @Override
        public int hashCode() {
            return Double.hashCode(area);
        }
     public Rectangle(double width,double length) {
        this.width= width;
         this.length= length;
        this.area = this.width*this.length;
    }
    public Rectangle(double width,double length, String color, boolean filled) {
        super(color, filled);
        this.width= width;
         this.length= length;
        this.area = this.width*this.length;
    }
    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public double getPerimeter() {
        return (this.width+this.length)*2;
    }

    @Override
    public int compareTo(Rectangle o) {
        return Double.compare(this.area, o.area);    
    }   
}

class Octagon extends GeometricObject implements  Comparable<Octagon>,Cloneable{
    private double area;
    private double side;
public Octagon(double side) {
        this.side= side;
        this.area = this.side*this.side*(2.0+4.0/Math.sqrt(2.0));
    }
    public Octagon(double side, String color, boolean filled) {
        super(color, filled);
        this.side= side;
        this.area = this.side*this.side*(2.0+4.0/Math.sqrt(2.0));
    }
    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public double getPerimeter() {
        return 8*side;
    }

    @Override
    public int compareTo(Octagon o) {
        return Double.compare(this.area, o.area);
    }
     @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Octagon other = (Octagon) obj;
        return Double.compare(this.area, other.area) == 0;
    }
        @Override
        public int hashCode() {
            return Double.hashCode(area);
        }
            @Override
           protected Object clone() throws CloneNotSupportedException {
               return super.clone();
           }

    
}
class ComparableCircle extends Circle implements Comparable<Circle> {
    public ComparableCircle(double radius) {
        super(radius);
    }
    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }
    @Override
    public int compareTo(Circle o) {
        // Compare circles by their area
        return Double.compare(this.getArea(), o.getArea());
    }
}

public class W8_5 {
    public static void main(String[] args) {
        Circle c1 = new Circle(5.0, "red", true);
        Circle c2 = new Circle(5.0, "blue", false);
        Circle c3 = new Circle(7.0, "green", true);
    
        System.out.println("c1.equals(c2): " + c1.equals(c2)); 
        System.out.println("c1.equals(c3): " + c1.equals(c3)); 
        System.out.println("c1.compareTo(c2): " + c1.compareTo(c2)); 
        System.out.println("c1.compareTo(c3): " + c1.compareTo(c3)); 
        Rectangle r1 = new Rectangle(5.0,6, "red", true);
        Rectangle r2 = new Rectangle(5.0,6, "blue", false);
        Rectangle r3 = new Rectangle(7.0,9, "green", true);
    
        System.out.println("r1.equals(r2): " + r1.equals(r2)); 
        System.out.println("r1.equals(r3): " + r1.equals(r3)); 
        System.out.println("r1.compareTo(r2): " + r1.compareTo(r2)); 
        System.out.println("r1.compareTo(r3): " + r1.compareTo(r3)); 
        
        Octagon o1 = new Octagon(5.0, "red", true);
        Octagon o2 = new Octagon(5.0, "blue", false);
        Octagon o3 = new Octagon(5.0, "green", true);
        try{
            Octagon o4 = (Octagon) o3.clone();
             System.out.println("o3 : " + o3); 
            System.out.println("cloneo3 : " + o4); 
            System.out.println("o3.compareTo(o4): " + o3.compareTo(o4)); 
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("o1.equals(o2): " + o1.equals(o2)); 
        System.out.println("o1.equals(o3): " + o1.equals(o3)); 
        System.out.println("o1.compareTo(o2): " + o1.compareTo(o2)); 
        System.out.println("o1.compareTo(o3): " + o1.compareTo(o3)); 
         
        
         ComparableCircle circle1 = new ComparableCircle(5.0, "red", true);
        ComparableCircle circle2 = new ComparableCircle(7.0, "blue", false);
        // Print the circles' details
        System.out.println("Circle 1: radius = " + circle1.getRadius() + ", area = " + circle1.getArea());
        System.out.println("Circle 2: radius = " + circle2.getRadius() + ", area = " + circle2.getArea());
        // Find the larger circle
        ComparableCircle largerCircle = (circle1.compareTo(circle2) > 0) ? circle1 : circle2;
        System.out.println("The larger circle has a radius of " + largerCircle.getRadius() + " and an area of " + largerCircle.getArea());
    }
}