#include <climits>

class MinStack
{

private:
    stack<int> minStack;
    stack<int> s;

public:
    MinStack()
    {
        min_stack.push(INT_MAX);
    }

    void push(int val)
    {
        s.push(val);
        minStack.push(min(val, minStack.top()));
    }

    void pop()
    {
        s.pop();
        minStack.pop();
    }

    int top()
    {
        return s.top();
    }

    int getMin()
    {
        return minStack.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */