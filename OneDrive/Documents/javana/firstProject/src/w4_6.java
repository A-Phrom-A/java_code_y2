import java.util.Scanner;

public class w4_6 {
    public static double mindistance(double[] x,double[] y,int n){
                    double minDistance = Double.MAX_VALUE;
                     for (int i = 0; i < n; i++) {
                         for (int j = i + 1; j < n; j++) {
                             double distance = Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
                             if (distance < minDistance) {
                                 minDistance = distance;
                             }
                         }
                     } 
                     return minDistance;
    }
    public static void main(String[] args) {
                    Scanner input = new Scanner(System.in);
                    int n = input.nextInt();

                    double[] x = new double[n];
                    double[] y = new double[n];
                    for (int i = 0; i < n; i++) {
                        x[i] = input.nextDouble();
                        y[i] = input.nextDouble();
                    }
                   double minDistance;
                    minDistance = mindistance(x,y,n);

                    // แสดงระยะห่างน้อยที่สุด
                    System.out.printf("%.2f\n", minDistance);


    }
}
