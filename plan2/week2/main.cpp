
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

    // https://leetcode.com/problems/valid-sudoku/
    bool isValidSudoku(vector<vector<char>> &board)
    {
        unordered_set<char> rows;
        unordered_set<char> cols;
        int block[3][3] = {0};

        for (int i = 0; i < board.size(); ++i)
        {
            for (int j = 0; j < board[i].size(); ++j)
            {
                int k = i / 3 * 3 + j / 3;
                if (board[i][j] != '.')
                {
                    if (rows.find(board[i][j]) != rows.end() ||
                        cols.find(board[i][j]) != cols.end() ||
                        block[i / 3, j / 3] == 1)
                    {
                        return false;
                    }
                    rows[i].insert(board[i][j]);
                    cols[j].insert(board[i][j]);
                    block[i / 3][j / 3] = 1;
                }
            }
        }
        return true;
    }
};

int main()
{

    Solution sol;

    vector<int> q = {1, 1, 1, 2, 2, 3};

    return 0;
}
