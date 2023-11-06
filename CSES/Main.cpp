#include <iostream>

using namespace std;

int main()
{
    long n;
    cin >> n;

    long long sumOfN = (n * (n + 1)) / 2;

    long long sum = 0;

    for(long i = 0; i< n-1; i++){
        long p  = 0;
        cin >> p;
        sum+=p;
    }

    cout << sumOfN - sum;
}