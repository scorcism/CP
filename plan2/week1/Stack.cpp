#include <iostream>
#include <stack>

using namespace std;

int main(){
    // stack
    stack<int> s;


    s.push(1);
    s.push(2);
    s.push(3);

    cout << "Top element: "<<s.top()<<endl;
    s.pop();
    s.pop();
    s.pop();
    // Check if stack empty
    cout << s.empty();

    return 0;
}

