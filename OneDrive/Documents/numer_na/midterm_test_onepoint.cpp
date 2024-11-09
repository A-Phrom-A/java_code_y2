#include<iostream>
#include<cmath>
using namespace std;

double Fx(double X){
	return 2-exp(X/4);
}

double Err(double X,double x){
	return fabs((X-x)/X);
}

int main (){
	int i=1;
	double X = 1.0;
	double x ; 
	
	do{
		i += 1;
		x = X;
		X =Fx(X);
		cout << "x" << i << " " << "= " << X << endl; 
		
	}while(Err(X,x) > 1e-9);
	
}
