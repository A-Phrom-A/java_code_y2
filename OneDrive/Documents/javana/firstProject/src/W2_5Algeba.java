import java.util.Scanner;
public class W2_5Algeba {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a b c d e f: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();
        LinearEquation check = new LinearEquation(a, b, c, d, e, f);
        if(check.isSolvable()){
           System.out.println("X is "+check.getX() +" Y is "+check.getY());
        }else{
            System.out.println("The equation has no solution");
        }
    }
}
class LinearEquation{
    private double a,b,c,d,e,f;
    public LinearEquation(double a,double b,double c,double d,double e,double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    boolean isSolvable(){
        if(this.a*this.d-this.b*this.c == 0){
            return false;
        }else{
            return true;
        }
    }
    double getX(){
        return (this.e*this.d-this.b*this.f)/(this.a*this.d-this.b*this.c);
    }
    double getY(){
        return (this.a*this.f-this.e*this.c)/(this.a*this.d-this.b*this.c);
    }
}