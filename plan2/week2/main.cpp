
#include <bits/stdc++.h>

class Solution
{

public:
    bool containsDuplicate(vector<int> &nums)
    {
        unordered_set<int> set;

        for(auto e: nums){
            if(set.contains(e)){
                return true;
            }
            set.insert(e);
        }

        return false;
    }
}

int
main()
{

    Solution sol = new Solution();

    return 0;
}
