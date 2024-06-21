
#include <bits/stdc++.h>
#include <string>
#include <cctype>

class Solution
{
public:
    bool isPalindrome(string s)
    {
        int n = s.length();
        int start = 0;
        int end = n - 1;

        while (start <= end)
        {
            if (!isalnum(s[start]))
            {
                start++;
                continue;
            }

            if (!isalnum(s[end]))
            {
                end--;
                continue;
            }

            if (tolower(s[start]) != tolower(s[end]))
            {
                return false;
            }
            else
            {

                start++;
                end--;
            }
        }
        return true;
    };

    int main()
    {
        Solution sol;
        string s = "A man, a plan, a canal: Panama";
        sol.isPalindrome(s);
    }
}