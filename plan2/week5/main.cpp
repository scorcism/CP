#include <unordered_map>

class Solution
{
public:
    int lenOfLongSubarr(int nums[], int N, int K)
    {
        unordered_map<int, int> m;

        int currSum = 0;

        int maxLen = 0;

        int i = 0;

        while (i < N)
        {
            currSum += nums[i];

            if (currSum == K)
            // Why? if currSum - K == 0 means while iterating we found direct solution. and this will not be cpatured in the map untile and unless we have found 0 by any chance and that could also means that there might be any previous operation but as we direclt got the answer we will just store thge length
            {
                maxLen = max(maxLen, i + 1);
            }

            if (m.find(currSum - K) != m.end())
            {
                maxLen = max(maxLen, i - m[currSum - K]);
            }

            // To deal with 0s
            if (m.find(currSum) == m.end())
            {
                m[currSum] = i;
            }
            
            i++;
        }

        return maxLen;
    }
};