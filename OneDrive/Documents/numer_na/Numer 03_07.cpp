#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;



double Fx2(double x,double n,double y){
	return pow(y,n)-x;	
}

double bisection(double x,double n){
	double M = 0.0;
	double E ;
	double L = 0;
	double R= 1000000;
	
    do {
    	double m = M;
        M = (L + R) / 2;
      	
		E = fabs((M-m)/M);
			
			
        if (Fx2(x, n, L) * Fx2(x, n, M) < 0) {
            R = M;
        } else {
            L = M;
        }
        
   }while (E >1e-9);
    
    return M;
}

int main(){

	double X,n;
	
	cout << "input X and n "<<endl;
	cin >> X;
	cin >> n;

	double result = bisection(X,n);
	cout << "y = "<< fixed << setprecision(6) << result <<endl;
return 0;
}
