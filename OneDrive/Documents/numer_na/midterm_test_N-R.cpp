#include<iostream>
#include<cmath>
using namespace std;

double F(double X){
	return (X*X)-7;
}

double F2(double X){
	return 2*X;
}

int main (){
	double X = 2.0;
	double x,E;
	
	do{
		x=X;
		X = X-((F(X))/F2(X));
		cout << X << "=" << X <<" - ("<<F(X)<<") / "<<F2(X)<<endl;
		E = (X-x)/X;
	}while(E > 1e-9);
	cout << X << endl;
}
