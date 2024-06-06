
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
}

main()
{

    Solution sol = new Solution();

    return 0;
}
