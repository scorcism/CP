
#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
public:
    void printVector(vector<int> &v)
    {

        for (int i : v)
        {
            cout << i << " ";
        }
    }

    int getCount(vector<int> &nums, int num)
    {
        int count = 0;
        for (int i : nums)
        {
            if (i == num)
            {
                count++;
            }
        }
        return count;
    }

    // https://leetcode.com/problems/top-k-frequent-elements/description/
    vector<int> topKFrequent(vector<int> &nums, int k)
    {
        int n = nums.size();
        unordered_set<int> set;
        vector<vector<int>> v(n + 1);
        vector<int> ans;

        for (int i : nums)
        {
            // Get the unique
            set.insert(i);
        }

        // Store all the elements based on their occurence
        for (auto i = set.begin(); i != set.end(); ++i)
        {
            int count = getCount(nums, *i);
            v[count].push_back(*i);
        }

        for (int i = v.size()-1; i >= 0; i--)
        {
            if (v[i].size() > 0)
            {
                for (int j = 0; j < v[i].size(); j++)
                {
                    if (k > 0)
                    {
                        ans.push_back(v[i][j]);
                        k--;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        return ans;
    }
};

int main()
{

    Solution sol;

    vector<int> q = {1, 1, 1, 2, 2, 3};
    int k = 2;

    vector<int> ans = sol.topKFrequent(q, k);
    sol.printVector(ans);

    return 0;
}
