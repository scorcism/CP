
#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
public:
    template <typename T>
    void printVector(vector<T> &v)
    {
        for (const T &i : v)
        {
            cout << i << " ";
        }
        cout << endl;
    }

    // https://leetcode.com/problems/encode-and-decode-strings/

    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    string encode(vector<string> &strs)
    {
        string output = "";
        int n = strs.size();
        for (int i = 0; i < n; i++)
        {
            string st = strs[i];
            output += st + "$;";
        }
        return output;
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    vector<string> decode(string &str)
    {
        vector<string> output;

        string sWord = "";
        for (int i = 0; i < str.size(); i++)
        {
            if (i < str.size() - 1 && str[i] == '$' && str[i + 1] == ';')
            {
                output.push_back(sWord);
                sWord = "";
                i += 1;
            }
            else
            {
                sWord += str[i];
            }
        }

        return output;
    }
};

int main()
{

    Solution sol;

    vector<string> q = {"neet", "code", "love", "you"};

    string encodedString = sol.encode(q);

    cout << "Encoded string" << encodedString << endl;

    vector<string> decodedString = sol.decode(encodedString);
    cout << "Encoded string" << endl;

    sol.printVector(decodedString);

    return 0;
}
