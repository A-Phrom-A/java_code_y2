#include <iostream>
using namespace std;


double C(int n, double x, double X[], int I) {
    double R = 1.0;
    for (int i = 0; i < n; ++i) {
        if (i != I) {
            R = R * (x - X[i]) / (X[I] - X[i]);
        }
    }
    return R;
}

double F(int n, double x, double X[], double Y[]) {
    double y = 0.0;
    for (int i = 0; i < n; ++i) {
        y += Y[i] * C(n, x, X, i);
    }
    return y;
}


void LinearInterpolation(double X) {
    double x[2] = {0, 80000};
    double y[2] = {9.81, 9.5682};
    
    double Y = y[0] + ((y[1] - y[0]) * (X - x[0])) / (x[1] - x[0]);
    
    cout << "X = " << X << " Y = " << Y << endl;
}


double Quadratic(double x) {
    double X[3] = {0, 40000, 80000};
    double Y[3] = {9.81, 9.6879, 9.5682};
    return F(3, x, X, Y);
}


double Polynomial(double x) {
    double X[5] = {0, 20000, 40000, 60000, 80000};
    double Y[5] = {9.81, 9.7487, 9.6879, 9.6879, 9.5682};
    return F(5, x, X, Y);
}

int main() {
    double x = 40021;

    
    cout << "Linear Interpolation at     " ;
	LinearInterpolation(x) ;
	
    // Quadratic interpolation
    cout << "Quadratic Interpolation at  x = " << x << " Y = " << Quadratic(x) << endl;

    // Polynomial interpolation
    cout << "Polynomial Interpolation at x = " << x << " Y = " << Polynomial(x) << endl;

    return 0;
}

