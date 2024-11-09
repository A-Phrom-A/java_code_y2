interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}
class MovablePoint implements Movable {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        y += ySpeed;
    }

    @Override
    public void moveDown() {
        y -= ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint: (" + x + ", " + y + ")";
    }
}
class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public String toString() {
        return "MovableCircle: center=" + center + ", radius=" + radius;
    }
}

public class W8_6 {
    public static void main(String[] args) {
        // ทดสอบ MovablePoint
        MovablePoint point = new MovablePoint(0, 0, 5, 5);
        System.out.println(point);
        point.moveUp();
        System.out.println("After moving up: " + point);
        point.moveRight();
        System.out.println("After moving right: " + point);
        // ทดสอบ MovableCircle
        MovableCircle circle = new MovableCircle(0, 0, 3, 3, 10);
        System.out.println(circle);
        circle.moveUp();
        System.out.println("After moving up: " + circle);
        circle.moveRight();
        System.out.println("After moving right: " + circle);
    }
}
