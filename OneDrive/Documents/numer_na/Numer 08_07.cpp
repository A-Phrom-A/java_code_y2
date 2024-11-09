#include <iostream>
#include <cmath>  
using namespace std;

double F(double x) {
    return x * x - 7;
}

double F2(double x) {
    return 2 * x;
}

int main() {
    double x0 = 2.0;  
    double X, E;

    do { 
        X = x0 - F(x0) / F2(x0); 
        E = fabs((X - x0) / X) * 100; 
        x0 = X;
    } while (E > 1e-9);

    cout << "X = " << X << endl;

    return 0;
}

