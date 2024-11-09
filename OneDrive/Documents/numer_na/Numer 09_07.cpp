#include <iostream>
#include <iomanip>

using namespace std;

double determinant(double A[3][3]) {
    return A[0][0] * (A[1][1] * A[2][2] - A[1][2] * A[2][1]) -
           A[0][1] * (A[1][0] * A[2][2] - A[1][2] * A[2][0]) +
           A[0][2] * (A[1][0] * A[2][1] - A[1][1] * A[2][0]);
}

void cramer(double A[3][3], double B[3]) {
    double det_A = determinant(A);
    if (det_A == 0) {
        cout << "Determinant is zero, system has no unique solution." << endl;
        return;
    }

    double A1[3][3], A2[3][3], A3[3][3];
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            A1[i][j] = A[i][j];
            A2[i][j] = A[i][j];
            A3[i][j] = A[i][j];
        }
    }

    // Replacing columns for x1, x2, x3
    for (int i = 0; i < 3; ++i) {
        A1[i][0] = B[i];
        A2[i][1] = B[i];
        A3[i][2] = B[i];
    }

    double x1 = determinant(A1) / det_A;
    double x2 = determinant(A2) / det_A;
    double x3 = determinant(A3) / det_A;

    cout << fixed << setprecision(6);
    cout <<det_A<<endl;
    cout << "x1 = " << x1 << ", x2 = " << x2 << ", x3 = " << x3 << endl;
}

void gaussElimination(double A[3][3], double B[3]) {
    
    double a1[4]={A[0][0],A[0][1],A[0][2],B[0]};
   
   for(int i = 0; i < 4; i++) {
        a1[i] = a1[i] / A[0][0];
    }
    
    double a2[4]={A[1][0],A[1][1],A[1][2],B[1]};
    for(int i = 0; i < 4; i++) {
        a2[i] = a2[i] - ((a1[i])*A[1][0]);
    }
    for(int i = 0; i < 4; i++) {
        a2[i] = a2[i] / a2[1];
    }
    
    double a3[4]={A[2][0],A[2][1],A[2][2],B[2]};
    for(int i = 0; i < 4; i++) {
        a3[i] = a3[i] - ((a1[i])*A[2][0]);
    }
    for(int i = 0; i < 4; i++) {
        a3[i] = a3[i] - ((a2[i])*a3[1]);
    }
        for(int i = 0; i < 4; i++) {
        a3[i] = a3[i] / a3[2];
    }


    // Output the array
    for(int i = 0; i < 4; i++) {
        cout << a1[i] << "\t";
    }
    cout << endl;
        for(int i = 0; i < 4; i++) {
        cout << a2[i] << "\t";
    }
    cout << endl;
            for(int i = 0; i < 4; i++) {
        cout << a3[i] << "\t";
    }
    cout << endl;
    

}

int main() {
    double A[3][3] = {
        {-2, 3, 1},
        {3, 4, -5},
        {1, -2, 1}
    };
    
    double B[3] = {9, 0, -4};

   
    gaussElimination(A,B);
     //cramer(A, B)

    return 0;
}

