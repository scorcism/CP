
#include <bits/stdc++.h>
#include <string>
#include <cctype>

using namespace std;

class Solution
{
public:
    void printV(vector<int> &nums)
    {
        for (int n : nums)
        {
            cout << n << " ";
        }
        cout << endl;
    }

    int maxArea(vector<int> &height)
    {
        int result = -10e4;
        int n = height.size();
        int start = 0;
        int end = n - 1;
        while (start < end)
        {
            // Calculate the distance
            result = max(result, (end - start) * min(height[start], height[end]));
            if (height[start] < height[end])
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        return result;
    }
};

int main()
{
    Solution sol;
    vector<int> arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int res = sol.maxArea(arr);
    cout << res << endl;
    return 0;
}