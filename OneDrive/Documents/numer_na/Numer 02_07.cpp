#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;


double Fx(double x){
  return pow(x,4)-13;
}

double bisection(double X,double Y){
	double M = 0.0;
	double E ;
	
    do {
    	double m = M;
        M = (X + Y) / 2;
      	
		E = fabs((M-m)/M);
			
			
        if (Fx(X) * Fx(M) < 0) {
            Y = M;
        } else {
            X = M;
        }
        
    }while (E > 1e-9);
    
    return M;
}

int main(){
	double L=1.5;
	double R=2.0;
	double result = bisection(L,R);
	cout << "x = "<< fixed << setprecision(6) << result <<endl;
return 0;
}
