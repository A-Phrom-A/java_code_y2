#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
#define MAX_ITER 100
#define TOLERANCE 1e-6

void displayResults(const vector<double>& x, int count) {
    for (int i = 0; i < x.size(); i++) {
        cout << "X[" << i << "] : " << x[i] << endl;
    }
    cout << "Iterations: " << count << endl;
}

bool checkConvergence(const vector<double>& x, const vector<double>& x_old) {
    for (int i = 0; i < x.size(); i++) {
        if (abs((x[i] - x_old[i]) / x[i]) >= TOLERANCE) {
            return false;
        }
    }
    return true;
}

// Recursive Gauss-Seidel function
void gaussSeidelRecursive(const vector<vector<double> >& a, const vector<double>& b, vector<double>& x, vector<double>& x_old, int count = 1) {
    // Base case: Stop if max iterations reached
    if (count > MAX_ITER) {
        cout << "Did not converge within " << MAX_ITER << " iterations." << endl;
        return;
    }

    // Update each element of x
    for (int i = 0; i < x.size(); i++) {
        double p = b[i];
        for (int j = 0; j < x.size(); j++) {
            if (i != j) {
                p -= a[i][j] * x[j];
            }
        }
        x_old[i] = x[i];
        x[i] = p / a[i][i];
    }

    // Check convergence
    if (checkConvergence(x, x_old)) {
        displayResults(x, count);
        return;
    }

    // Recursive call for next iteration
    gaussSeidelRecursive(a, b, x, x_old, count + 1);
}

int main() {
    int n;
    cout << "Matrix size: ";
    cin >> n;

    vector<vector<double> > a(n, vector<double>(n));
    vector<double> x(n), x_old(n), b(n);

    // Input matrix A
    cout << "Input Matrix A:" << endl;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> a[i][j];
        }
    }

    // Input vector B
    cout << "Input Vector B:" << endl;
    for (int i = 0; i < n; i++) {
        cin >> b[i];
    }

    // Initial values of X
    cout << "Input initial values for X:" << endl;
    for (int i = 0; i < n; i++) {
        cin >> x[i];
    }

    // Start recursive Gauss-Seidel iterations
    gaussSeidelRecursive(a, b, x, x_old);

    return 0;
}

