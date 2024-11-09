#include<iostream>
#include<cmath>
using namespace std;

double F(double X){
	return (X*X)-7;
}

double Err(double X,double x){
	return fabs((X-x)/X);
}

int main (){
	double x1 = 3.0;
	double x0 = 2.0;
	double X,E;
	
	do{
		X = x1-F(x1)*( (x1-x0) / (F(x1)-F(x0)) );
		E = Err(X,x1);
		x0 = x1;
		x1 = X;
		
	}while(E > 1e-9);
	cout << "x = " << X << endl;
}
