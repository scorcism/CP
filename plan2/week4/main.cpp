#include <bits/stdc++.h>

class Solution
{
public:
    bool isValid(string s)
    {
        map<char, int> m = {
            {'(', -1},
            {')', 1},
            {'{', -2},
            {'}', 2},
            {'[', -3},
            {']', 3}};

        stack<char> stk;

        for (char c : s)
        {
            if (m[c] < 0)
            {
                stk.push(c);
            }
            else if (m[c] > 0)
            {
                // Check if starting and ending parenthesis matched
                if (!stk.empty() && m[c] + m[stk.top()] == 0)
                {
                    stk.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        return stk.empty();
    }
}

int
main()
{

    return 0;
}