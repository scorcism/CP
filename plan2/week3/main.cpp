
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

    int trap(vector<int> &height)
    {
        int left = 0;
        int right = height.size() - 1;
        int leftMax = height[0];
        int rightMax = height[right];
        int water = 0;
        while (left < right)
        {
            cout << leftMax << " " << rightMax << " " << left << " " << right << " " << endl;
            if (leftMax < rightMax)
            {
                left++;
                leftMax = max(leftMax, height[left]);
                water += leftMax - height[left];
            }
            else
            {
                right--;
                rightMax = max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }
        return water;
    }
};

int main()
{
    Solution sol;
    vector<int> arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int ans = sol.trap(arr);
    cout << ans << endl;
    return 0;
}