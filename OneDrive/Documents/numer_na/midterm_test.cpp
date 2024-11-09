#include<iostream>
using namespace std;
double Fx(double X){
	return (X*13)-127;
}

int main (){
	double x,y,z;
	
	for(int i =0;i<11;i++){
		cout << i <<  "x = " << Fx(i) << endl;
		if(Fx(i)*Fx(i+1) < 0){
			y = i;
			z =i+1;
		}
	}
	
   
    for(double i = y; i < z; i += 0.0000001) {
    	
        if(Fx(i) >= -0.000001 && Fx(i) <= 0.000001) {  // ??????????????????????
            x=i;
            
            break;
        }
    }
    cout << "x = " << x << endl;

	cout << "ok"<<endl;
}
