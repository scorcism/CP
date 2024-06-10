
#include <bits/stdc++.h>

class Solution
{

public:
    bool containsDuplicate(vector<int> &nums)
    {
        unordered_set<int> set;

        for (auto e : nums)
        {
            if (set.contains(e))
            {
                return true;
            }
            set.insert(e);
        }

        return false;
    }

    //  Q. https://leetcode.com/problems/valid-anagram/
    bool isAnagram(string s, string t)
    {
        if (s.length() != t.length())
        {
            return false;
        }

        vector<int> freq(26, 0);

        for (int i = 0; i < s.length(); i++)
        {
            freq[s[i] - 'a'] += 1;
            freq[t[i] - 'a'] -= 1;
        }

        for (int i = 0; i < freq.size(); i++)
        {
            if (freq[i] != 0)
            {
                return false;
            }
        }

        return true;
    }

    // https://leetcode.com/problems/two-sum/
    vector<int> twoSum(vector<int> &nums, int target)
    {
        map<int, int> m;
        vector<int> ans;

        for (int i = 0; i < nums.size(); i++)
        {
            if (!m.empty() && m.find(target - nums[i]) != m.end())
            {
                ans.push_back(i);
                ans.push_back(m[target - nums[i]]);
                break;
            }
            else
            {
                m[nums[i]] = i;
            }
        }
        return ans;
    }

    // https://leetcode.com/problems/group-anagrams/
    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        vector<vector<string>> ans;
        unordered_map<string, vector<string>> m;

        for (auto s : strs)
        {
            string localString = s;
            sort(localString.begin(), localString.end());
            m[localString].push_back(s);
        }

        for (auto s : m)
        {
            ans.push_back(s.second);
        }

        return ans;
    }
}

main()
{

    Solution sol = new Solution();

    return 0;
}
