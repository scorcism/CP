
#include <bits/stdc++.h>
#include <string>
#include <cctype>

class Solution
{
public:
    vector<int> twoSum(vector<int> &numbers, int target)
    {
        vector<int> ans;

        int n = numbers.size();
        int i = 0;
        int j = n-1;

        while (i < j)
        {
            int localSum = numbers[i] + numbers[j];
            if (localSum > target)
            {
                j--;
            }
            else if (localSum < target)
            {
                i++;
            }
            if (localSum == target)
            {
                ans.push_back(i+1);
                ans.push_back(j+1);
                break;
            }
        }
        return ans;
    }

    int main()
    {
        Solution sol;
    }
}