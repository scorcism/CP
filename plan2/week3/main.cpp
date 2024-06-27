
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

    vector<vector<int>> threeSum(vector<int> &nums)
    {
        vector<vector<int>> out;

        int n = nums.size();
        sort(nums.begin(), nums.end());

        for (int i = 0; i < n; i++)
        {
            // Check for duplicate
            if (i > 0 && nums[i - 1] == nums[i])
            {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k)
            {
                int localSum = nums[i] + nums[j] + nums[k];
                if (localSum > 0)
                {
                    k--;
                }
                else if (localSum < 0)
                {
                    j++;
                }
                else
                {
                    out.push_back({nums[i], nums[j], nums[k]});
                    j++;
                    // Check next one is duplicate if yes, while j <k move j
                    while (j < k && nums[j] == nums[j - 1])
                    {
                        j++;
                    }
                }
            }
        }

        return out;
    }

    int main()
    {
        Solution sol;
        vector<int> arr = {-1, 0, 1, 2, -1, -4};
        vector<vector<int>> ans = sol.threeSum(arr);

        return 0;
    }
};