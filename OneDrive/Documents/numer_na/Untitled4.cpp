#include <iostream>
#include <cmath> // สำหรับฟังก์ชัน sqrt() และ fabs()

using namespace std;

// ฟังก์ชันคำนวณ Determinant ของเมทริกซ์ 3x3
double determinant(double A[3][3]) {
    return A[0][0] * (A[1][1] * A[2][2] - A[1][2] * A[2][1])
         - A[0][1] * (A[1][0] * A[2][2] - A[1][2] * A[2][0])
         + A[0][2] * (A[1][0] * A[2][1] - A[1][1] * A[2][0]);
}

// ฟังก์ชันคำนวณอินเวิร์สของเมทริกซ์ 3x3
bool inverse(double A[3][3], double inverseA[3][3]) {
    double det = determinant(A);
    if (fabs(det) < 1e-9) { // ตรวจสอบการเป็นศูนย์ของ Determinant
        return false; // เมทริกซ์ไม่สามารถหาค่าอินเวิร์สได้
    }
    double invDet = 1.0 / det;
    inverseA[0][0] = (A[1][1] * A[2][2] - A[1][2] * A[2][1]) * invDet;
    inverseA[0][1] = (A[0][2] * A[2][1] - A[0][1] * A[2][2]) * invDet;
    inverseA[0][2] = (A[0][1] * A[1][2] - A[0][2] * A[1][1]) * invDet;
    inverseA[1][0] = (A[1][2] * A[2][0] - A[1][0] * A[2][2]) * invDet;
    inverseA[1][1] = (A[0][0] * A[2][2] - A[0][2] * A[2][0]) * invDet;
    inverseA[1][2] = (A[0][2] * A[1][0] - A[0][0] * A[1][2]) * invDet;
    inverseA[2][0] = (A[1][0] * A[2][1] - A[1][1] * A[2][0]) * invDet;
    inverseA[2][1] = (A[0][1] * A[2][0] - A[0][0] * A[2][1]) * invDet;
    inverseA[2][2] = (A[0][0] * A[1][1] - A[0][1] * A[1][0]) * invDet;
    return true;
}

// ฟังก์ชันคำนวณ Cholesky Decomposition
bool CholeskyDecomposition(double A[3][3], double L[3][3]) {
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j <= i; ++j) {
            double sum = 0;
            if (i == j) {
                for (int k = 0; k < j; ++k) {
                    sum += L[j][k] * L[j][k];
                }
                L[j][j] = A[j][j] - sum;
                if (L[j][j] <= 0) {
                    return false; // เมทริกซ์ไม่เป็น positive definite
                }
                L[j][j] = sqrt(L[j][j]);
            } else {
                for (int k = 0; k < i; ++k) {
                    sum += L[i][k] * L[j][k];
                }
                L[i][j] = (A[i][j] - sum) / L[j][j];
            }
        }
    }
    return true;
}

// ฟังก์ชันคำนวณ LU Decomposition
void LUDecomposition(double A[3][3], double L[3][3], double U[3][3]) {
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            if (j < i) {
                L[j][i] = 0;
            } else {
                L[j][i] = A[j][i];
                for (int k = 0; k < i; ++k) {
                    L[j][i] -= L[j][k] * U[k][i];
                }
            }
        }
        for (int j = 0; j < 3; ++j) {
            if (j < i) {
                U[i][j] = 0;
            } else if (i == j) {
                U[i][j] = 1;
            } else {
                U[i][j] = A[i][j];
                for (int k = 0; k < i; ++k) {
                    U[i][j] -= L[i][k] * U[k][j];
                }
                U[i][j] /= L[i][i];
            }
        }
    }
}

// ฟังก์ชันแก้สมการด้วยวิธี Cramer's Rule
void solveCramer(double A[3][3], double B[3], double result[3]) {
    double detA = determinant(A);
    if (fabs(detA) < 1e-9) { // ตรวจสอบการเป็นศูนย์ของ Determinant
        cout << "Determinant is zero. Cramer's Rule cannot be applied." << endl;
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
    for (int i = 0; i < 3; ++i) {
        A1[i][0] = B[i];
        A2[i][1] = B[i];
        A3[i][2] = B[i];
    }
    result[0] = determinant(A1) / detA;
    result[1] = determinant(A2) / detA;
    result[2] = determinant(A3) / detA;
}

// ฟังก์ชันแก้สมการด้วยวิธี Gauss Elimination
void solveGaussElimination(double A[3][3], double B[3], double result[3]) {
    double augmented[3][4];
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            augmented[i][j] = A[i][j];
        }
        augmented[i][3] = B[i];
    }

    for (int i = 0; i < 3; ++i) {
        if (augmented[i][i] == 0) {
            for (int k = i + 1; k < 3; ++k) {
                if (augmented[k][i] != 0) {
                    for (int j = 0; j < 4; ++j) {
                        swap(augmented[i][j], augmented[k][j]);
                    }
                    break;
                }
            }
        }

        for (int j = 0; j < 3; ++j) {
            if (i != j) {
                double ratio = augmented[j][i] / augmented[i][i];
                for (int k = 0; k < 4; ++k) {
                    augmented[j][k] -= ratio * augmented[i][k];
                }
            }
        }
    }

    for (int i = 0; i < 3; ++i) {
        result[i] = augmented[i][3] / augmented[i][i];
    }
}

