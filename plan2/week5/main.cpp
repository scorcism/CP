#include <bits/stdc++.h>


using namespace std;

class Solution
{
public:
	bool compareMap(map<char, int> &patMap,
					map<char, int> &tempMap)
	{
		return patMap.size() == tempMap.size() && std::equal(patMap.begin(), patMap.end(), tempMap.begin());
	}

	int search(string pat, string txt)
	{
		int k = pat.size();

		map<char, int> patMap;
		map<char, int> tempMap;

		for (char c : pat)
		{
			patMap[c]++;
		}

		int i = 0;
		int j = 0;

		int count = 0;

		while (j < txt.size())
		{
			tempMap[txt[j]]++;

			if (j - i + 1 < k)
			{
				j++;
			}
			else if (j - i + 1 == k)
			{
				// In window
				if (compareMap(patMap, tempMap))
				{
					count++;
				}
				if (tempMap[txt[i]] > 1)
				{
					tempMap[txt[i]]--;
				}
				else
				{
					tempMap.erase(txt[i]);
				}
				i++;
				j++;
			}
		}

		return count;
	}
};

int main()
{
	Solution sol;
	string pat = "aaba";
	string txt = "aabaabaa";
	cout << sol.search(pat, txt) << endl;
	return 0;
}