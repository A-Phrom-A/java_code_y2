#include <iostream>
using namespace std;

int main(){
	int y,x,sum;
	cout <<"input X : ";
	cin >> x;
	
	for(int i=0;i<x;i++) {
		cout<<"input y : ";
		cin>>y;
		sum=sum+y;
		
}
int avg = sum/x;
cout << "avg is : " << avg;
return 0;
}
