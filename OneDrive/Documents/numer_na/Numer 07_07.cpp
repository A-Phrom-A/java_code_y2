
#include <iostream>
#include <cmath>  
using namespace std;

double F(double x) {
     return x*x-7;
}

int main() {
    double x0 = 2.0;  
    double x1 = 2.9;
    double X,E ;
    
      
    
    
do { 
       X = x1 - F(x1) * ((x1 - x0) / (F(x1) - F(x0)));
        E = fabs((X - x1) / X) * 100; 
        x0 = x1;
        x1 = X;
       
        
} while(E > 1e-9);
   cout << "X = " << X <<  endl;
    

    return 0;
}

