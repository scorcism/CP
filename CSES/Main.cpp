#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n;
    cin >> n;

    if(n == 1){
        cout << "1";
    }else if(n ==2 || n ==3 ){
        cout << "NO SOLUTION";
    }else if(n==4){
        cout << "3 1 4 2";
    }else{
        for(int i = n; i> 0; i-=2){
            cout << i << " " ;
        }
        for(int i = n-1; i> 0; i-=2){
            cout << i << " " ;
        }
    }

    return 0;
}