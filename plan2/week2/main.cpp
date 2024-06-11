
#include <bits/stdc++.h>
using namespace std;
class Solution
{

private:
    void printVector(vector<int> v)
    {

        for (int i : v)
        {
            cout << i << " ";
        }
    }

public:
    // https://leetcode.com/problems/product-of-array-except-self/
    vector<int> productExceptSelf(vector<int> &nums)
    {
        int n = nums.size();
        vector<int> ans(n,1);
        // Get the prefix mul
        signed pre = 1;
        for (int i = 0; i < n; i++)
        {
            ans[i] = pre; // Put the prefix mul till now into the ith position
            // Prepare the prefix mul for next one
            pre *= nums[i];
        }

        signed suf = 1;
        for (int i = n - 1; i >= 0; i--)
        {
            ans[i] *= suf;
            suf *= nums[i];
        }

        return ans;
    }
};

int main()
{

    Solution sol;

    vector<int> q = {1, 2, 3, 4};
    auto ans = sol.productExceptSelf(q);

    for (int i : ans)
    {
        cout << i << " ";
    }

    return 0;
}
