
#include <iostream>
#include <cmath>  
using namespace std;

double Taylor_Series(double x1 ,double x,double n) {
    double all = 0.0;
    double sum ;
    double xn = x1 -x;
    
	for(int j =0 ;j <= n;j++){
	
	
	if(j == 0){
    	sum = log(x);
	}else if(j == 1){
		sum = xn/x;
	}else if(j == 2) {
	    sum = -pow(xn, 2) / (2 * pow(x, 2));
	}else if( j == 3){
		sum = pow(xn, 3) / (6 * pow(x, 3));
	}
    
    all += sum;
     
}
   return all; 
}

int main() {
    double x0 = 2.0;  
    double X = 4.0;       
    double X2 = log(X);
    
	for (int i = 0; i < 4; i++) {
        double x1 = Taylor_Series(X,x0,i);  
        
         double E = fabs((x1 - X2) / X2) * 100;
       
 
        cout << " N = " << i ;
        cout << " error = " << E << endl;
        
         if (E < 1e-9) {
            break;
        }
    }

    

    return 0;
}

