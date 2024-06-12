
#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    void printVector(vector<int> &v)
    {

        for (int i : v)
        {
            cout << i << " ";
        }
    }

public:
    // https://leetcode.com/problems/longest-consecutive-sequence/
    int longestConsecutive(vector<int> &nums)
    {

        int _max = 0;
        unordered_set<int> set;

        for (int i = 0; i < nums.size(); i++)
        {
            set.insert(nums[i]);
        }

        for (int i = 0; i < nums.size(); i++)
        {
            if (set.find(nums[i] - 1) == set.end())
            {
                int localMax = 1;
                // previous doesnt exists
                // Check if consecutive exists
                for (int j = nums[i]+1; j < 10e5; j++)
                {
                    if (set.find(j) != set.end())
                    {
                        localMax++;
                    }
                    else
                    {
                        break;
                    }
                }
                _max = max(localMax, _max);
            }
        }

        return _max;
    }
};

int main()
{

    Solution sol;

    vector<int> q = {1, 2, 3, 4};

    return 0;
}
