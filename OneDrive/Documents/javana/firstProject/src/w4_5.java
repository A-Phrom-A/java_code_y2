import java.util.Scanner;

public class w4_5 {

    public static void main(String[] args){
                Scanner input = new Scanner(System.in);
                int n = input.nextInt();
                int l = input.nextInt();

               int[][] A = new int[n][l];      
               for(int i=0;i<n;i++){
                   for(int j=0;j<l;j++){
                       A[i][j] = input.nextInt();
                   }
               }
               int m = input.nextInt();
               int k = input.nextInt();
               int[][] B= new int[m][k];
               for(int i=0;i<m;i++){
                   for(int j=0;j<k;j++){
                       B[i][j] = input.nextInt();
                   }
               }     
               
        MatrixMultiplication metrixcal = new MatrixMultiplication(A,B);
        int[][] c = metrixcal.getresult();
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[0].length;j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }
}
class MatrixMultiplication{
    int[][] c;
        MatrixMultiplication(int[][] A,int[][] B){
         int n = A.length;
         int m = B[0].length;
          int L = A[0].length;
       c = new int[n][m];
       int temp=0;
       for(int i=0;i<n;i++){
           for(int j=0 ; j < m; j++){
                   temp=0;
                   for(int p=0;p<L;p++){
                       temp  += A[i][p]*B[p][j];               
                        } 
               c[i][j] = temp;        
           }
       }
   }
           public int[][] getresult(){
           return c;
       }
}