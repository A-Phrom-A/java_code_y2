#include<iostream>
#include<cmath>
using namespace std;

double Fx(double x){
	return (x*x*x*x)-13;
}

int main (){
	double L = 1.5;
	double R = 2.0;
	double M,m,E;
	double e = 1e-9;
	do{
		m = M;
		M = (R+L)/2;
		E = fabs((M-m)/M);
		
		if(Fx(R)*Fx(M) > 0){
			R = M;
		}else{
			L = M;
		}
		
	}while(E > e);
	cout << "X = " << M << endl;
}
