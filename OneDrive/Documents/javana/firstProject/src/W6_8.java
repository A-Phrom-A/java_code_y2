class Rectangle {
    private double width, height, x, y;

    // No-arg constructor
    public Rectangle() {
        width = height = x = y = 0;
    }

    // Constructor with parameters
    public Rectangle(double width, double height, double x, double y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    // Getters
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public double getX() { return x; }
    public double getY() { return y; }
}

class Line {
    private double x1, y1, x2, y2;

    // No-arg constructor
    public Line() {
        x1 = y1 = x2 = y2 = 0;
    }

    // Constructor with parameters
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // Getters
    public double getX1() { return x1; }
    public double getY1() { return y1; }
    public double getX2() { return x2; }
    public double getY2() { return y2; }
}

public class W6_8 {

    // Check if a line is inside a rectangle
    public static int contains(Line line, Rectangle rect) {
        double left = rect.getX();
        double right = rect.getX() + rect.getWidth();
        double top = rect.getY();
        double bottom = rect.getY() + rect.getHeight();
        
        boolean startInside = (line.getX1() >= left && line.getX1() <= right) && (line.getY1() >= top && line.getY1() <= bottom);
        boolean endInside = (line.getX2() >= left && line.getX2() <= right) && (line.getY2() >= top && line.getY2() <= bottom);
        
        return (startInside && endInside) ? 1 : 0;
    }

    // Check if two lines intersect
    public static int cross(Line line1, Line line2) {
        double x1 = line1.getX1(), y1 = line1.getY1(), x2 = line1.getX2(), y2 = line1.getY2();
        double x3 = line2.getX1(), y3 = line2.getY1(), x4 = line2.getX2(), y4 = line2.getY2();

        double denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
        if (denom == 0) return 0;

        double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / denom;
        double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / denom;

        return (ua >= 0 && ua <= 1 && ub >= 0 && ub <= 1) ? 1 : 0;
    }

    // Check if two rectangles overlap
    public static int overlaps(Rectangle rect1, Rectangle rect2) {
        double left1 = rect1.getX();
        double right1 = rect1.getX() + rect1.getWidth();
        double top1 = rect1.getY();
        double bottom1 = rect1.getY() + rect1.getHeight();
        
        double left2 = rect2.getX();
        double right2 = rect2.getX() + rect2.getWidth();
        double top2 = rect2.getY();
        double bottom2 = rect2.getY() + rect2.getHeight();
        
        boolean overlap = !(right1 < left2 || right2 < left1 || bottom1 < top2 || bottom2 < top1);
        return overlap ? 1 : 0;
    }

    // Calculate the distance between the center of a rectangle and the center of a line
    public static double distance(Line line, Rectangle rect) {
        double centerXRect = rect.getX() + rect.getWidth() / 2;
        double centerYRect = rect.getY() + rect.getHeight() / 2;
        
        double centerXLine = (line.getX1() + line.getX2()) / 2;
        double centerYLine = (line.getY1() + line.getY2()) / 2;
        
        return Math.sqrt(Math.pow(centerXLine - centerXRect, 2) + Math.pow(centerYLine - centerYRect, 2));
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(10, 5, 2, 3);
        Line line1 = new Line(3, 4, 8, 4);
        Line line2 = new Line(5, 2, 15, 7);
        Rectangle rect2 = new Rectangle(6, 4, 4, 2);

        System.out.println("Contains: " + contains(line1, rect1)); // Expected output: 1
        System.out.println("Cross: " + cross(line1, line2)); // Expected output: 1 or 0 depending on intersection
        System.out.println("Overlaps: " + overlaps(rect1, rect2)); // Expected output: 1
        System.out.println("Distance: " + distance(line1, rect1)); // Expected output: distance value
    }
}
