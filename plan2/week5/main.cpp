#include <bits/stdc++.h>

using namespace std;

int longestSubstrDistinctChars(string s)
{
    int n = s.size();
    int start = 0;
    int end = 0;
    unordered_map<char, int> map;
    int maxLen = 1;

    while (end < n)
    {

        map[s[end]]++;

        while (map.size() < end - start + 1)
        {
            map[s[start]]--;
            if (map[s[start]] < 1)
            {
                map.erase(s[start]);
            }
            start++;
        }
        if (map.size() == end - start + 1)
        {
            maxLen = max(maxLen, end - start + 1);
        }
        end++;
    }
    return maxLen;
}

int main()
{
    string s = "geeksforgeeks";

    int ans = longestSubstrDistinctChars(s);

    cout << ans << " ";
}