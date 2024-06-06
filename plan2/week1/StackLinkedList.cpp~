#include<iostream>

using namespace std;


// Stack
// Push -> push element to top
// Pop -> pop element from top

struct Node{
    int data;
    Node* next;
};

class Stack{

    private:
        Node* top;
        int count = 0;

    public:
        Stack(){
            top = nullptr;
        }

        void push(int num){
            Node* newNode = new Node();
            newNode->data = num;
            newNode->next = top;
            top = newNode;
            count++;
        }

        void pop(){
            if(top==nullptr){
                cout << "No elements in stack\n";
                return;
            }
            Node* temp = top;
            top = top->next;
            delete temp;
            count--;
        }

        int size(){
            return count;
        }

        int isEmpty(){
            return count == 0;
        }
        
        int stackTop(){
            return top == nullptr ? 0 : top->data;
        }
};

int main(){

    Stack s;

    s.push(10);
    s.push(20);

    cout << s.stackTop() << endl;
    
    s.pop();
    
    cout << s.stackTop()<<endl;
    
    cout << s.size()<<endl;
    cout << s.isEmpty()<<endl;
    
    return 0;
}

