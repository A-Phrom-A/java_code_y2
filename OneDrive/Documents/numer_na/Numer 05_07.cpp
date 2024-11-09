#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;



double Fx2(double x,double n,double y){
	return pow(y,n)-x;	
}

double false_position(double x,double n){
	double x1 = 0.0;
//	double E ;
	double L = 0;
	double R = 1000000;
	
    do {
    	double x2 = x1;
        x1 = ((L*Fx2(x, n, R))-R*Fx2(x, n, L))/(Fx2(x, n, R)-Fx2(x, n, L));
      	
		//E = fabs(x1-x2);
			
			
        if (Fx2(x, n, L) * Fx2(x, n, x1) < 0) {
            R = x1;
        } else {
            L = x1;
        }
        
   }while (fabs(Fx2(x,n,x1)) > 1e-9);
    
    return x1;
}

int main(){

	double X;
	double n;
	
	cout << "input X and n "<<endl;
	cin >> X;
	cin >> n;

	double result = false_position(X,n);
	cout << "y = "<< fixed << setprecision(7) << result <<endl;
return 0;
}
