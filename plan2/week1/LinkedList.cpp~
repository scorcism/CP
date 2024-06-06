#include <iostream>

using namespace std;

// Struct which represents a node. Node combiantion of data and a Node that points to data of type itselg
struct Node{
    int data;
    Node* node;
};

// Print values of linkedlist
void printList(Node* head){
    // While head not equals to null, move forward
    while(head != nullptr){
        cout<<head->data<<" ";
        // Move to te next node
        head = head->node;
    }
    cout << endl;
}

int main(){

    // head node, start point. Initilizing node
    Node* head = nullptr;
    Node* second = nullptr;
    Node* third = nullptr;

    // Allocating nodes in heap
    head = new Node();
    second = new Node();
    third = new Node();
 
    // Assigining data 
    head->data = 1;
    head->node = second;

    second->data = 2;
    second->node=  third;

    third->data = 3;
    third->node = nullptr;

    printList(head);

    // Memory cleanups
    delete head;
    delete second;
    delete third;
    
	return 0;
}

