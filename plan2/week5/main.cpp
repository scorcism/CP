#include <bits/stdc++.h>

using namespace std;

class Solution
{
public:
    int longestKSubstr(string s, int k)
    {

        int n = s.size();
        int maxLen = -1;
        int start = 0;
        int end = 0;
        unordered_map<char, int> map;

        while (end < n)
        {
            map[s[end]]++;
            if (map.size() < k)
            {
                end++;
            }
            if (map.size() == k)
            {
                maxLen = max(maxLen, end - start + 1);
                end++;
            }
            else if (map.size() > k)
            {
                while (map.size() > k)
                {
                    map[s[start]]--;
                    if (map[s[start]] < 1)
                    {
                        map.erase(s[start]);
                    }
                    start++;
                }
                end++;
            }
        }
        return maxLen;
    }
};

int main()
{
    Solution sol;
    string s = "aabacbebebe";
    int k = 3;

    int ans = sol.longestKSubstr(s, k);

    cout << ans << " ";
}