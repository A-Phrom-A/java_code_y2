import java.util.Scanner;
public class w4_4 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[] A = new double[n];
        double[] B;
        double[] C;
        for(int i=0;i<n;i++){
            A[i] = input.nextDouble();
        }
        
        AscendSortFreq ascend = new AscendSortFreq(A,n);
        B = ascend.AscendSort(A);
        
        for(int i=0;i<B.length;i++){
            System.out.print(B[i]+ " ");
        }System.out.println(" ");
        C= ascend.SortCommuFreq(B);
        for(int i=0;i<C.length;i++){
            System.out.print(C[i]+ " ");
        }System.out.println(" ");
        
    }
}
class AscendSortFreq{
    int n;
    double[] A;
    AscendSortFreq(double[] A,int n){
            this.n = n;
             this.A = new double[n];
            for(int i=0;i<n;i++){
                this.A[i] = A[i];
            }
    }
    double[] AscendSort(double[] A){
        double temp;
        
        for(int i =1;i<A.length;i++){
                 for(int j=i;j>0;j--){
                if(A[j]<A[j-1]){
                    temp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = temp;
                }
                 }           
             }
        int tempar=0;
        double[] artemp = new double[n];
                for (int i = 0; i < n; i++) {
                      if (i == 0 || A[i] != A[i - 1]) {
                          artemp[tempar++] = A[i];
                      }
                  }
        
        double[] B = new double[ tempar ];
        System.arraycopy(artemp, 0, B, 0,tempar);
            return B;
        }
    double[] SortCommuFreq(double[ ] B){
        double[] C = new double[B.length];
         for(int i=0;i<B.length;i++){
             int temp = 0;
             for(int j=0;j<n;j++){
                 if(B[i]==A[j]){
                     temp++;
                 }
                 C[i] = temp;
                 
             }
         }
        return C;
    }
    
}



