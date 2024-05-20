#include <iostream>

using namespace std;


int main()
{
    int arr[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    int arr2[2]; // declaring array
	

    // initilizing arr2
    arr2[0] = 1;
    arr2[1] = 10;


    // for loop
    for(int i = 0; i< sizeof(arr)/sizeof(int); i++){
    	cout << arr[i]<<endl;
    }
    
    for(int i = 0; i< sizeof(arr2)/sizeof(int); i++){
    	cout << arr2[i]<<endl;
    }

    return 0;
}
