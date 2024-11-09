#include <iostream>
#include <cmath>
#include <vector>

using namespace std;


void display(const vector<double>& x) {
    for (int i = 0; i < x.size(); i++) {
        cout << x[i] << " ";
    }
    cout << endl;
}


double calculateError(const vector<double>& x_new, const vector<double>& x_old) {
    double error = 0.0;
    for (int i = 0; i < x_new.size(); i++) {
        error = max(error, fabs(x_new[i] - x_old[i]));
    }
    return error;
}

int main() {
   
    vector<vector<double> > A(4, vector<double>(4)); 
    A[0][0] = 5; A[0][1] = 2; A[0][2] = 0; A[0][3] = 0;
    A[1][0] = 2; A[1][1] = 5; A[1][2] = 2; A[1][3] = 0;
    A[2][0] = 0; A[2][1] = 2; A[2][2] = 5; A[2][3] = 2;
    A[3][0] = 0; A[3][1] = 0; A[3][2] = 2; A[3][3] = 5;

    vector<double> B(4); 
    B[0] = 12; B[1] = 17; B[2] = 14; B[3] = 7;

    
    vector<double> x_old(4, 0); 
    vector<double> x_new(4, 0); 

 
    double error;            
    int i = 0;      

    
    do {
        i++; 

        
        x_new[0] = (1.0 / A[0][0]) * (B[0] - A[0][1] * x_old[1]);
        x_new[1] = (1.0 / A[1][1]) * (B[1] - A[1][0] * x_old[0] - A[1][2] * x_old[2]);
        x_new[2] = (1.0 / A[2][2]) * (B[2] - A[2][1] * x_old[1] - A[2][3] * x_old[3]);
        x_new[3] = (1.0 / A[3][3]) * (B[3] - A[3][2] * x_old[2]);

        
        cout << "Iteration " << i << ": ";
        display(x_new);

        
        error = calculateError(x_new, x_old);

        x_old = x_new;

    } while (error > 1e-7); 

  
    cout << "Converged in " << i << " iterations." << endl;
    
    return 0;
}

