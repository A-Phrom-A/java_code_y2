#include <iostream>

 const int i = 10; 
 int A[i];
 int T = -1;
 
using namespace std;

int Push(int P){
	
       if (T == i - 1) {
        cout << "Stack Overflow!" << endl;
       } 
	   else {
        T++;
        A[T] = P;
        cout << "Pushed " << P << " onto the stack." << endl;
    }
}
    

int Pop(){
	
    if (T == -1) {
        cout << "none" << endl;
        return -1;
    } else {
        int pop = A[T];
        T--;
        cout << "Pop " << pop << endl;
        return pop;
}
}


main(){
	int X;
	char key;

	do {
	cout<<"please enter key : ";
	cin >>key;
	
	switch(key) {
		case 'P':{
			cout << "number : ";
			cin>>X;
			Push(X);
			break;
		}
		case 'X' :{
			
			int F2 = Pop();
			break;
			}	
			
		default:
			cout<<"Please choose between P and X"<<endl;
}
	
} while(key != 0);	
	return 0;
	
}

