import java.util.Scanner;
import java.util.ArrayList;
public class W9_9 {
    public static void main(String[] args){
        ArrayList<Integer> T = new ArrayList<>();
        int n ;
        Scanner sc = new Scanner(System.in);
        int  size = sc.nextInt();
         int arr[] = new int[size];
         
         for(int i=0;i<size;i++){
             n=sc.nextInt();
             T.add(n);
         }
         int max=0;
         int temp = 0;
         int sum=0;
        while(T.size()>1){
                    for(int i=0;i<T.size()-1;i++){
                     if( Math.abs(T.get(i)-T.get(i+1))>max){
                         max= Math.abs(T.get(i)-T.get(i+1));
                         temp=i;
                     }
                     if(Math.abs(T.get(i)-T.get(i+1))==max){
                         if(T.get(temp)>T.get(i)){
                             temp =i;
                         }
                     }
                 }
                    sum+=max;
                T.remove(temp);
                T.remove(temp);
                max=0;
        }
         
            for(int i=0;i<T.size();i++){
                System.out.print(T.get(i)+" ");
            }

            System.out.println("\n"+sum);
    }
}