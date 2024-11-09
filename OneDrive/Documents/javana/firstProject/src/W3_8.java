import java.util.Scanner;

public class W3_8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double X = sc.nextDouble();
        Estimate e = new Estimate(X);
        e.F();
    }

    
}

class Estimate{
    public double x;
    
    public Estimate(double x){
        this.x = x;
    }

    public void F(){
        double R = 0.0;
        double D = 0.0;
        for(int i = 0;i < x; i++){
        R = Math.pow(-1, i+1)/(2*i - 1);
        D += R;
        }
        System.out.println(4*D);
    }
}