// ฟังก์ชันแก้สมการด้วยวิธี Gauss-Jordan
void solveGaussJordan(double A[3][3], double B[3], double result[3]) {
    double augmented[3][4];
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            augmented[i][j] = A[i][j];
        }
        augmented[i][3] = B[i];
    }

    for (int i = 0; i < 3; ++i) {
        double pivot = augmented[i][i];
        for (int j = 0; j < 4; ++j) {
            augmented[i][j] /= pivot;
        }

        for (int k = 0; k < 3; ++k) {
            if (k != i) {
                double ratio = augmented[k][i];
                for (int j = 0; j < 4; ++j) {
                    augmented[k][j] -= ratio * augmented[i][j];
                }
            }
        }
    }

    for (int i = 0; i < 3; ++i) {
        result[i] = augmented[i][3];
    }
}

// ฟังก์ชันแก้สมการด้วยวิธี Matrix Inversion
bool solveMatrixInversion(double A[3][3], double B[3], double result[3]) {
    double invA[3][3];
    if (!inverse(A, invA)) {
        cout << "Matrix is not invertible." << endl;
        return false;
    }

    for (int i = 0; i < 3; ++i) {
        result[i] = 0;
        for (int j = 0; j < 3; ++j) {
            result[i] += invA[i][j] * B[j];
        }
    }
    return true;
}

// ฟังก์ชันแก้สมการด้วยวิธี LU Decomposition
void solveLUDecomposition(double A[3][3], double B[3], double result[3]) {
    double L[3][3] = {0}, U[3][3] = {0};
    LUDecomposition(A, L, U);

    double Y[3] = {0};
    for (int i = 0; i < 3; ++i) {
        Y[i] = B[i];
        for (int j = 0; j < i; ++j) {
            Y[i] -= L[i][j] * Y[j];
        }
        Y[i] /= L[i][i];
    }

    for (int i = 2; i >= 0; --i) {
        result[i] = Y[i];
        for (int j = i + 1; j < 3; ++j) {
            result[i] -= U[i][j] * result[j];
        }
        result[i] /= U[i][i];
    }
}

// ฟังก์ชันแก้สมการด้วยวิธี Cholesky Decomposition
void solveCholesky(double A[3][3], double B[3], double result[3]) {
    double L[3][3] = {0};
    if (!CholeskyDecomposition(A, L)) {
        cout << "Matrix is not positive definite. Cholesky Decomposition failed." << endl;
        return;
    }

    double y[3] = {0};
    for (int i = 0; i < 3; ++i) {
        y[i] = B[i];
        for (int j = 0; j < i; ++j) {
            y[i] -= L[i][j] * y[j];
        }
        y[i] /= L[i][i];
    }

    for (int i = 2; i >= 0; --i) {
        result[i] = y[i];
        for (int j = i + 1; j < 3; ++j) {
            result[i] -= L[j][i] * result[j];
        }
        result[i] /= L[i][i];
    }
}

// ฟังก์ชันหลักสำหรับการแสดงผล
int main() {
    double A[3][3] = {
        {-2, 3, 1},
        {3, 4, -5},
        {1, -2, 1}
    };
    double B[3] = {9, 0, -4};
    double result[3];

    // แก้สมการด้วยวิธี Cramer's Rule
    solveCramer(A, B, result);
    cout << "Cramer's Rule Results: ";
    for (int i = 0; i < 3; ++i) {
        cout << result[i] << " ";
    }
    cout << endl;

    // แก้สมการด้วยวิธี Gauss Elimination
    solveGaussElimination(A, B, result);
    cout << "Gauss Elimination Results: ";
    for (int i = 0; i < 3; ++i) {
        cout << result[i] << " ";
    }
    cout << endl;

    // แก้สมการด้วยวิธี Gauss-Jordan
    solveGaussJordan(A, B, result);
    cout << "Gauss-Jordan Results: ";
    for (int i = 0; i < 3; ++i) {
        cout << result[i] << " ";
    }
    cout << endl;

    // แก้สมการด้วยวิธี Matrix Inversion
    if (solveMatrixInversion(A, B, result)) {
        cout << "Matrix Inversion Results: ";
        for (int i = 0; i < 3; ++i) {
            cout << result[i] << " ";
        }
        cout << endl;
    }

    // แก้สมการด้วยวิธี LU Decomposition
    solveLUDecomposition(A, B, result);
    cout << "LU Decomposition Results: ";
    for (int i = 0; i < 3; ++i) {
        cout << result[i] << " ";
    }
    cout << endl;

    // แก้สมการด้วยวิธี Cholesky Decomposition
    solveCholesky(A, B, result);
    cout << "Cholesky Decomposition Results: ";
    for (int i = 0; i < 3; ++i) {
        cout << result[i] << " ";
    }
    cout << endl;

    return 0;
}

