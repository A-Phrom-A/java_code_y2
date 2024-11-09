import java.util.Scanner;
public class W2_7 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
         System.out.print("Enter r1's center x-, y-coordinates, width, and height: ");
        double x = input.nextDouble();
        double y = input.nextDouble();
        double w = input.nextDouble();
        double h = input.nextDouble();
       System.out.print("Enter r2's center x-, y-coordinates, width, and height: ");
        rectangle r1 = new rectangle(x,y,w,h);
        x = input.nextDouble();
        y = input.nextDouble();
        w = input.nextDouble();
        h= input.nextDouble();
        rectangle r2 = new rectangle(x,y,w,h);
        if(r1.check(r2)){
        System.out.println("r2 is inside r1");
        }else{
            System.out.println("r2 is not inside r1");
        }
    }
}
class rectangle{
    private double x,y,w,h;
    rectangle(double x,double y,double w,double h){
        this.x = x;
        this.y = y;
        this.w= w;
        this.h = h;
    }
    boolean check(rectangle r2){
        double r1_left = (this.x-this.w)/2.0;
        double r1_right = (this.x+this.w)/2.0;
        double r1_top = (this.y+this.h)/2.0;
        double r1_bottom = (this.y-this.h)/2.0;
        double r2_left = (r2.x-r2.w)/2.0;
        double r2_right = (r2.x+r2.w)/2.0;
        double r2_top = (r2.y+r2.h)/2.0;
        double r2_bottom = (r2.y-r2.h)/2.0;
        return r2_left>=r1_left&& r2_right <= r1_right && r2_top <= r1_top && r2_bottom >= r1_bottom ;
    }
}