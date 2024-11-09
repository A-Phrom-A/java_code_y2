#include <iostream>
#include <vector>

using namespace std;

// ???????????????? divided differences
void dividedDifferenceTable(vector<double>& X, vector<double>& Y, vector<vector<double> >& table) {
    int n = X.size();

    for (int i = 0; i < n; i++) {
        table[i][0] = Y[i];
    }

    for (int j = 1; j < n; j++) {
        for (int i = 0; i < n - j; i++) {
            table[i][j] = (table[i + 1][j - 1] - table[i][j - 1]) / (X[i + j] - X[i]);
        }
    }
}

// ???????????????? f(x) ?????? Newton's Interpolation
double newtonInterpolation(double x, vector<double>& X, vector<vector<double> >& table) {
    double result = table[0][0];
    double term = 1.0;

    for (int i = 1; i < X.size(); i++) {
        term *= (x - X[i - 1]);
        result += term * table[0][i];
    }

    return result;
}

int main() {
    double x = 40021;

    // ???????????? Linear Interpolation
    vector<double> X1, Y1;
    X1.push_back(0);
    X1.push_back(80000);
    Y1.push_back(9.81);
    Y1.push_back(9.5682);
    vector<vector<double> > table1(2, vector<double>(2, 0.0));
    dividedDifferenceTable(X1, Y1, table1);
    cout << "Linear (Newton) Interpolation at X = " << x << " Y = " << newtonInterpolation(x, X1, table1) << endl;

    // ???????????? Quadratic Interpolation
    vector<double> X2, Y2;
    X2.push_back(0);
    X2.push_back(40000);
    X2.push_back(80000);
    Y2.push_back(9.81);
    Y2.push_back(9.6879);
    Y2.push_back(9.5682);
    vector<vector<double> > table2(3, vector<double>(3, 0.0));
    dividedDifferenceTable(X2, Y2, table2);
    cout << "Quadratic (Newton) Interpolation at X = " << x << " Y = " << newtonInterpolation(x, X2, table2) << endl;

    // ???????????? Polynomial Interpolation
    vector<double> X3, Y3;
    X3.push_back(0);
    X3.push_back(20000);
    X3.push_back(40000);
    X3.push_back(60000);
    X3.push_back(80000);
    Y3.push_back(9.81);
    Y3.push_back(9.7487);
    Y3.push_back(9.6879);
    Y3.push_back(9.6879);
    Y3.push_back(9.5682);
    vector<vector<double> > table3(5, vector<double>(5, 0.0));
    dividedDifferenceTable(X3, Y3, table3);
    cout << "Polynomial (Newton) Interpolation at X = " << x << " Y = " << newtonInterpolation(x, X3, table3) << endl;

    return 0;
}


