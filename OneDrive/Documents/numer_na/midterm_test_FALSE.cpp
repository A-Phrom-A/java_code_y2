#include<iostream>
#include<cmath>
using namespace std;

double Fx(double X){
	return 1-(2*X);
}

double Err(double X,double x){
	return fabs((X-x)/X);
}

int main (){
	double R = 80.0;
	double L = 90.5;
	double X,x;
	int i = 1;
	
	do{
		i += 1;
		x = X;
		X = ((L*Fx(R))-(R*Fx(L)))/(Fx(R)-Fx(L));
		if (Fx(R)*Fx(X) > 0){
			R = X;
		}else{
			L = X;
		}
	}while(Err(X,x) > 1e-9);
	
	cout << "X" << i << " = " << X << endl;
}
