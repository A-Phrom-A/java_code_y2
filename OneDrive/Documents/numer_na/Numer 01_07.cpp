#include <iostream>
#include <math.h>
using namespace std;


double Fx(double x){
	return 43*x-180;
}

int main(){
	double y,z,X;

	
	for(int i =0 ;i <=10;i++){
		cout << Fx(i)<< endl;
		if(Fx(i)*Fx(i+1)<0 ){
		 y = i;
		 z = i+1;
		 break;	
		}
	}

	for(double j =y;j<z;j += 0.0000001){

		if(Fx(j) >= -0.000001 && Fx(j) <= 0.1){
			X =j;
			break;
		}	
	}
	cout << "x = "<< X <<endl;

}
